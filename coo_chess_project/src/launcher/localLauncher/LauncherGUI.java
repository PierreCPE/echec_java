package launcher.localLauncher;

import controler.ChessGameControlers;
import controler.controlerLocal.ChessGameControler;
import model.observable.ChessGame;
import vue.ChessGameGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * @author francoise.perrin
 * Lance l'ex�cution d'un jeu d'�chec en mode graphique.
 * La vue (ChessGameGUI) observe le mod�le (ChessGame)
 * les �changes passent par le contr�leur (ChessGameControlers)
 * 
 */
public class LauncherGUI {
	public static void main(String[] args) {

		Dimension dim;
		dim = new Dimension(700, 700);

		ChessGame chessGame;
		ChessGameControlers chessGameControler;
		chessGame = new ChessGame();
		chessGameControler = new ChessGameControler(chessGame);

		JFrame frame = new ChessGameGUI("Chess", chessGameControler, dim);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		chessGame.addObserver((Observer) frame);

	}
}