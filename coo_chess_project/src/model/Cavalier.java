package model;

public class Cavalier extends model.AbstractPiece{

	String name;
	Couleur couleur_de_piece;
	Coord coord; 
	
	public Cavalier(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.getX() == xFinal && this.getY() ==yFinal)
		{
				return false; // Cas pas bouger
		} 
		int deltaX = Math.abs(xFinal-this.getX());
		int deltaY = Math.abs(yFinal-this.getY());
		if ((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1))
		{
			
			return true; // Mouvement en ligne
		}
		
		return false;
			
	}

}
