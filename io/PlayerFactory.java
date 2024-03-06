package model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * Donde crearemos los jugadores
 */
public class PlayerFactory {
	
/**
 * Crea un nuevo jugador
 *
 * @param s String del player
 * @return El jugador
 * @throws TetrisIOException the tetris IO exception
 */
public	static IPlayer createPlayer(String s) throws TetrisIOException {
		s = Objects.requireNonNull(s, "El parametro 's' no puede ser null");
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='n' || c=='/' || c=='\\') {
				BufferedReader br;
				try {
					br=new BufferedReader(new FileReader(s));
				}
				catch (FileNotFoundException e) {
					throw new TetrisIOException("Error al crear un buffered reader");
				}
				PlayerFile pf=new PlayerFile(br);
				return pf;
			}
		}
		if(isLong(s)) {
			PlayerRandom pf=new PlayerRandom(Long.parseLong(s));
			return pf;
		}
		if(s=="keyboard") {
			PlayerKeyboard pf=new PlayerKeyboard();
			return pf;
		}
		
		else {
			PlayerString pf=new PlayerString(s);
			return pf;
		}
	}
	
	/**
	 * Comprueba si el número es long
	 *
	 * @param s El string que debe ser un long
	 * @return Si es long o no
	 */
	private static Boolean isLong(String s) {
		s = Objects.requireNonNull(s, "El parametro 's' no puede ser null");
			for(int i=0;i<s.length();i++) {
				if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != '-') {
					return false;
				}
			}
			return true;
	}
}
