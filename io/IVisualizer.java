package model.io;

import model.Game;
import model.exceptions.WrongSizeException;

/**
 * Interfaz del visualizador
 */
public interface IVisualizer {
	
	/**
	 * Asigna un juego
	 *
	 * @param g Juego donde se almacenará
	 * @throws WrongSizeException the wrong size exception
	 */
	public void setGame(Game g) throws WrongSizeException;
	
	/**
	 * Mostrar el juego
	 */
	public void show();
}
