package model;

public class Roi extends model.AbstractPiece{

	String name;
	Couleur couleur_de_piece;
	Coord coord; 
	
	public Roi(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.getX() == xFinal && this.getY() ==yFinal)
		{
				return false; // Cas pas bouger
		} 
		int deltaX = Math.abs(xFinal-this.getX());
		int deltaY = Math.abs(yFinal-this.getX());
		if (deltaX == 1 || deltaY ==1)
		{
			
			return true; // Mouvement en ligne
		}
		
		return false;
			
	}

}
