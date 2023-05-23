package controler.controlerLocal;

import model.Coord;
import model.observable.ChessGame;
import controler.AbstractChessGameControler;

/**
 * @author francoise.perrin
 * 
 *         Ce controleur local pr�cise comment emp�cher un joueur � qui ce n'est pas le tour 
 *         de jouer, de d�placer une image de pi�ce sur le damier
 *
 */
public class ChessGameControler extends AbstractChessGameControler {
	
	public ChessGameControler(ChessGame chessGame) {
		super(chessGame);
	}

	/* (non-Javadoc)
	 * @see controler.AbstractChessGameControler#isPlayerOK(model.Coord)
	 * 
	 * cette m�thode v�rifie que la couleur de la pi�ce que l'utilisateur
	 * tente de d�placer est bien celle du jeu courant
	 * la vue se servira de cette information pour emp�cher tout d�placement sur le damier
	 */
	@Override
	public boolean isPlayerOK(Coord initCoord) {
		// TODO
		if(this.chessGame.getColorCurrentPlayer() == this.chessGame.getPieceColor(initCoord.x, initCoord.y))
			return true;
		else
			System.out.println("C'est le tour de l'adversaire");
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see controler.AbstractChessGameControler#endMove(model.Coord, model.Coord, java.lang.String)
	 * 
	 * Pas d'action suppl�mentaire dans un contr�leur local en fin de move
	 */
	@Override
	protected void endMove(Coord initCoord, Coord finalCoord,
			String promotionType) {	
		}

	
}