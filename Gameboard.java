package model;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.function.Predicate;

import model.exceptions.*;

import java.util.Set;
import java.util.Map;
import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * Clase GameBoard.
 */
public class Gameboard {

/**  Altura. */
private int height;

/**  Anchura. */
private int width;

/** Tablero. */
private Map<Coordinate, Piece> gameboard = new HashMap<Coordinate, Piece>();

/**  Minimo de alto. */
private static int MINIMUM_BOARD_HEIGHT=4;

/**  Minimo de ancho. */
private static int MINIMUM_BOARD_WIDTH=4;

/**
 * Contructor del tablero.
 *
 * @param c Coordenada la cual define el tamaño del tablero
 * @throws WrongSizeException the wrong size exception
 */
public Gameboard(Coordinate c) throws WrongSizeException {
	c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
	if(c.getRow()<MINIMUM_BOARD_HEIGHT || c.getColumn()<MINIMUM_BOARD_WIDTH){
		throw new WrongSizeException(c);
	}
	height=c.getRow();
	width=c.getColumn();

}

/**
 * Coloca una pieza en el tablero.
 *
 * @param c Coordenada donde coloca la pieza
 * @param p Pieza que coloca en el tablero
 */
public void putPiece(Coordinate c, Piece p) {
	c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
	p = Objects.requireNonNull(p, "El parametro 'p' no puede ser null");
	Set<Coordinate> cset=p.getAbsoluteCells(c);
	for(Coordinate coordenada: cset) {
		gameboard.put(coordenada,p);
	}
}

/**
 * Comprueba si la posicion donde queremos colocar la pieza es valida.
 *
 * @param c Coordenada para ver si es validad
 * @param p Pieza que iria en esa coordenada
 * @return valid, si la pieza es valida
 */

public boolean isPlaceValid(Coordinate c, Piece p) {
	c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
	p = Objects.requireNonNull(p, "El parametro 'p' no puede ser null");
	boolean valid=true;
	for (Coordinate coord: p.getAbsoluteCells(c) ) {
		int cheight=coord.getRow();
		int cwidth=coord.getColumn();
		//system.out.println(cheight);
		//system.out.println(cwidth);
		if(cheight<0 || cwidth<0 || cheight > height-1 || cwidth > width-1) {
			valid = false;
		}
	}
return valid;
}

/**
 * Comprueba si la posicion esta libre.
 *
 * @param c Coordenada donde queremos saber si es libre
 * @param p Pieza que queremos saber
 * @return valid, si la posicion es cierta
 */
public boolean isPlaceFree(Coordinate c, Piece p) {
	c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
	p = Objects.requireNonNull(p, "El parametro 'p' no puede ser null");
Boolean valid=true;
	Set<Coordinate> cset=p.getAbsoluteCells(c);
	for(Coordinate coordenada: cset) { 
		Piece pieza=gameboard.get(coordenada);
			if(pieza != null && pieza.isFixed()) {
			valid=false;
			}
	}
	return valid;
}

/**
 * Elimina la pieza.
 *
 * @param p Pieza a eliminar
 */
public void removePiece(Piece p) {
	p = Objects.requireNonNull(p, "El parametro 'p' no puede ser null");
Iterator<Entry<Coordinate, Piece>> datos = gameboard.entrySet().iterator();
 
while (datos.hasNext()) {
	Entry<Coordinate, Piece> entry = datos.next();
	if (entry.getValue() == p) {
		datos.remove();
	}
}
}

/**
 * Devuelve la pieza que que hay en la coordenada que se le pasa.
 *
 * @param c Coordenada donde mirara la pieza
 * @return pieza Pieza que se ha encontrado en esa celda
 */
public Piece getCellContent(Coordinate c) {
	c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
Piece pieza = gameboard.get(c);
	return pieza;
}

/**
 * Selecciona una celda para asignar una pieza.
 *
 * @param c Coordenada donde la pondrá
 * @param p Pieza que asignará
 */
public void setCellContent(Coordinate c, Piece p) {
	c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
	p = Objects.requireNonNull(p, "El parametro 'p' no puede ser null");
	gameboard.put(c,p);
}

/**
 * Devuelve una cadena de texto del gameboard.
 *
 * @return cadena Devuelve la cadena de texto
 */
public String toString() {
	String cadena="";
	for(int i=0;i<height;i++) {
		for(int j=0;j<width;j++) {
			Coordinate c=new Coordinate(i,j);
			if(gameboard.containsKey(c)) {
				Piece pieza=gameboard.get(c);
				cadena+=pieza.getBlockSymbol();
			}
			else {
				cadena+='·';
			}
		}
		cadena+='\n';
	}
	return cadena;
}

/**
 * Devuelve la altura.
 *
 * @return height Altura
 */
public int getHeight() {
	return height;
}

/**
 * Devuelve la anchura.
 *
 * @return height Anchura
 */
public int getWidth() {
	return width;
}


//******************************************
//*NUEVAS IMPLEMENTACIONES DE LA PRACTICA 3*
//******************************************
/**
 * Funcion que se encarga de comprobar si una fila esta llena.
 *
 * @param fila Fila a comprobar si está llena
 * @return true si está llena
 */
public boolean isRowFull(int fila) {
	fila = Objects.requireNonNull(fila, "El parametro 'fila' no puede ser null");
	Boolean valid=true;
	
	if(fila>this.getHeight()) {
		throw new IllegalArgumentException();
	}
	else {
		for(int i=0;i<this.getWidth();i++) {
			Coordinate c=new Coordinate(fila,i);
			Piece p=this.getCellContent(c);
			if(p == null || p.isFixed()==false) {
				valid=false;
			}
		}
	}
	return valid;
}

/**
 * Funciona que de encarga de comprobar todas las filas una a una si esta llena.
 *
 * @return la fila que está llena
 */
public int firstRowFullFromBottom() {
	int fila=-1;
	Boolean tengo=false;
	for(int i=this.getHeight()-1;i>=0;i--) {
		if(this.isRowFull(i) && tengo==false) {
			fila=i;
			tengo=true;
		}
	}
	return fila;
}

/**
 * Limpia la fila que está llena.
 *
 * @param fila fila a vaciar
 */
public void clearRow(int fila) {
	fila = Objects.requireNonNull(fila, "El parametro 'fila' no puede ser null");
	if(fila>this.getHeight()) {
		throw new IllegalArgumentException();
	}
	else {
		for(int i=0;i<this.getWidth();i++) {
			gameboard.remove(new Coordinate(fila,i));
		}
	}
}

/**
 * Funcion que se encarga de bajar las filas superiores a la que se ha limpiado.
 *
 * @param fila fila a partir de la que se quiere subir
 */
void makeUpperRowsFall(int fila) {
	fila = Objects.requireNonNull(fila, "El parametro 'fila' no puede ser null");
	if(fila>this.getHeight()) {
		throw new IllegalArgumentException();
	}
	else {
		int filasup=fila-1;
		for(int i=filasup;i>=0;i--) {
			for(int j=0; j<this.getWidth();j++) {
				Coordinate c=new Coordinate(i,j);
				Piece p=gameboard.get(c);
						if(p != null) {
							Coordinate c_nueva=new Coordinate(i+1,j);
							gameboard.put(c_nueva,p);
							gameboard.remove(c);
						}
			}
		}
	}
	
}

} //fin de la clase
