package model.io;

import java.util.Objects;

import model.Coordinate;
import model.Game;
import model.exceptions.WrongSizeException;

/**
 * Clase del visualizador por consola
 */
public class VisualizerConsole implements IVisualizer {

	/** El juego */
	private Game game;
	
	/**
	 * Crea un nuevo visualizador por consola
	 */
	VisualizerConsole(){
		game=null;
	}

	/**
	 * Asignador del juego
	 *
	 * @param g Asigna el juego
	 * @throws WrongSizeException the wrong size exception
	 */
	public void setGame(Game g) throws WrongSizeException {
		g = Objects.requireNonNull(g, "El parametro g no puede ser null");
		if(g.getGameboard().getHeight() != GamePlay.TETRIS_BOARD_STANDARD_HEIGHT || g.getGameboard().getWidth() != GamePlay.TETRIS_BOARD_STANDARD_WIDTH) {
			throw new WrongSizeException(new Coordinate(g.getGameboard().getHeight(),g.getGameboard().getWidth()));
		}
		game=g;
	}
	
	/**
	 * Show.
	 */
	public void show() {
		game = Objects.requireNonNull(game, "Game no puede ser null");
		System.out.println(game.toString());
	}

}
