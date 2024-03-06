package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrentPieceNotFixedException.
 */
public class CurrentPieceNotFixedException extends TetrisException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new current piece not fixed exception.
	 */
	public CurrentPieceNotFixedException() {
		super();
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		String mensaje="La pieza actual no se encuentra fijada y se quiere poner en el tablero";
		return mensaje;
	}

}
