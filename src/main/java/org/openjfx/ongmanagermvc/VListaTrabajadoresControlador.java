package org.openjfx.ongmanagermvc;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VListaTrabajadoresControlador implements Initializable {

	@FXML
	private TableView<Trabajador> table;
	@FXML
	private TableColumn<Trabajador, Integer> idTrabajador = new TableColumn<>("Id");
	@FXML
	private TableColumn<Trabajador, String> nombre  = new TableColumn<>("Nombre");
	@FXML
	private TableColumn<Trabajador, String> apellidos  = new TableColumn<>("Apellidos");
	@FXML
	private TableColumn<Trabajador, String> nif = new TableColumn<>("NIF");
	@FXML
	private TableColumn<Trabajador, String> email = new TableColumn<>("Email");
	@FXML
	private TableColumn<Trabajador, String> telefono = new TableColumn<>("Teléfono");
	@FXML
	private TableColumn<Trabajador, String> direccion = new TableColumn<>("Dirección");
	@FXML
	private TableColumn<Trabajador, Integer> delegacion = new TableColumn<>("Delegación");
	@FXML
	private TableColumn<Trabajador, Date> antiguedad = new TableColumn<>("Antiguedad");
	@FXML
	private TableColumn<Trabajador, String> horarioLaboral = new TableColumn<>("Horario");
	@FXML
	private TableColumn<Trabajador, String> pass = new TableColumn<>("Contraseña");
	
	@FXML
	private Button botonEditar;
	
	@FXML
	private Button botonCancelar;
	
	
	public ObservableList<Trabajador> getTrabajadores() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ONGUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Trabajador> lt = entityManager.createQuery("from Trabajador").getResultList();
		ObservableList<Trabajador> trabajadores = FXCollections.observableArrayList(lt);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		return trabajadores;
	}
	
	public void editarTrabajador(ActionEvent event) {
		System.out.println("Vas a editar un trabajador.");
	}
	
	public void cancelar(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VAdmin.fxml", "Menú Administrador");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		idTrabajador.setCellValueFactory(new PropertyValueFactory<Trabajador, Integer>("idTrabajador"));
		nombre.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("nombre"));
		apellidos.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("apellidos"));
		nif.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("id"));
		telefono.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("telefono"));
		direccion.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("direccion"));
		email.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("email"));
		antiguedad.setCellValueFactory(new PropertyValueFactory<Trabajador, Date>("antiguedad"));
		delegacion.setCellValueFactory(new PropertyValueFactory<Trabajador, Integer>("delegacionAsignada"));
		horarioLaboral.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("horarioLaboral"));
		pass.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("pass"));
		table.setItems(getTrabajadores());
	}

}
