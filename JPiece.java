package model;

/**
 * The Class JPiece.
 */
public class JPiece extends Piece {
	
	/** The shape. */
	private static int shape[][] = new int[][] {
	      { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
	      { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	      { 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 } }; 
	
	 	 /**
	 	  * Clase que devulve el shape
	 	  * @return shape 
	 	  */
	@Override
	protected int[][] getShape() {
		return shape;
	}
	
	/**
	 * Clase que se carga de copiar la pieza
	 * @return p pieza copiada
	 */
	@Override
	public JPiece copy() {
		JPiece p=new JPiece();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Instantiates a new j piece.
	 */
	public JPiece() {
		super();
		blockSymbol = '◪';
	}
}
