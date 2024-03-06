package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class GameEndedMovementException.
 */
public class GameEndedMovementException extends MovementException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new game ended movement exception.
	 */
	public GameEndedMovementException() {
		super();
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		String mensaje="La pieza no se puede añadir o mover porque la partida ha finalizado";
		return mensaje;
	}

}