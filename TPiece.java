package model;

/**
 * The Class TPiece.
 */
public class TPiece extends Piece {
	
	/** The shape. */
	private static int shape[][] = new int[][] {
	      { 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
	      { 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
	      { 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } }; 
	
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
	public TPiece copy() {
		TPiece p=new TPiece();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Instantiates a new t piece.
	 */
	public TPiece() {
		super();
		blockSymbol = '▤';
	}
}
