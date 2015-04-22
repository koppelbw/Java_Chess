package jchess;

import gamepieces.JChess_GamePiece;
import gamepieces.PieceColor;

/* *****************************************************************************
 * Project: Java Chess
 * File: JChess_Model.java
 * Description: The Model class performs all back-end functionality for the game.
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class JChess_Model {

	private JChess_GameBoard board;
	private JChess_GamePiece[][] gamePieceBoard;
	private PieceColor playerTurn;
	
	/* Constructor */
	public JChess_Model() {
		setBoard(new JChess_GameBoard());
		//getBoard().drawBoardToConsole();
		gamePieceBoard = board.getBoard();
		playerTurn = PieceColor.WHITE;
	}

	/* Attempts to move a GamePiece, will return true if successful*/
	public boolean movePieceAttempt(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece piece) {
		if(piece.isLegalMove(sRow, sCol, dRow, dCol, gamePieceBoard)) {
			
			// Advance game
			gamePieceBoard[dRow][dCol] = gamePieceBoard[sRow][sCol];
			gamePieceBoard[sRow][sCol] = null;
			changePlayerTurn();
			return true;
		}		
		
		return false;
	}
	
	/* Changes playerTurn using PieceColor enum */
	public void changePlayerTurn() {
		if(playerTurn == PieceColor.WHITE)
			playerTurn = PieceColor.BLACK;
		else
			playerTurn = PieceColor.WHITE;
	}
	
	
	/* Getter and Setter methods for the board*/
	public JChess_GameBoard getBoard() {
		return board;
	}

	public void setBoard(JChess_GameBoard board) {
		this.board = board;
	}
	
	public JChess_GamePiece[][] getGamePieceBoard() {
		return board.getBoard();
	}
	
	public PieceColor getPlayerTurn() {
		return playerTurn;
	}
	
}