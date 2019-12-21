package org.openjfx.ongmanagermvc;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VNuevoTrabajadorControlador implements Initializable {
	
	@FXML
	private Button botonGuardarNuevoTrabajador;

	@FXML
	private Button botonCancelar;

	@FXML
	private TextField campoNombre;
	
	@FXML
	private TextField campoApellidos;
	
	@FXML
	private TextField campoNif;
	
	@FXML
	private TextField campoTelefono;
	
	@FXML
	private TextField campoDireccion;
	
	@FXML
	private TextField campoEmail;
	
	@FXML
	private TextField campoDelegacion;
	
	@FXML
	private TextField campoHorario;

	public void guardarTrabajador(ActionEvent event) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ONGUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Trabajador nuevoTrabajador = new Trabajador();
		nuevoTrabajador.setNombre(campoNombre.getText());
		nuevoTrabajador.setApellidos(campoApellidos.getText());
		nuevoTrabajador.setId(campoNif.getText());
		nuevoTrabajador.setEmail(campoEmail.getText());
		nuevoTrabajador.setTelefono(campoTelefono.getText());
		nuevoTrabajador.setDireccion(campoDireccion.getText());
		nuevoTrabajador.setDelegacionAsignada(Integer.parseInt(campoDelegacion.getText()));
		nuevoTrabajador.setHorarioLaboral(campoHorario.getText());
		Date date = new Date();
		nuevoTrabajador.setAntiguedad(date);
		Random random = new Random();
		String pass = String.format("%06d", random.nextInt(1000000));
		nuevoTrabajador.setAntiguedad(date);
		nuevoTrabajador.setPass(pass);
		
		entityManager.persist(nuevoTrabajador);
		
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		
		System.out.println("Has guardado un Trabajador");
		
		cancelar(event);
		
	}

	public void cancelar(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VAdmin.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Menú adiministrador");
			stage.show();
			((Node) (event.getSource())).getScene().getWindow().hide();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
