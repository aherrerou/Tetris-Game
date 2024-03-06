package model.io;

import java.util.Objects;

import org.tetrisgui.TetrisGUI;
import org.tetrisgui.TileType;

import model.Coordinate;
import model.Game;
import model.Gameboard;
import model.Piece;
import model.exceptions.WrongSizeException;

/**
 * The Class VisualizerWindow.
 */
public class VisualizerWindow implements IVisualizer {

	/** The milliseconds between moves. */
	private static int MILLISECONDS_BETWEEN_MOVES= 50;
	
	/** The game. */
	private Game game;
	
	/** The tetrisgui. */
	private TetrisGUI tetrisgui;

	/**
	 * Instantiates a new visualizer window.
	 */
	VisualizerWindow() {
		game= null;
		tetrisgui = new TetrisGUI();
		tetrisgui.resetGame();
	}

	/**
	 * Sets the game.
	 *
	 * @param game the new game
	 * @throws WrongSizeException the wrong size exception
	 */
	@Override
	public void setGame(Game game) throws WrongSizeException {
		Objects.requireNonNull(game);
		if (game.getGameboard().getHeight() != GamePlay.TETRIS_BOARD_STANDARD_HEIGHT
				|| game.getGameboard().getWidth() != GamePlay.TETRIS_BOARD_STANDARD_WIDTH) {
			throw new WrongSizeException(new Coordinate(game.getGameboard()
					.getHeight(), game.getGameboard().getWidth()));
		}
		this.game = game;
	}

	/**
	 * Show.
	 */
	public void show() {
		Objects.requireNonNull(game);
		tetrisgui.resetGame();
		Gameboard gameBoard = game.getGameboard();

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				Piece p = gameBoard.getCellContent(new Coordinate(i, j));
				if (p != null) {
					TileType tile = null;
					switch (p.getClass().getSimpleName()) {
					case "IPiece":
						tile = TileType.TypeI;
						break;
					case "JPiece":
						tile = TileType.TypeJ;
						break;
					case "LPiece":
						tile = TileType.TypeL;
						break;
					case "OPiece":
						tile = TileType.TypeO;
						break;
					case "SPiece":
						tile = TileType.TypeS;
						break;
					case "TPiece":
						tile = TileType.TypeT;
						break;
					case "ZPiece":
						tile = TileType.TypeZ;
						break;
					}
					tetrisgui.getBoardPanel().setTile(j, i, tile);
				}
			}
		}

		tetrisgui.renderGame();
		try {
			Thread.sleep(MILLISECONDS_BETWEEN_MOVES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
