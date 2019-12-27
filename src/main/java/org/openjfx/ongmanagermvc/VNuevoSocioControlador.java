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


public class VNuevoSocioControlador implements Initializable {
	
	@FXML
	private Button botonGuardarNuevoSocio;

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
	private TextField campoTipoCuota;
	
	@FXML
	private TextField campoImporteCuota;

	public void guardarSocio(ActionEvent event) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ONGUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();

		Socio nuevoSocio = new Socio();
		nuevoSocio.setNombre(campoNombre.getText());
		nuevoSocio.setApellidos(campoApellidos.getText());
		nuevoSocio.setId(campoNif.getText());
		nuevoSocio.setEmail(campoEmail.getText());
		nuevoSocio.setTelefono(campoTelefono.getText());
		nuevoSocio.setDireccion(campoDireccion.getText());
		
		switch (campoTipoCuota.getText().toUpperCase()) {
			case "M":
				nuevoSocio.setPeriodicidadCuota(TipoAportacion.MENSUAL);
				break;
		
			case "T":
				nuevoSocio.setPeriodicidadCuota(TipoAportacion.TRIMESTRAL);
				break;
			case "A":
				nuevoSocio.setPeriodicidadCuota(TipoAportacion.ANUAL);
				break;
			default:
				break;
		}
		
		nuevoSocio.setImporteCuota(Float.parseFloat(campoImporteCuota.getText()));
		
		entityManager.persist(nuevoSocio);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		
		System.out.println("Has guardado un socio");
		
		cancelar(event);
		
	}

	public void cancelar(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VEmpleado.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Menú empleado");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
			stage.setResizable(false);
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
