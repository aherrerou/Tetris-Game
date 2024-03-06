package model;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Clase Pieza.
 */
public abstract class Piece {
	
	/** Atributo que indica si está fijado. */
	private Boolean fixed;
	
	/**  Atributo char que contiene el simbolo especial. */
	protected char blockSymbol;
	
	/**  Atributo que contiene la orientacion de la pieza. */
	private Rotation orientation;
	
	/**  Atributo que limita el espacio. */
	private static int BOUNDING_SQUARE_SIZE = 4;
	
/**
 * Constructor por defecto de pieza.
 */
public Piece(){
	fixed=false;
	orientation = Rotation.D0;
}

/**
 * Se encarga de rotar la pieza en contra del sentido del reloj.
 */
public void rotateCounterclockwise() {
	switch(this.orientation) {
	case D0: this.orientation=Rotation.D90;break;
	case D90: this.orientation=Rotation.D180;break;
	case D180: this.orientation=Rotation.D270;break;
	case D270: this.orientation=Rotation.D0;break;
	}
}

/**
 * Se encarga de rotar la pieza en la direccion del reloj.
 */
public void rotateClockwise() {
	switch(this.orientation) {
	case D0: this.orientation=Rotation.D270;break;
	case D270: this.orientation=Rotation.D180;break;
	case D180: this.orientation=Rotation.D90;break;
	case D90: this.orientation=Rotation.D0;break;
	}
}

/**
 * Devuelve la orientacion de la pieza.
 *
 * @return Devuelve la rotacion de la pieza
 */
public Rotation getOrientation() {
	return orientation;
}

/**
 * Asigna la orientacion.
 *
 * @param orientation Asigna la nueva orientacion
 */
public void setOrientation(Rotation orientation) {
	this.orientation = Objects.requireNonNull(orientation, "El parametro 'orientation' no puede ser null");
	this.orientation = orientation;
}

/**
 * Devuelve el simbolo que representa un trozo de la pieza.
 *
 * @return Devuelve el simbolo que representa un trozo de la pieza
 */
public char getBlockSymbol() {
	return blockSymbol;
}

/**
 * Comprueba si está fijado.
 *
 * @return booleano con true si está fijado y false en caso contrario
 */
public Boolean isFixed() {
	return fixed;
}

/**
 * Se encarga de fijar la pieza.
 *
 * @param fixed Fija la nueva pieza
 */
public void setFixed(Boolean fixed) {
fixed = Objects.requireNonNull(fixed, "El parametro 'fixed' no puede ser null");
	this.fixed = fixed;
}

/**
 * Devuelve las celdas donde se posicionara la pieza dentro del tablero.
 *
 * @param c Indica las coordenadas con empieza
 * @return Las celdas elegidas
 */
public Set<Coordinate> getAbsoluteCells(Coordinate c){
	c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
			Set<Coordinate> squares = new HashSet<Coordinate>();
			int ori=convertirOrientacion(orientation);
				int linea[] = getShape()[ori];
					for(int i=0;i<linea.length;i++) {
							if(linea[i]==1) {
								Coordinate coordabs = new Coordinate (c.getRow()+i/4,c.getColumn()+i%4);
								squares.add(coordabs);
							}
					}
			return squares;
}

/**
 * Convertir orientacion en un numero ordinal.
 *
 * @param r se le pasa la rotation
 * @return devuelve un entero
 */
private int convertirOrientacion(Rotation r) {
	int o=r.ordinal();
	return o;
}

/**
 * Metodo para mostrar por pantalla informacion acerca de la pieza.
 *
 * @return Devuelve al salida de la pieza
 */
@Override
public String toString() {

	String cadena="";
	int ori=convertirOrientacion(this.orientation);
			for(int i=0;i<BOUNDING_SQUARE_SIZE;i++) {
				for(int j=0;j<BOUNDING_SQUARE_SIZE;j++) {
					if(getShape()[ori][BOUNDING_SQUARE_SIZE*i+j]==0) {
						cadena+=('·');
					}
					else {
						cadena+=(this.getBlockSymbol());
					}
				}
				cadena+='\n';
			}
	return cadena;
}

/**
 * Gets the shape.
 *
 * @return the shape
 */
protected abstract int[][] getShape();

/**
 * Copy.
 *
 * @return the piece
 */
public abstract Piece copy();

/**
 * Copy attributes.
 *
 * @param p the p
 */
public void copyAttributes(Piece p) {
	p = Objects.requireNonNull(p, "El parametro 'p' no puede ser null");
	this.orientation=p.orientation;
	this.fixed=p.fixed;
	this.blockSymbol=p.blockSymbol;
}
} // fin de la clase Piece


