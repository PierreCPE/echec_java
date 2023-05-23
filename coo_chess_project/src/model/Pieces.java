package model;

public interface Pieces {

	public boolean move (int xFinal, int yFinal); 

	/**
	 * @return Ok si le déplacement des pièces est ok.
	 */
	
	public int getX();
	
	/**
	 * @return la colonne ou est situe la piece
	 */
	
	public int getY();
	
	/**
	 * @return la ligne ou est situe la piece
	 */

	public Couleur getcouleur();
	
	/**
	 * @return 	couleur de la piece
	 */
	
	public boolean isMoveOk(int xFinal,int yFinal);
	
	/**
	 * @return true si déplacement légal en fonction des algo de déplacement spécifique de chaque pièce
	 */
	
	public boolean capture();
	
	/**
	 * @return true si piece effectivement capture Positionne x et y Ã  -1
	 */
	String getName();
}
