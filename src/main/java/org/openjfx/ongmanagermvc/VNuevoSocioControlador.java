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
	private ComboBox<String> campoTipoCuota;
	
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
		
		switch (campoTipoCuota.getSelectionModel().getSelectedItem().toString()) {
			case "A":
				nuevoSocio.setPeriodicidadCuota(TipoAportacion.MENSUAL);
				break;
		
			case "M":
				nuevoSocio.setPeriodicidadCuota(TipoAportacion.TRIMESTRAL);
				break;
			case "T":
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
		VInicioControlador.abrirOtraVista(event, "VEmpleado.fxml", "Menú Empleado");
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		campoTipoCuota.setItems(FXCollections.observableArrayList("A", "M", "T"));

	}

}
