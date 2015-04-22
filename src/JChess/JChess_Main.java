package jchess;

import java.applet.Applet;
import java.awt.Graphics;

public class JChess_Main extends Applet {

	private static final long serialVersionUID = 1L;	// Auto-generated

	public static void main(String[] args) {
		
		JChess_Model gameModel = new JChess_Model();
		JChess_View gameView = new JChess_View();
		
		@SuppressWarnings("unused")
		JChess_Controller gameController = new JChess_Controller(gameModel, gameView);
		
		gameView.setVisible(true);	
	}
	
	
	
	/* Applet Constructor */
	public void init() {
		
	}
	
	/* Draws/Prints onto screen */
	public void paint(Graphics g) {
		
	}
}
