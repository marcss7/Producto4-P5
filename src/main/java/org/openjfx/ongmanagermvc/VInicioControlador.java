package org.openjfx.ongmanagermvc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class VInicioControlador implements Initializable {

	@FXML
	private Button botonAdministrador;

	@FXML
	private Button botonEmpleado;

	@FXML
	private Button botonSalir;

	public void abrirSesionAdministrador(ActionEvent event) {
		abrirOtraVista(event, "VAdmin.fxml", "Menú Administrador");
	}

	public void abrirSesionEmpleado(ActionEvent event) {
		abrirOtraVista(event, "VEmpleado.fxml", "Menú Empleado");
	}

	public void salir(ActionEvent event) {
		System.exit(0);
	}
	
	public static void abrirOtraVista(ActionEvent event, String vista, String tituloVentana) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(VInicioControlador.class.getResource(vista));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle(tituloVentana);
			stage.getIcons().add(new Image(VInicioControlador.class.getResourceAsStream("icon.png")));
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
