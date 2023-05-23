package model;

public class Tour extends model.AbstractPiece{

	String name;
	Couleur couleur_de_piece;
	Coord coord; 
	
	public Tour(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.getX() == xFinal && this.getY() ==yFinal)
		{
				return false; // Cas pas bouger
		} 
		if (this.getX() == xFinal || this.getY() == yFinal)
		{
			
			return true; // Mouvement en ligne
		}
		
		return false;
			
	}

}
