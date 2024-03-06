package model;

// TODO: Auto-generated Javadoc
/**
 * The Class OPiece.
 */
public class OPiece extends Piece {
	
	/** The shape. */
	private static int shape[][] = new int[][] {
	      { 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } }; 
	
	  	
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
	public OPiece copy() {
		OPiece p=new OPiece();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Instantiates a new o piece.
	 */
	public OPiece() {
		super();
		blockSymbol = '▣';
	}
}
