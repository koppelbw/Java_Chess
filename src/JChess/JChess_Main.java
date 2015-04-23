package jchess;

/* *****************************************************************************
 * Project: Java Chess
 * File: JChess_Main.java
 * Description: The main funtion of JChess program.
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class JChess_Main {

	public static void main(String[] args) {
		
		JChess_Model gameModel = new JChess_Model();
		JChess_View gameView = new JChess_View();
		
		@SuppressWarnings("unused")
		JChess_Controller gameController = new JChess_Controller(gameModel, gameView);
		
		gameView.setVisible(true);	
	}
}
