package org.openjfx.ongmanagermvc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class VEmpleadoControlador implements Initializable {
	
	@FXML
	private Button botonNuevoSocio;

	@FXML
	private Button botonListarSocios;

	@FXML
	private Button botonCancelar;

	public void abrirNuevoSocio(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VNuevoSocio.fxml", "Nuevo socio");
	}

	public void abrirListarSocios(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VListaSocios.fxml", "Lista de socios");
	}

	public void cancelar(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VInicio.fxml", "ONGManager");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
