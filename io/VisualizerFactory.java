package model.io;

import model.exceptions.io.TetrisIOException;

/**
 * Creador de visualizadores
 */
public class VisualizerFactory {
	
	/**
	 * Crea visualizadores
	 */
	public VisualizerFactory() {}
	
	/**
	 * Crea un nuevo visualizador
	 *
	 * @param s el visualizador a crear
	 * @return el visualizador
	 * @throws TetrisIOException the tetris IO exception
	 */
	public static IVisualizer createVisualizer(String s) throws TetrisIOException {

		if(s == "console") {
		return new VisualizerConsole();
		}
		else if(s == "window") {
			return new VisualizerWindow();
		}
		else {
			throw new TetrisIOException("El paramentro pasado a createVisualizer no es igual a console o window");
		}
	}
}
