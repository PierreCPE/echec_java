package model;
import tools.ChessPiecesFactory;
import tools.ChessSinglePieceFactory;
import java.util.List;
import java.util.LinkedList;


public class Jeu {
    private final Couleur couleur;
    private final List<Pieces> pieces;

    public Jeu(Couleur couleur){
        this.couleur = couleur;
        this.pieces  = ChessPiecesFactory.newPieces(couleur);
    }
    public List<Pieces> getPieces() {
        return pieces;
    }
    public Couleur getCouleur(){
        return this.couleur;
    }
    private Pieces findPiece(int x, int y){
        if(isPieceHere(x,y)){
            for(Pieces piece : pieces){
                if(piece.getY() == y && piece.getX() == x){
                    return piece;
                }
            }
        }
        return null;
    }
    public boolean isPieceHere(int x,int y){
        for (Pieces piece : pieces){
            if (piece.getX() == x && piece.getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal){
        if(isPieceHere(xInit,yInit)){
            Pieces piece = findPiece(xInit,yInit);
            assert piece != null;
            return piece.isMoveOk(xFinal, yFinal);
        }
        return false;
    }
    public boolean move(int xInit, int yInit, int xFinal, int yFinal){
        if(isMoveOk(xInit,yInit,xFinal,yFinal)){
            Pieces piece = findPiece(xInit,yInit);
            piece.move(xFinal,yFinal);
        }
        return false;
    }
    public void setPossibleCapture(){
        //TODO
    }
    public boolean capture(int xCatch, int yCatch){
        //TODO
        return false;
    }
    public Couleur getPieceColor(int x,int y){
        return findPiece(x,y).getcouleur();
    }
    public java.lang.String getPieceType(int x, int y){
        return findPiece(x,y).getClass().getSimpleName();
    }

    public void setCastling(){


    }
    public void undoMove(){

    }
    public void undoCapture(){

    }
    public boolean isPawnPromotion(int xFinal, int yFinal){
        return yFinal == 0 || yFinal == 7;
    }
    public boolean pawnPromotion(int xFinal, int yFinal, java.lang.String type){
        if(isPawnPromotion(xFinal,yFinal)){
            Pieces piece = findPiece(xFinal,yFinal);
            pieces.remove(piece);
            Pieces newPiece = ChessSinglePieceFactory.newPiece(couleur,type,xFinal,yFinal);
            pieces.add(newPiece);
            return true;
        }
        return false;
    }

    public Coord getKingCoord(){
        for(Pieces piece : pieces){
            if(piece.getClass().getName().equals("Roi")){
                return new Coord(piece.getX(), piece.getY());
            }
        }
        return null;
    }
    /**
     * @return une vue de la liste des pi�ces en cours
     * ne donnant que des acc�s en lecture sur des PieceIHM
     * (type piece + couleur + liste de coordonn�es)
     */
    public List<PieceIHM> getPiecesIHM(){
        PieceIHM       newPieceIHM = null;
        List<PieceIHM>       list = new LinkedList<PieceIHM>();
        for (Pieces piece : pieces){ boolean existe = false;
            // si le type de piece existe d�j� dans la liste de PieceIHM
            // ajout des coordonn�es de la pi�ce dans la liste de Coord de ce type
            // si elle est toujours en jeu (x et y != -1)
            for ( PieceIHM pieceIHM : list){
                if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
                    existe = true;
                    if (piece.getX() != -1){
                        pieceIHM.add(new Coord(piece.getX(), piece.getY()));
                    }
                }
            } // sinon, cr�ation d'une nouvelle PieceIHM si la pi�ce est toujours en jeu
            if (! existe) {
                if (piece.getX()       !=       -1){
                    newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(), piece.getcouleur());
                    newPieceIHM.add(new Coord(piece.getX(), piece.getY())); list.add(newPieceIHM);
                }
            }
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(" Couleur : " + this.couleur + '\n');
        for(Pieces pieces1 : pieces){
            ret.append(" ").append(pieces1.toString()).append('\n');
        }
        return ret.toString();
    }
    public static void main(String[] args) {
        Jeu jeu = new Jeu(Couleur.NOIR);
        System.out.println(jeu);
        testJeu(jeu);
        jeu.move(1,0,0,2);
        testJeu(jeu);
    }



    private static void testJeu(Jeu jeu) {
        System.out.println("  a b c d e f g h");
        for (int j = 0; j < 8; j++) {
            StringBuilder line = new StringBuilder((j + 1) + " ");
            for (int i = 0; i < 8; i++) {
                if (jeu.isPieceHere(i,j) ) {
                    line.append(jeu.getPieceType(i, j));
                } else {
                    line.append(".");
                }
                    line.append(" ");
                }
            System.out.println(line);
        }
        System.out.println("\n");
    }
}