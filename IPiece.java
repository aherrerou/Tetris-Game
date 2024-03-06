package model;

/**
 * The Class IPiece.
 */
public class IPiece extends Piece {
	
	/** The shape. */
	private static int shape[][] = new int[][] {
	      { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
	      { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 },
	      { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
	      { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } }; 
	
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
	public IPiece copy() {
		IPiece p=new IPiece();
		p.copyAttributes(this);
		return p;
	}
	
	/**
	 * Instancia una nueva pieza
	 */
	public IPiece() {
		super();
		blockSymbol = '▒';
	}
}

