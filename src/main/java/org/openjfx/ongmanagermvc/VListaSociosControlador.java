package org.openjfx.ongmanagermvc;

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
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class VListaSociosControlador implements Initializable{
	
	@FXML
	private TableView<Socio> table;
	@FXML
	private TableColumn<Socio, Integer> idSocio = new TableColumn<>("Id");
	@FXML
	private TableColumn<Socio, String> nombre  = new TableColumn<>("Nombre");
	@FXML
	private TableColumn<Socio, String> apellidos  = new TableColumn<>("Apellidos");
	@FXML
	private TableColumn<Socio, String> nif = new TableColumn<>("NIF");
	@FXML
	private TableColumn<Socio, String> email = new TableColumn<>("Email");
	@FXML
	private TableColumn<Socio, String> telefono = new TableColumn<>("Teléfono");
	@FXML
	private TableColumn<Socio, String> direccion = new TableColumn<>("Dirección");
	@FXML
	private TableColumn<Socio, String> periodicidadCuota = new TableColumn<>("Cuota");
	@FXML
	private TableColumn<Socio, Float> importeCuota = new TableColumn<>("Importe");
	
	@FXML
	private Button botonEditar;
	
	@FXML
	private Button botonCancelar;
	
	
	public ObservableList<Socio> getSocios() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ONGUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Socio> ls = entityManager.createQuery("from Socio").getResultList();
		ObservableList<Socio> socios = FXCollections.observableArrayList(ls);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		return socios;
	}
	
	public void editarSocio(ActionEvent event) {
		System.out.println("Vas a editar un socio.");
	}
	
	public void cancelar(ActionEvent event) {
		VInicioControlador.abrirOtraVista(event, "VEmpleado.fxml", "Menú Empleado");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		idSocio.setCellValueFactory(new PropertyValueFactory<Socio, Integer>("idSocio"));
		nombre.setCellValueFactory(new PropertyValueFactory<Socio, String>("nombre"));
		apellidos.setCellValueFactory(new PropertyValueFactory<Socio, String>("apellidos"));
		nif.setCellValueFactory(new PropertyValueFactory<Socio, String>("id"));
		telefono.setCellValueFactory(new PropertyValueFactory<Socio, String>("telefono"));
		direccion.setCellValueFactory(new PropertyValueFactory<Socio, String>("direccion"));
		email.setCellValueFactory(new PropertyValueFactory<Socio, String>("email"));
		periodicidadCuota.setCellValueFactory(new PropertyValueFactory<Socio, String>("periodicidadCuota"));
		importeCuota.setCellValueFactory(new PropertyValueFactory<Socio, Float>("importeCuota"));
		importeCuota.setStyle("-fx-alignment: CENTER-RIGHT;");
		table.setItems(getSocios());
	}

}
