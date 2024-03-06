package model.exceptions.io;

import java.util.Objects;

import model.exceptions.TetrisException;

/**
 * Clase de la excepcion TetrisIOException
 */
public class TetrisIOException extends TetrisException {
	
	/** Mensaje que define la excepcion */
	private String message;
	
	/** Utilizado para arreglar la clase */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Cualquier error con el IO
	 *
	 * @param s Error que ha obtenido
	 */
	public TetrisIOException(String s) {
		s = Objects.requireNonNull(s, "El parametro s no puede ser null");
		this.message = s;
	}
	
	/**
	 * Se encarga de devolver la explicación de la excepción
	 * @return devuelve el string
	 */
	public String getMessage(){
		return message;
	}
}
