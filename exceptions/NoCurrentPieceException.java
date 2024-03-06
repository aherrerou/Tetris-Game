package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class NoCurrentPieceException.
 */
public class NoCurrentPieceException extends TetrisException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new no current piece exception.
	 */
	public NoCurrentPieceException() {
		super();
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		String mensaje="La partida no ha empezado todavía y por tanto, no hay pieza actual";
		return mensaje;
	}

}
