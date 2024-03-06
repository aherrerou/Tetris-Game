package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class FixedPieceMovementException.
 */
public class FixedPieceMovementException extends MovementException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new fixed piece movement exception.
	 */
	public FixedPieceMovementException() {
		super();
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		String mensaje="La pieza no se puede mover porque ya está fijada";
		return mensaje;
	}

}