package model.exceptions;

import model.Coordinate;

// TODO: Auto-generated Javadoc
/**
 * The Class OffBoardMovementException.
 */
public class OffBoardMovementException extends MovementException {
	
	/** The c. */
	private Coordinate c;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new off board movement exception.
	 *
	 * @param c the c
	 */
	public OffBoardMovementException(Coordinate c) {
		this.c = c;
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		String mensaje="La pieza que intentas mover en la coordenada:"+c+" se sale del tablero";
		return mensaje;
	}
}
