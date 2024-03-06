package model.exceptions;

import model.Coordinate;

// TODO: Auto-generated Javadoc
/**
 * The Class WrongSizeException.
 */
public class WrongSizeException extends TetrisException {
	
	/** The c. */
	private Coordinate c;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new wrong size exception.
	 *
	 * @param c the c
	 */
	public WrongSizeException(Coordinate c) {
		this.c=c;
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		String mensaje="El tamñaño del tablero no es el adecuado empezado desde la coordenada: "+c;
		return mensaje;
	}

}