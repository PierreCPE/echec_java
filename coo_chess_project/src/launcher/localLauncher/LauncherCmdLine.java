package launcher.localLauncher;

import model.observable.ChessGame;
import vue.ChessGameCmdLine;
import controler.controlerLocal.ChessGameControler;


/**
 * @author francoise.perrin
 * Lance l'ex�cution d'un jeu d'�chec en mode console.
 */
public class LauncherCmdLine {
	
	public static void main(String[] args) {		
		
		ChessGame model;
		ChessGameControler controler;	
		ChessGameCmdLine vue;
		
		model = new ChessGame();
		controler = new ChessGameControler(model);

		new ChessGameCmdLine(controler);

		vue = new ChessGameCmdLine(controler);
		model.addObserver(vue);
		vue.go();
	}

}