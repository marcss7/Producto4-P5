package org.openjfx.ongmanagermvc;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Esta clase representa a los socios de la ONG que pagan una cuota
 * periódica la cual puede ser mensual, trimestral o anual.
 * 
 * @author Yaiza, Teresa y Marc.
 * @version 1.0
 *
 */
@Entity
@Table(name="Socios")
public class Socio extends Persona implements Financiador {
	
	// CAMPOS
	private Integer idSocio;
	private TipoAportacion periodicidadCuota;
	private Float importeCuota;
	
	
	// CONSTRUCTORES
	
	/**
	 * Constructor que crea un nuevo objeto Socio sin inicializar sus campos.
	 */
	public Socio() {
		super();
	}

	/**
	 * Constructor que crea un nuevo objeto Socio icializando sus campos.
	 * 
	 * @param nombre Atributo que guarda el nombre de la persona.
	 * @param apellidos Atributo que guarda los apellidos de la persona.
	 * @param id Atributo que guarda el id de la persona.
	 * @param email Atributo que guarda el email de la persona.
	 * @param telefono Atributo que guarda el telefono de la persona.
	 * @param direccion Atributo que guarda la direccion de la persona.
	 * @param idSocio Atributo que guarda el id de la persona.
	 * @param periodicidadCuota Atributo que guarda la periodicidad de la cuota de la persona.
	 * @param importeCuota Atributo que guarda el importe de la cuota de la persona.
	 */
	public Socio(String nombre, String apellidos, String id, String email,
			     String telefono, String direccion, Integer idSocio,
			     TipoAportacion periodicidadCuota, Float importeCuota) {
		super(nombre, apellidos, id, email, telefono, direccion);
		this.idSocio = idSocio;
		this.periodicidadCuota = periodicidadCuota;
		this.importeCuota = importeCuota;
	}

	
	// METODOS
	
	/**
	 * Metodo accesor de lectura que nos da el id del socio.
	 * 
	 * @return Nos devuelve el id del socio.
	 */
	@Id
	@Column(name="id_socio")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdSocio() {
		return idSocio;
	}


	/**
	 * Metodo accesor de escritura que asigna el id del socio.
	 * 
	 * @param idSocio El id del socio
	 */
	public void setIdSocio(Integer idSocio) {
		this.idSocio = idSocio;
	}

	/**
	 * Metodo accesor de lectura que nos da la periodicidad de la cuota del socio.
	 * 
	 * @return Nos devuelve la periodicidad de la cuota.
	 */
	@Transient
	public TipoAportacion getPeriodicidadCuota() {
		return periodicidadCuota;
	}

	/**
	 * Metodo accesor de escritura que asigna la periodicidad de la cuota del socio.
	 * 
	 * @param periodicidadCuota La periodicidad de la cuota.
	 */
	public void setPeriodicidadCuota(TipoAportacion periodicidadCuota) {
		this.periodicidadCuota = periodicidadCuota;
	}
	
	/**
	 * Metodo accesor de lectura que nos da el imporye de la cuota del socio.
	 * 
	 * @return Nos devuelve el importe de la cuota.
	 */
	@Column(name="importe_cuota")
	public Float getImporteCuota() {
		return importeCuota;
	}

	/**
	 * Metodo accesor de escritura que asigna el importe de la cuota del socio.
	 * 
	 * @param importe_cuota El importe de la cuota.
	 */
	public void setImporteCuota(Float importeCuota) {
		this.importeCuota = importeCuota;
	}
	
	@Column(name="cuota")
	public String getCodigoPeriodicidadCuota() {
		
		String codigoPeriodicidadCuota = null;
		
		switch (this.getPeriodicidadCuota()) {
			case MENSUAL:
				codigoPeriodicidadCuota = "M";
				break;
	
			case TRIMESTRAL:
				codigoPeriodicidadCuota = "T";
				break;
	
			case ANUAL:
				codigoPeriodicidadCuota = "A";
				break;
	
			default:
				break;
		}
		
		return codigoPeriodicidadCuota;
	}

	public void setCodigoPeriodicidadCuota(String periodicidadCuota) {
		
		switch (periodicidadCuota) {
			case "M":
				setPeriodicidadCuota(TipoAportacion.MENSUAL);
				break;
	
			case "T":
				setPeriodicidadCuota(TipoAportacion.TRIMESTRAL);
				break;
	
			case "A":
				setPeriodicidadCuota(TipoAportacion.ANUAL);
				break;
	
			default:
				break;
		}
	}

	/**
	 * Metodo que permite al socio hacer una aportacion a la ONG.
	 * 
	 * @param listadoIngresos Listado de ingresos de la ONG.
	 */
	@Override
	public void realizarAportacion(ArrayList<Ingreso> listadoIngresos) {
		// TODO Auto-generated method stub
		
	}
	
	/**
     * Crea una cadena de caracteres con los datos del socio.
     * 
     * @return Cadena con los datos del socio.
     */
	@Override
	public String toString() {
		return this.nombre + " " + this.apellidos + " (ID - " + this.idSocio + ")";
	}

}
