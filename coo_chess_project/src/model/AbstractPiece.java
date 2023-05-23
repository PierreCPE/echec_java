package model;


public abstract class AbstractPiece implements Pieces {


	String name;
	Couleur couleur;
	Coord coord;
	
	public AbstractPiece(Couleur couleur,Coord coord) {
		this.couleur = couleur;
		this.coord = coord;
	}
	
	public boolean move(int xFinal, int yFinal) {
		if (this.isMoveOk(xFinal, yFinal) ) 
		{
			this.coord.x = xFinal;
			this.coord.y = yFinal;
			return true;
		}
		return false;
	}


	public int getX() {

		return this.coord.x;
	}

	
	public int getY() {
		

		return this.coord.y;
	}

	
	public Couleur getcouleur() {
		
		return this.couleur;
	}
	
	public String getName() {
		return name;
	}

	
	public abstract boolean isMoveOk(int xFinal, int yFinal);

	
	public boolean capture() {
		if (this.capture() == true) {
			this.coord.x = -1;
			this.coord.y = -1;
			return true;
						}
		else {
		return false;}
	}
	
	@Override
	public java.lang.String toString(){
		Class c = getClass();
        
		return "Nom : " + c.getName() + ", Coord : " + coord;
		
	}
	public static void main(String[] args) {
		
	//***TEST***
		//creation de la tour
	Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
		//Du pion 
	Pieces monPion = new Pion(Couleur.NOIR, new Coord(0, 0));
		//Du Fou 
	Pieces monFou = new Fou(Couleur.NOIR, new Coord(2, 2));
		//De la reine 
	Pieces maReine = new Reine(Couleur.NOIR, new Coord(5, 5));
		//Du Roi
	Pieces monRoi = new Roi(Couleur.NOIR, new Coord(6, 6));
		//Du Cavalier
	Pieces monCavalier = new Cavalier(Couleur.NOIR, new Coord(4, 4));
		// PRINTS DES PIECES
	System.out.println("Print des pièces : ");
	System.out.println(maTour);
	System.out.println(monPion);
	System.out.println(monFou);
	System.out.println(maReine);
	System.out.println(monRoi);
	System.out.println(monCavalier);
	
		//Test des déplacements :

		// déplacement de la tour OK
	System.out.println("Print des déplacements Tour: ");
	maTour.move(2, 0);
	System.out.println(maTour);
	maTour.move(2, 6);
	System.out.println(maTour);
	maTour.move(3, 7);
	System.out.println(maTour);
	
		// déplacement du pion TODO
	System.out.println("Print des déplacements Pion: ");
    monPion.move(0, 1);
	System.out.println(monPion);
	monPion.move(1, 2);
	System.out.println(monPion);
	monPion.move(0, 2);
	System.out.println(monPion);
	
		// déplacement du fou OK
	System.out.println("Print des déplacements Fou: ");
	monFou.move(2, 1);
	System.out.println(monFou);
	monFou.move(1, 1);
	System.out.println(monFou);
		// déplacement de la reine OK
	System.out.println("Print des déplacements Reine : ");
	maReine.move(3, 3);
	System.out.println(maReine);
	maReine.move(3, 1);
	System.out.println(maReine);
	maReine.move(4, 4);
	System.out.println(maReine);
	
		// déplacement du Roi OK
	System.out.println("Print des déplacements Roi: ");
	monRoi.move(3, 3);
	System.out.println(monRoi);
	monRoi.move(6,5);
	System.out.println(monRoi);
	monRoi.move(5,5);
	System.out.println(monRoi);
	monRoi.move(4,4);
	System.out.println(monRoi);
	
		// déplacement du Cavalier OK
	System.out.println("Print des déplacements du Cavalier: ");
	monCavalier.move(3, 3);
	System.out.println(monCavalier);
	monCavalier.move(6,5);
	System.out.println(monCavalier);
	monCavalier.move(4,6);
	System.out.println(monCavalier);

		}
}

