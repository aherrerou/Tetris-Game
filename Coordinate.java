package model;

import java.util.Objects;

/**
 * Esta es la clase que tiene todos los metodos y atributos principales de Coordinate.
 *
 * @author Adrian Herrero Bernabeu 48686160J
 */

public class Coordinate{

/** Atributo que indica la fila de la coordenada. */
	private int row;

/** Atributo que indique la columna de la coordenada. */
	private int column;

/** Atributo que almacena el numero de coordenadas que tenemos. */
	private static int COORDINATE_COUNT;

/**
 * Contructor pasandole las dos componentes que necesita la coordenada.
 *
 * @param r le indica el tamaño de la fila
 * @param c le indica el tamaño de la columna
 */
	public Coordinate(int r, int c){
		c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
		r = Objects.requireNonNull(r, "El parametro 'r' no puede ser null");
		row=r;
		column=c;
		COORDINATE_COUNT++;
	}

/**
 * Constructor COPIA.
 *
 * @param c le pasamos un objeto coordinate al cual queremos copiar el contenido
 */
	public Coordinate(Coordinate c){
		c = Objects.requireNonNull(c, "El parametro 'c' no puede ser null");
		row=c.row;
		column=c.column;
		COORDINATE_COUNT++;
	}

/**
 * Metodo para obtener cuantas coordenadas tenemos.
 *
 * @return devuelve el numero de coordenadas que tenemos
 */
	public static int getCoordinateCount(){
		return COORDINATE_COUNT;
	}

/**
 * Metodo para mostrar por pantalla informacion acerca de la coordenada.
 *
 * @return Devuelve al salida de las coordenadas encapsulada en [,] para un mejor visualizacion
 */
	public String toString(){
		return "["+row+","+column+"]";
	}

/**
 * Metodo para generar el hashCode de la coordenada.
 *
 * @return Devuelve el hashCode resultante
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + column;
	result = prime * result + row;
	return result;
}

/**
 * Metodo para saber si dos objetos son iguales.
 *
 * @param obj le pasamos el objeto con el cual queremos comparar
 * @return Devuelve si son iguales o no
 */
@Override
public boolean equals(Object obj) {
	//obj = Objects.requireNonNull(obj, "El parametro 'obj' no puede ser null");
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Coordinate other = (Coordinate) obj;
	if (column != other.column)
		return false;
	if (row != other.row)
		return false;
	return true;
}

/**
 * Metodo para obtener la fila de un objeto coordenada.
 *
 * @return devuelve la fila
 */
	public int getRow(){
		return row;
	}

/**
 * Metodo para obtener la columna de un objeto coordenada.
 *
 * @return devuelve la columna
 */
	public int getColumn(){
		return column;
	}

/**
 * Metodo para sumar las coordenadas de dos objetos y crear uno nuevo con la suma resultante.
 *
 * @param addCor objeto al cual se le va a sumar
 * @return devuelve un nuevo objeto con la suma resultante
 */
	public Coordinate add(Coordinate addCor){
		addCor = Objects.requireNonNull(addCor, "El parametro 'c' no puede ser null");
		Coordinate c = new Coordinate(this.getRow()+addCor.getRow(),this.getColumn()+addCor.getColumn());
		return c;
	}
	
	/**
	 * Metodo para saber si el contenido de dos coordenadas es el mismo.
	 *
	 * @param c Le pasamos la coordenada que queremos comparar
	 * @return Si los contenidos son iguales
	 */
	public boolean equalsContent (Coordinate c){
	    if(c.getRow()==row && c.getColumn()==column){
	        return true;
	    }else{
	        return false;
	    }
	}

}
