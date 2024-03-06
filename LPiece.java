package model;

/**
 * The Class LPiece.
 */
public class LPiece extends Piece {
	
	/** The shape. */
	private static int shape[][] = new int[][] {
	      { 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	      { 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
	      { 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } }; 
	
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
	public LPiece copy() {
		LPiece p=new LPiece();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Instantiates a new l piece.
	 */
	public LPiece() {
		super();
		blockSymbol = '▧';
	}
}
