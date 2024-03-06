package model.io;

import java.io.IOException;

import model.exceptions.io.TetrisIOException;

/**
 * Interfaz del jugador
 */
public interface IPlayer {

	/** Ultimo movimiento. */
	public static char LAST_MOVE = '●';
	
	/** Rotacion en agujas del reloj. */
	public static char CLOCKWISE = '↻';
	
	/** Rotacion en contra de las agujas del reloj */
	public static char COUNTERCLOCKWISE = '↺';
	
	/** Movimiento a la derecha. */
	public static char MOVERIGHT = '→';
	
	/** Movimiento a la izquierda. */
	public static char MOVELEFT = '←';
	
	/** Moviendo hacia abajo. */
	public static char MOVEDOWN = '↓';

/**
 * Proximo movimiento
 *
 * @return Caracter siguiente
 * @throws TetrisIOException the tetris IO exception
 */
public char nextMove() throws TetrisIOException;

}