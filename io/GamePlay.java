
package model.io;

import java.io.IOException;
import java.util.Objects;

import model.Coordinate;
import model.Game;
import model.exceptions.CollisionMovementException;
import model.exceptions.CurrentPieceNotFixedException;
import model.exceptions.FixedPieceMovementException;
import model.exceptions.GameEndedMovementException;
import model.exceptions.NoCurrentPieceException;
import model.exceptions.OffBoardMovementException;
import model.exceptions.WrongSizeException;
import model.exceptions.io.TetrisIOException;

/**
 * Clase GamePlay
 */

public class GamePlay {
	
	/** Ancho del mapa */
	static final int TETRIS_BOARD_STANDARD_WIDTH = 10;
	
	/** Alto del mapa. */
	static final int TETRIS_BOARD_STANDARD_HEIGHT = 20;
	
	/** Atributo del juego. */
	private Game game;
	
	/** Jugador. */
	IPlayer player;
	
	/** Modo de visualización */
	IVisualizer visualizer;
	
/**
 * Crea un nuevo juego
 *
 * @param p Jugador
 * @param v Visualizador
 * @throws WrongSizeException El tamaño no es adecuado
 */
public GamePlay(IPlayer p, IVisualizer v){
		p = Objects.requireNonNull(p, "El parametro p no puede ser null");
		v = Objects.requireNonNull(v, "El parametro v no puede ser null");
		try {
		player=p;
		visualizer=v;
			Coordinate c=new Coordinate(GamePlay.TETRIS_BOARD_STANDARD_HEIGHT,GamePlay.TETRIS_BOARD_STANDARD_WIDTH);
		game=new Game(c);
		visualizer.setGame(game);
		}
		catch(WrongSizeException e) {
			throw new java.lang.RuntimeException();
		}
	}
	
/**
 * Play.
 *
 * @throws TetrisIOException the tetris IO exception
 * @throws IOException Signals that an I/O exception has occurred.
 * @throws GameEndedMovementException the game ended movement exception
 * @throws CurrentPieceNotFixedException the current piece not fixed exception
 * @throws FixedPieceMovementException the fixed piece movement exception
 * @throws CollisionMovementException the collision movement exception
 * @throws NoCurrentPieceException the no current piece exception
 */
public void play() throws TetrisIOException{
    visualizer.show();
    char move;
    move = player.nextMove();
    while (move != IPlayer.LAST_MOVE) {
       try {
    	switch(move) {
		case 'I': game.nextPiece("I");
		break;
		case 'J' : game.nextPiece("J");
		break;
		case 'L' : game.nextPiece("L");
		break;
		case 'O' : game.nextPiece("O");
		break;
		case 'S' : game.nextPiece("S");
		break;
		case 'T' : game.nextPiece("T");
		break;
		case 'Z' : game.nextPiece("Z");
		break;
		case IPlayer.MOVELEFT : game.moveCurrentPieceLeft();
		break;
		case IPlayer.MOVERIGHT : game.moveCurrentPieceRight();
		break;
		case IPlayer.CLOCKWISE : game.rotateCurrentPieceClockwise();
		break;
		case IPlayer.COUNTERCLOCKWISE : game.rotateCurrentPieceCounterclockwise();
		break;
		case IPlayer.MOVEDOWN : game.moveCurrentPieceDown();
		break;
       }
       }catch(OffBoardMovementException e) {}
       catch(CollisionMovementException e) {}
       catch(FixedPieceMovementException e) {}
       catch(GameEndedMovementException e) {
    	   break;
       }
       catch(NoCurrentPieceException e) {
    	   throw new TetrisIOException("No existe una pieza actual");
       }
       catch(CurrentPieceNotFixedException e) {
    	   throw new TetrisIOException("La pieza actual no esta fijada");
       }
       visualizer.show();
       move = player.nextMove();
    }
}

} // fin de la clase