package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class TetrisException.
 */
public class TetrisException extends java.lang.Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new tetris exception.
	 */
	public TetrisException() {
		super();
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		String mensaje="Error con la clase principal TetrisException";
		return mensaje;
	}

}
