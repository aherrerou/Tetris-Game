package model.exceptions;

import model.Coordinate;

/**
 * The Class CollisionMovementException.
 */
public class CollisionMovementException extends MovementException {
	
	/** The c. */
	private Coordinate c;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new collision movement exception.
	 *
	 * @param c the c
	 */
	public CollisionMovementException(Coordinate c) {
		this.c = c;
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		String mensaje="La pieza que intentas mover en la coordenada:"+c+" ya esta ocupada por otra pieza";
		return mensaje;
	}
}
