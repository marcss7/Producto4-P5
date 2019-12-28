package org.openjfx.ongmanagermvc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class VAdminControlador implements Initializable {
	
	@FXML
	private Button botonNuevoTrabajador;

	@FXML
	private Button botonListarTrabajadores;
	
	@FXML
	private Button botonNuevaDelegacion;

	@FXML
	private Button botonListarDelegaciones;

	@FXML
	private Button botonCancelar;

	public void abrirNuevoTrabajador(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VNuevoTrabajador.fxml", "Nuevo trabajador");
	}

	public void abrirListarTrabajadores(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VListaTrabajadores.fxml", "Listado trabajadores");
	}
	
	public void abrirNuevaDelegacion(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VNuevaDelegacion.fxml", "Nueva delegación");
	}

	public void abrirListarDelegaciones(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VListaDelegaciones.fxml", "Listado delegaciones");
	}

	public void cancelar(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VInicio.fxml", "ONGManager");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
