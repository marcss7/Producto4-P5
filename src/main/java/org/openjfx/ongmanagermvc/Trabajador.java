package org.openjfx.ongmanagermvc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase representa a cada uno de los miembros del personal de la ONG
 * que tienen un contrato de trabajo y tienen un horario laboral.
 * 
 * @author Yaiza, Teresa y Marc.
 * @version 1.0
 *
 */
@Entity
@Table(name="Trabajadores")
public class Trabajador extends Personal {

	// CAMPOS

	private String horarioLaboral;
	private String pass;
	private Integer idTrabajador;


	// CONSTRUCTORES

	/**
	 * Constructor que crea un nuevo objeto Trabajador sin inicializar sus campos.
	 * 
	 */
	public Trabajador() {
		super();
	}

	/**
	 * Constructor que crea un nuevo objeto Trabajador inicializando sus campos.
	 * 
	 * @param nombre Atributo que guarda el nombre de la persona.
	 * @param apellidos Atributo que guarda los apellidos de la persona.
	 * @param id Atributo que guarda el id de la persona.
	 * @param email Atributo que guarda el email de la persona.
	 * @param telefono Atributo que guarda el telefono de la persona.
	 * @param direccion Atributo que guarda la direccion de la persona.
	 * @param delegacionAsignada Atributo que guarda el nombre de la delegacion asignada a la persona.
	 * @param antiguedad Atributo que guarda la antiguedad en la ong de la persona.
	 * @param proyectosAsignados Atributo que guarda los proyectos asignados a la persona.
	 * @param horarioLaboral Atributo que guarda el horario laboral de la persona.
	 * @param pass Atributo que guarda la password de loggin de la persona.
	 * @param id_trabajador Atributo que guarda el id del trabajador.
	 */
	public Trabajador(String nombre, String apellidos, String id, String email,
					  String telefono, String direccion, Integer delegacionAsignada,
					  Date antiguedad, ListadoProyectos proyectosAsignados,
					  String horarioLaboral, String pass, Integer idTrabajador) {
		super(nombre, apellidos, id, email, telefono, direccion, delegacionAsignada, antiguedad, proyectosAsignados);
		this.horarioLaboral = horarioLaboral;
		this.pass = pass;
		this.idTrabajador = idTrabajador;
	}


	// MÉTODOS

	/**
	 * Metodo accesor de lectura que nos da el horario laboral del trabajador.
	 * 
	 * @return Nos devuelve el horario laboral del trabajador.
	 */
	@Column(name="horario_laboral")
	public String getHorarioLaboral() {
		return horarioLaboral;
	}


	/**
	 * Metodo accesor de escritura que asigna el horario laboral del trabajador.
	 * 
	 * @param horarioLaboral El horario laboral del trabajador.
	 */
	public void setHorarioLaboral(String horarioLaboral) {
		this.horarioLaboral = horarioLaboral;
	}


	/**
	 * Metodo accesor de lectura que nos da la password del trabajador.
	 * 
	 * @return Nos devuelve la password del trabajador.
	 */
	@Column(name="pass")
	public String getPass() {
		return pass;
	}

	/**
	 * Metodo accesor de lectura que asigna la password del trabajador.
	 * 
	 * @param pass La password del trabajador.
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * Metodo accesor de lectura que nos da el id del trabajador.
	 * 
	 * @return Nos devuelve el id del trabajador.
	 */
	@Id
	@Column(name="id_trabajador")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdTrabajador() {
		return idTrabajador;
	}

	/**
	 * Metodo accesor de lectura que asigna el id del trabajador.
	 * 
	 * @param id_trabajador El id del trabajador.
	 */
	public void setIdTrabajador(Integer idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	/**
	 * Crea una cadena de caracteres con los datos del trabajador.
	 * 
	 * @return Cadena con los datos del trabajador.
	 */
	@Override
	public String toString() {
		return this.nombre + " " + this.apellidos + " (ID empleado - " + this.id + ")";
	}
	
}
