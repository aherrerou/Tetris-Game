package model;

/**
 * The Class SPiece.
 */
public class SPiece extends Piece {
	
	/** The shape. */
	private static int shape[][] = new int[][] {
	      { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	      { 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
	      { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } }; 
	
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
	public SPiece copy() {
		SPiece p=new SPiece();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Instantiates a new s piece.
	 */
	public SPiece() {
		super();
		blockSymbol = '▦';
	}
}
