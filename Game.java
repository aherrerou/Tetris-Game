package model;

import java.util.Objects;

import model.exceptions.*;

// TODO: Auto-generated Javadoc
/**
 * Clase Game, se encarga de controlar la partida, saber si esta terminado o no el juego y de fijar las piezas en el tablero.
 */
public class Game {
	
	/**  Indica si el juego esta acabado o no. */
	private boolean gameEnded;
	
	/** Indica la posicion actual. */
	private Coordinate currentPosition;
	
	/** Indica la pieza actual. */
	private Piece currentPiece;
	
	/** Tablero del juego. */
	private Gameboard board;
	
/**
 * Constructor del juego.
 *
 * @param c Coordenada que le pasamos a partir de la cual crear el tablero del juego
 * @throws WrongSizeException the wrong size exception
 */
public Game(Coordinate c) throws WrongSizeException {
	c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
	board=new Gameboard(c);
}

/**
 * Comprueba si el juego ha acabado.
 *
 * @return Devuelve cierto si el juego ha finalizado
 */
public boolean isGameEnded() {
	return gameEnded;
}

/**
 * Devuelve si la pieza esta fija o no.
 *
 * @return Devuelve si esta fija la pieza a true y false cuando no lo esta
 * @throws NoCurrentPieceException the no current piece exception
 */
public boolean isCurrentPieceFixed() throws NoCurrentPieceException {
boolean fixed=false;
	if(currentPiece == null) {
		throw new NoCurrentPieceException();
	}
	if(currentPiece.isFixed()) {
		fixed=true;
	}
return fixed;
}

/**
 * Lanza otra pieza D0 al tablero.
 *
 * @param type Tipo de pieza a crear
 * @return Devuelve true si la pieza se ha insertado bien
 * @throws GameEndedMovementException the game ended movement exception
 * @throws CurrentPieceNotFixedException the current piece not fixed exception
 */
public boolean nextPiece(String type) throws GameEndedMovementException, CurrentPieceNotFixedException {
type = Objects.requireNonNull(type, "El parametro 'type' no puede ser null");
boolean valid=true;
	
if(isGameEnded()) {
	throw new GameEndedMovementException();
}
	if(currentPiece != null && currentPiece.isFixed()==false) {
		throw new CurrentPieceNotFixedException();
	}
		currentPosition = new Coordinate(0, board.getWidth()/2 - 2 );
		currentPiece = PieceFactory.createPiece(type);
		if(board.isPlaceValid(currentPosition, currentPiece)) {
			if(board.isPlaceFree(currentPosition, currentPiece)) {
				board.putPiece(currentPosition,currentPiece);
			}
			else {
				gameEnded=true;
				valid=false;
			}
		}
		else {
			gameEnded=true;
			valid=false;
		}
	return valid;
}

/**
 * Calcula la nueva posicion a la izquierda.
 *
 * @param c Coordenada en la que se basa
 * @return Nueva posicion de la coordenada
 */
private Coordinate calculateNewPositionLeft(Coordinate c) {
	
	Coordinate newPosition = new Coordinate(c.getRow(),c.getColumn()-1); //ponemos -1 en column para que vaya una posicion hacia la izquierda
	return newPosition;
	
}

/**
 * Mover la pieza a la izquierda.
 *
 * @throws NoCurrentPieceException the no current piece exception
 * @throws GameEndedMovementException the game ended movement exception
 * @throws FixedPieceMovementException the fixed piece movement exception
 * @throws OffBoardMovementException the off board movement exception
 * @throws CollisionMovementException the collision movement exception
 */
public void moveCurrentPieceLeft() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {

if(currentPiece == null) {
	throw new NoCurrentPieceException();
}
	if(isGameEnded()) {
		throw new GameEndedMovementException();
	}
		if(isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		Coordinate newPosition=calculateNewPositionLeft(currentPosition);	
			if(board.isPlaceValid(newPosition, currentPiece)==false) {
				throw new OffBoardMovementException(newPosition);
			}
				if(board.isPlaceFree(newPosition, currentPiece)==false) {
					throw new CollisionMovementException(newPosition);
				}
					board.removePiece(currentPiece);
					board.putPiece(newPosition, currentPiece);
					currentPosition = newPosition;

}	

/**
 * Calcula la nueva posicion a la derecha.
 *
 * @param c Coordenada en la que se basa
 * @return La nueva posicion de la coordenada
 */
private Coordinate calculateNewPositionRight(Coordinate c) {
	
	Coordinate newPosition = new Coordinate(c.getRow(),c.getColumn()+1); //ponemos +1 en column para que vaya una posicion hacia la derecha
	return newPosition;
	
}

/**
 * Mueve la pieza a la derecha.
 *
 * @throws NoCurrentPieceException the no current piece exception
 * @throws GameEndedMovementException the game ended movement exception
 * @throws OffBoardMovementException the off board movement exception
 * @throws FixedPieceMovementException the fixed piece movement exception
 * @throws CollisionMovementException the collision movement exception
 */
public void moveCurrentPieceRight() throws NoCurrentPieceException, GameEndedMovementException, OffBoardMovementException, FixedPieceMovementException, CollisionMovementException {
	if(currentPiece == null) {
		throw new NoCurrentPieceException();
	}
	if(isGameEnded()) {
		throw new GameEndedMovementException();
	}
		if(isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
		Coordinate newPosition=calculateNewPositionRight(currentPosition);
			if(board.isPlaceValid(newPosition, currentPiece)==false) {
				throw new OffBoardMovementException(newPosition);
			}
				if(board.isPlaceFree(newPosition, currentPiece)==false) {
					throw new CollisionMovementException(newPosition);
				}
					board.removePiece(currentPiece);
					board.putPiece(newPosition, currentPiece);
					currentPosition = newPosition;	
}

/**
 * Rota la pieza en sentido contrario a las agujas del reloj.
 *
 * @throws OffBoardMovementException the off board movement exception
 * @throws FixedPieceMovementException the fixed piece movement exception
 * @throws GameEndedMovementException the game ended movement exception
 * @throws CollisionMovementException the collision movement exception
 * @throws NoCurrentPieceException the no current piece exception
 */
public void rotateCurrentPieceCounterclockwise() throws OffBoardMovementException, FixedPieceMovementException, GameEndedMovementException, CollisionMovementException, NoCurrentPieceException { //optimizar el codigo crean un objeto Piece nuevo y asignandole la rotacion para comprobar isPlaceValid, isPlaceFree
if(currentPiece == null) {
	throw new NoCurrentPieceException();
}
	if(isGameEnded()) {
		throw new GameEndedMovementException();
	}
		
		if(isCurrentPieceFixed()) {
			throw new FixedPieceMovementException();
		}
			currentPiece.rotateCounterclockwise();
			if(board.isPlaceValid(currentPosition, currentPiece)==false) {
				currentPiece.rotateClockwise();
				throw new OffBoardMovementException(currentPosition);
			}
				if(board.isPlaceFree(currentPosition, currentPiece)==false) {
					currentPiece.rotateClockwise();
					throw new CollisionMovementException(currentPosition);
				}
			currentPiece.rotateClockwise(); // lo pongo en su posicion original para eliminarlo
			board.removePiece(currentPiece);
			currentPiece.rotateCounterclockwise(); //lo coloco en su posicion requerida para añadirlo
			board.putPiece(currentPosition, currentPiece);
	
}

/**
 * Rotar la pieza en el sentido de las agujas del reloj.
 *
 * @throws CollisionMovementException the collision movement exception
 * @throws OffBoardMovementException the off board movement exception
 * @throws NoCurrentPieceException the no current piece exception
 * @throws GameEndedMovementException the game ended movement exception
 * @throws FixedPieceMovementException the fixed piece movement exception
 */
public void rotateCurrentPieceClockwise() throws CollisionMovementException, OffBoardMovementException, NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException {  //optimizar el codigo crean un objeto Piece nuevo y asignandole la rotacion para comprobar isPlaceValid, isPlaceFree
	if(currentPiece == null) {
		throw new NoCurrentPieceException();
	}
		if(isGameEnded()) {
			throw new GameEndedMovementException();
		}	
			if(isCurrentPieceFixed()) {
				throw new FixedPieceMovementException();
			}
			currentPiece.rotateClockwise();
			if(board.isPlaceValid(currentPosition, currentPiece)==false) {
				currentPiece.rotateCounterclockwise();
				throw new OffBoardMovementException(currentPosition);
			}
				if(board.isPlaceFree(currentPosition, currentPiece)==false) {
					currentPiece.rotateCounterclockwise();
					throw new CollisionMovementException(currentPosition);
				}

			currentPiece.rotateCounterclockwise();
			board.removePiece(currentPiece);
			currentPiece.rotateClockwise();
			board.putPiece(currentPosition,currentPiece);
}

/**
 * Calcula la nueva posicion hacia abajo.
 *
 * @param c Coordenada en la que se basa
 * @return La nueva posicion de la coordenada
 */
private Coordinate calculateNewPositionDown(Coordinate c) {
	
	Coordinate newPosition = new Coordinate(c.getRow()+1,c.getColumn()); //ponemos +1 en row para que vaya una posicion hacia abajo
	return newPosition;
	
}

/**
 * Mueve la pieza hacia abajo.
 *
 * @throws NoCurrentPieceException the no current piece exception
 * @throws GameEndedMovementException the game ended movement exception
 * @throws FixedPieceMovementException the fixed piece movement exception
 * @throws OffBoardMovementException the off board movement exception
 * @throws CollisionMovementException the collision movement exception
 */
public void moveCurrentPieceDown() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {
if(currentPiece != null) {
	boolean stop=false;	
	if(!isGameEnded()) {
		if(!isCurrentPieceFixed()) {
			Coordinate newPosition=calculateNewPositionDown(currentPosition);
			if(board.isPlaceFree(newPosition, currentPiece)) {
				if(board.isPlaceValid(newPosition, currentPiece)) {
					board.removePiece(currentPiece);
					board.putPiece(newPosition, currentPiece);
					currentPosition = newPosition;
				}
				else {
					stop=true;
				}
			}
			else {
				stop=true;
			}
		}
		else {
			throw new FixedPieceMovementException();
		}
	}
	else {
		throw new GameEndedMovementException();
	}
	if(stop) {
		currentPiece.setFixed(true);
		int fila=board.firstRowFullFromBottom();
		while(fila != -1) {
		board.clearRow(fila);
		board.makeUpperRowsFall(fila);
		fila=board.firstRowFullFromBottom();
		}
	}	
	
}
else {
	throw new NoCurrentPieceException();
}
}

/**
 * Muestra el tablero usando el toString de la clase GameBoard.
 *
 * @return Devuelve el tablero
 */
public String toString() {
	return board.toString();
}

//******************************************
//*NUEVAS IMPLEMENTACIONES DE LA PRACTICA 3*
//******************************************
/**
 * Se encarga de devolver el tablero.
 *
 * @return Devuelve el tablero
 */
public Gameboard getGameboard() {
	return board;
}

}//fin de la clase
