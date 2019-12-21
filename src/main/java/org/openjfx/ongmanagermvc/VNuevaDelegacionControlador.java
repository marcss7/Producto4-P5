package org.openjfx.ongmanagermvc;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class VNuevaDelegacionControlador implements Initializable {
	
	@FXML
	private Button botonGuardarNuevaDelegacion;

	@FXML
	private Button botonCancelar;

	@FXML
	private TextField campoNombre;
	
	@FXML
	private TextField campoDireccion;
	
	@FXML
	private TextField campoTelefono;
	
	@FXML
	private TextField campoSedeCentral;

	public void guardarDelegacion(ActionEvent event) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ONGUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();

		Delegacion nuevaDelegacion = new Delegacion();
		nuevaDelegacion.setNombreDelegacion(campoNombre.getText());
		nuevaDelegacion.setDireccion(campoDireccion.getText());
		nuevaDelegacion.setTelefono(campoTelefono.getText());
		nuevaDelegacion.setIsSedeCentral(Boolean.parseBoolean(campoSedeCentral.getText()));

		entityManager.persist(nuevaDelegacion);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		
		System.out.println("Has guardado una delegación");
		
		cancelar(event);
		
	}

	public void cancelar(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VAdmin.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Menú administrador");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
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
