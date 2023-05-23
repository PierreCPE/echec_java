package model;

public interface Pieces {

	public boolean move (int xFinal, int yFinal); 

	/**
	 * @return Ok si le d�placement des pi�ces est ok.
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
	 * @return true si d�placement l�gal en fonction des algo de d�placement sp�cifique de chaque pi�ce
	 */
	
	public boolean capture();
	
	/**
	 * @return true si piece effectivement capture Positionne x et y �  -1
	 */
	String getName();
}
