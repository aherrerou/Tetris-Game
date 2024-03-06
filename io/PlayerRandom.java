package model.io;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import model.exceptions.io.TetrisIOException;

/**
 * La clase del jugador aleatorio
 */
public class PlayerRandom implements IPlayer {
	
	/** Aleatorio */
	private Random random;
	
	/** Si sacamos proxima pieza */
	private Boolean nextPutPiece=true;;
	
	/** El contador de movimientos abajo */
	private int downCounter=0;
	
	/**
	 * Crea un nuevo jugador a partir de una semilla
	 *
	 * @param l la semilla
	 */
	PlayerRandom(long l){
		l = Objects.requireNonNull(l, "El parámetro num no puede ser null.");
		random = new Random();
		random.setSeed(l);
	}
	
	/**
	 * Proximo movimiento
	 *
	 * @return El proximo movimiento
	 * @throws TetrisIOException the tetris IO exception
	 */
	public char nextMove() throws TetrisIOException {
		
		char c='n';
		if(downCounter == GamePlay.TETRIS_BOARD_STANDARD_HEIGHT) {
			nextPutPiece=true;
			downCounter=0;
		}
		if(nextPutPiece) {
			int npt=random.nextInt(8);
				switch(npt) {
					case 0 : c='I'; nextPutPiece=false;
					break;
					case 1 :c='J'; nextPutPiece=false;
					break;
					case 2 :c='L'; nextPutPiece=false;
					break;
					case 3 :c='O'; nextPutPiece=false;
					break;
					case 4 :c='S'; nextPutPiece=false;
					break;
					case 5 :c='T'; nextPutPiece=false;
					break;
					case 6 :c='Z'; nextPutPiece=false;
					break;
					case 7 :c=LAST_MOVE; nextPutPiece=false;
					break;
					default: throw new TetrisIOException(Character.toString(c));
				}
			}
		else {
			int npf=random.nextInt(10);
				switch(npf) {
					case 0 : c=MOVELEFT;
					break;
					case 1 :c=MOVERIGHT;
					break;
					case 2 :c=CLOCKWISE;
					break;
					case 3 :c=COUNTERCLOCKWISE;
					break;
					case 4 :c=MOVEDOWN;downCounter++;
					break;
					case 5 :c=MOVEDOWN;downCounter++;
					break;
					case 6 :c=MOVEDOWN;downCounter++;
					break;
					case 7 :c=MOVEDOWN;downCounter++;
					break;
					case 8 :c=MOVEDOWN;downCounter++;
					break;
					case 9 :c=MOVEDOWN;downCounter++;
					break;
					default: throw new TetrisIOException(Character.toString(c));
				}
		}
		return c;
	}
}
