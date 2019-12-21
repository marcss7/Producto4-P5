package org.openjfx.ongmanagermvc;

/**
 * Esta clase representa la excepcion que se lanza cuando el
 * numero de telefono introducido no es valido.
 * 
 * @author Yaiza, Teresa y Marc.
 * @version 1.0
 *
 */
public class TelefonoNoValidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que crea un nuevo objeto TelefonoNoValidoException.
	 * 
	 * @param msj Mensaje de error.
	 */
	public TelefonoNoValidoException(String msj) {
        super(msj);
    }

}
