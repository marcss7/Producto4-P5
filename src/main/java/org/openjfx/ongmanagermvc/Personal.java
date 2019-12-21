package org.openjfx.ongmanagermvc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Esta clase representa a cada uno de los individuos que forman parte del personal de la ONG.
 * 
 * @author Yaiza, Teresa y Marc.
 * @version 1.0
 *
 */
@MappedSuperclass
public class Personal extends Persona {

	// CAMPOS
	
	protected Integer delegacionAsignada;
	protected Date antiguedad;
	protected ListadoProyectos proyectosAsignados;

	
	// CONSTRUCTORES
	
	/**
	 * Constructor que crea un nuevo objeto Personal sin inicializar sus campos.
	 */
	public Personal() {
		super();
	}

	/**
	 * Constructor que crea un nuevo objeto Personal inicializando sus campos.
	 * 
	 * @param nombre Atributo que guarda el nombre de la persona.
	 * @param apellidos Atributo que guarda los apellidos de la persona.
	 * @param id Atributo que guarda el id de la persona.
	 * @param email Atributo que guarda el email de la persona.
	 * @param telefono Atributo que guarda el telefono de la persona.
	 * @param direccion Atributo que guarda la direccion de la persona.
	 * @param delegacionAsignada Atributo que guarda el nombre de la delegacion asignada a la persona.
	 * @param antiguedad Atributo que guarda la antiguedad en la ONG de la persona.
	 * @param proyectosAsignados Atributo que guarda los proyectos asignados a la persona.
	 */
	public Personal(String nombre, String apellidos, String id, String email,
			        String telefono, String direccion, Integer delegacionAsignada,
			        Date antiguedad, ListadoProyectos proyectosAsignados) {
		super(nombre, apellidos, id, email, telefono, direccion);
		this.delegacionAsignada = delegacionAsignada;
		this.antiguedad = antiguedad;
		this.proyectosAsignados = proyectosAsignados;
	}

	
	// MÉTODOS
	
	/**
	 * Metodo accesor de lectura que nos da la delegacion asignada a la persona.
	 * 
	 * @return Nos devuelve la delegacion asignada a la persona. 
	 */
	@Column(name="delegacion")
	public Integer getDelegacionAsignada() {
		return delegacionAsignada;
	}

	/**
	 * Metodo accesor de escritura que asigna la delegacion a la persona.
	 * 
	 * @param i La delegacion asignada.
	 */
	public void setDelegacionAsignada(Integer delegacion) {
		this.delegacionAsignada = delegacion;
	}

	/**
	 * Metodo accesor de lectura que nos devuelve la antiguedad en la ONG de la persona.
	 * 
	 * @return Nos devuelve la antiguedad de la persona.
	 */
	@Column(name="antiguedad")
	public Date getAntiguedad() {
		return antiguedad;
	}

	/**
	 * Metodo accesor de escritura que asigna la antiguedad de la persona.
	 * 
	 * @param antiguedad La antiguedad de la persona.
	 */
	public void setAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	/**
	 * Metodo accesor de lectura que nos da el listado de proyectos la persona.
	 * 
	 * @return Nos devuelve el listado de proyectos de la persona.
	 */
	@Transient
	public ListadoProyectos getProyectosAsignados() {
		return proyectosAsignados;
	}

	/**
	 * Metodo accesor de escritura que asigna el listado de proyectos de la persona.
	 * 
	 * @param proyectosAsignados Los proyectos asignados a la persona.
	 */
	public void setProyectosAsignados(ListadoProyectos proyectosAsignados) {
		this.proyectosAsignados = proyectosAsignados;
	}
	
}
