package model;

public class Pion extends AbstractPiece implements Pions, Pieces{

	Couleur couleur_de_piece;
	Coord coord;
	
	public Pion(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
		}
		

		@Override
		public boolean isMoveOk(int xFinal, int yFinal) {
			if (this.getX() == xFinal && this.getY() ==yFinal)
			{
					return false; // Cas pas bouger
			}
			
			if ((yFinal == this.getY()+1) && (xFinal == this.getX()))
			{
				
				return true; // Mouvement en ligne
			}
			
			return false;
				
		}
		@Override
		public boolean isMoveDiagOk(int xFinal, int yFinal) {
			// TODO Auto-generated method stub
			return false;
		}
		
		
		/*@Override
		public boolean move(int xFinal, int yFinal) {
			if (this.isMoveOk(xFinal, yFinal)) //Ajouter la cdt move diag plus tard
			{
				this.coord.x = xFinal;
				this.coord.y = yFinal;
				return true;
			}
			return false;
		}*/

}
