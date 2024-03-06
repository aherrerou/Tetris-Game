package model.io;
import java.io.IOException;
import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * La clase del jugador mediante string
 */
public class PlayerString implements IPlayer{

	/** Los movimientos */
	private String moves;
	
	/** Donde nos encontramos */
	private int currentMove=0;
	
	/**
	 * Crea un nuevo jugador string
	 *
	 * @param s Los movimientos
	 */
	PlayerString (String s) {
		s = Objects.requireNonNull(s, "El parametro 's' no puede ser null");
		moves=s;
	}
	
	/**
	 * Proximo movimiento
	 *
	 * @return el proximo movimiento
	 * @throws TetrisIOException the tetris IO exception
	 */
public char nextMove() throws TetrisIOException {
	
	char caracter = 'n';
	int tamanyo=moves.length();
		if(currentMove < tamanyo) {
			caracter=moves.charAt(currentMove);
			currentMove++;
		}
		if(currentMove == tamanyo && caracter == 'n') {
			caracter=LAST_MOVE;
		}
		if(caracter != LAST_MOVE && caracter != CLOCKWISE && caracter != COUNTERCLOCKWISE && caracter != MOVEDOWN && caracter != MOVELEFT && caracter != MOVERIGHT && caracter != 'I' && caracter != 'J' && caracter != 'L' && caracter != 'O' && caracter != 'S' && caracter != 'T' && caracter != 'Z' ){
			throw new TetrisIOException(moves);
		}
	return caracter;
	}

} // fin de clase
