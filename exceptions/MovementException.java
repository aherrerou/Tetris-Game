package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class MovementException.
 */
public class MovementException extends TetrisException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new movement exception.
	 */
	public MovementException() {
		super();
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		String mensaje="El movimiento que está intentando realizar no está permitido";
		return mensaje;
	}

}