package org.openjfx.ongmanagermvc;

import java.net.URL;
import java.util.ResourceBundle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
	private ComboBox<String> campoSedeCentral;

	public void guardarDelegacion(ActionEvent event) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ONGUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();

		Delegacion nuevaDelegacion = new Delegacion();
		nuevaDelegacion.setNombreDelegacion(campoNombre.getText());
		nuevaDelegacion.setDireccion(campoDireccion.getText());
		nuevaDelegacion.setTelefono(campoTelefono.getText());
		
		switch (campoSedeCentral.getSelectionModel().getSelectedItem().toString()) {
		case "Sí":
			nuevaDelegacion.setIsSedeCentral(true);
			break;
	
		case "No":
			nuevaDelegacion.setIsSedeCentral(false);
			break;
		default:
			break;
	}

		entityManager.persist(nuevaDelegacion);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		
		System.out.println("Has guardado una delegación");
		
		cancelar(event);
		
	}

	public void cancelar(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VAdmin.fxml", "Menú Administrador");
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		campoSedeCentral.setItems(FXCollections.observableArrayList("Sí", "No"));

	}

}
