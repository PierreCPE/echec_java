package model;

public class Reine extends model.AbstractPiece{

	String name;
	Couleur couleur_de_piece;
	Coord coord; 
	
	public Reine(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.getX() == xFinal && this.getY() ==yFinal)
		{
				return false; // Cas pas bouger
		} 
		if (this.getX() == xFinal || this.getY() == yFinal || Math.abs(xFinal - this.getX()) == Math.abs(yFinal - this.getY()))
		{
			
			return true; // Mouvement en ligne
		}
		
		return false;
			
	}

}
