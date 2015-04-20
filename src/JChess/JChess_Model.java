package jchess;

/* *****************************************************************************
 * Project: Java Chess
 * File: JChess_Model.java
 * Description: The Model class performs all back-end functionality for the game.
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class JChess_Model {

	private JChess_GameBoard board;
	
	/* Constructor */
	public JChess_Model() {
		board = new JChess_GameBoard();
		board.drawBoardToConsole();
	}
	
}
