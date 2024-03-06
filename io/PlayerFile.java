package model.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * La clase del jugador por fichero
 */
public class PlayerFile implements IPlayer{

	/** Lector */
	private BufferedReader br;
	
	/**
	 * Crea un nuevo jugador
	 *
	 * @param b Lector
	 */
	PlayerFile(BufferedReader b){
		b = Objects.requireNonNull(b, "El parametro 'b' no puede ser null");
		br=b;
	}
	
	/**
	 * Proximo movimiento
	 *
	 * @return El proximo movimiento
	 * @throws TetrisIOException the tetris IO exception
	 */
public char nextMove() throws TetrisIOException {
	String linea;
	try {
		linea=br.readLine();
	}
	catch(IOException e) {
		throw new TetrisIOException("Error al leer el fichero");
	}
		if(linea==null) {
			return LAST_MOVE;
		}
			String trozo[];
			trozo=linea.trim().split("\\s+");
			if(trozo.length != 2) {
				throw new TetrisIOException("Contiene mas palabras de las permitidas");
			}
					switch(trozo[0]) {

					case "put" :
								switch(trozo[1]) {
								case "I": return 'I';
								case "J": return 'J';
								case "L": return 'L';
								case "O": return 'O';
								case "S": return 'S';
								case "T": return 'T';
								case "Z": return 'Z';
								default: throw new TetrisIOException("Error de lectura de trozo[2], no contiene las palabras esperadas");
								}
						
					case "rotate" :
								switch(trozo[1]) {
								case "clockwise": return CLOCKWISE;
								case "counterclockwise": return COUNTERCLOCKWISE;
								default: throw new TetrisIOException("Error de lectura de trozo[2], no contiene las palabras esperadas");
								}
						
					case "move":
								switch(trozo[1]) {
								case "left": return MOVELEFT;
								case "right": return MOVERIGHT;
								case "down": return MOVEDOWN;
								default: throw new TetrisIOException("Error de lectura de trozo[2], no contiene las palabras esperadas");
								}
					default: throw new TetrisIOException("Error de lectura de trozo[1], no contiene las palabras esperadas");
					}
					
	}
}
