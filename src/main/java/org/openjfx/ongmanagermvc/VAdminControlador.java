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
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VNuevoTrabajador.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Nuevo trabajador");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
			stage.show();
			((Node) (event.getSource())).getScene().getWindow().hide();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirListarTrabajadores(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VListaTrabajadores.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Listado trabajadores");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
			stage.show();
			((Node) (event.getSource())).getScene().getWindow().hide();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void abrirNuevaDelegacion(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VNuevaDelegacion.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Nueva delegación");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
			stage.show();
			((Node) (event.getSource())).getScene().getWindow().hide();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirListarDelegaciones(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VListaDelegaciones.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Listado delegaciones");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
			stage.show();
			((Node) (event.getSource())).getScene().getWindow().hide();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cancelar(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VInicio.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("ONGManager");
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
