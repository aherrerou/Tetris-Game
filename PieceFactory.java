package model;

import java.util.Objects;

/**
 * A factory for creating Piece objects.
 */
public class PieceFactory {
	
/**
 * Instantiates a new piece factory.
 */
public PieceFactory(){
		
}
	
/**
 * Creates a new Piece object.
 *
 * @param s the s
 * @return the piece
 */
public static Piece createPiece(String s) {
s = Objects.requireNonNull(s, "El parametro 's' no puede ser null");
	Piece p;
		if(s.equals("I")) {
			p=new IPiece();
		}
		else if(s.equals("J")) {
			p=new JPiece();
		}
		else if(s.equals("L")) {
			p=new LPiece();
		}
		else if(s.equals("O")) {
			p=new OPiece();
		}
		else if(s.equals("S")) {
			p=new SPiece();
		}
		else if(s.equals("T")) {
			p=new TPiece();
		}
		else if(s.equals("Z")) {
			p=new ZPiece();
		}
		
		else {
			p=null;
		}
		return p;
	}
}
