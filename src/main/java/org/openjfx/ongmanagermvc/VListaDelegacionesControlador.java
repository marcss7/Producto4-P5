package org.openjfx.ongmanagermvc;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class VListaDelegacionesControlador implements Initializable {
	
	@FXML
	private TableView<Delegacion> table;
	@FXML
	private TableColumn<Delegacion, Integer> idDelegacion = new TableColumn<>("Id");
	@FXML
	private TableColumn<Delegacion, String> nombre  = new TableColumn<>("Nombre");
	@FXML
	private TableColumn<Delegacion, String> telefono = new TableColumn<>("Teléfono");
	@FXML
	private TableColumn<Delegacion, String> direccion = new TableColumn<>("Dirección");
	@FXML
	private TableColumn<Delegacion, Boolean> sedeCentral = new TableColumn<>("Sede cental");
	
	@FXML
	private Button botonEditar;
	@FXML
	private Button botonCancelar;
	
	
	public ObservableList<Delegacion> getDelegaciones() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ONGUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Delegacion> ld = entityManager.createQuery("from Delegacion").getResultList();
		ObservableList<Delegacion> delegaciones = FXCollections.observableArrayList(ld);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		return delegaciones;
	}
	
	public void editarDelegacion(ActionEvent event) {
		System.out.println("Vas a editar una delegacion.");
	}
	
	public void cancelar(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VAdmin.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Menú administrador");
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
		idDelegacion.setCellValueFactory(new PropertyValueFactory<Delegacion, Integer>("idDelegacion"));
		nombre.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("nombreDelegacion"));
		telefono.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("telefono"));
		direccion.setCellValueFactory(new PropertyValueFactory<Delegacion, String>("direccion"));
		sedeCentral.setCellValueFactory(new PropertyValueFactory<Delegacion, Boolean>("isSedeCentral"));
		table.setItems(getDelegaciones());
	}

}
