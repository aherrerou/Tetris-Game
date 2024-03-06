package model;

/**
 * The Class ZPiece.
 */
public class ZPiece extends Piece {
	
	/** The shape. */
	private static int shape[][] = new int[][] {
	      { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
	      { 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	      { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } }; 
	
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
	public ZPiece copy() {
		ZPiece p=new ZPiece();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Instantiates a new z piece.
	 */
	public ZPiece() {
		super();
		blockSymbol = '◫';
	}
}
