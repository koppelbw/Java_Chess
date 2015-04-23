package jchess;

import gamepieces.Bishop;
import gamepieces.JChess_GamePiece;
import gamepieces.King;
import gamepieces.Knight;
import gamepieces.Pawn;
import gamepieces.PieceColor;
import gamepieces.Queen;
import gamepieces.Rook;
/* *****************************************************************************
 * Project: Java Chess
 * File: JChess_GameBoard.java
 * Description: This class holds the underlying game board consisting of
 * 					polymorphic JChess_GamePiece's. 
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class JChess_GameBoard {

	/* Instantiate the board */
	private JChess_GamePiece[][] board;
	
	/* Constructor */
	public JChess_GameBoard() {
		setBoard(new JChess_GamePiece[8][8]);
		resetBoard();
	}
	
	/* Initializes the game board to null pointers */
	public void initializeBoard() {
		for(int r = 0; r < 8; r++)
			for(int c = 0; c < 8; c++)
				board[r][c] = null;
	}
	
	/* Resets the gameBoard pieces to starting positions */
	public void resetBoard() {
		
		initializeBoard();
		
		// Allocate and position Black pieces
		for (int i = 0; i < 8; i++)
			board[1][i] = new Pawn(PieceColor.BLACK);

		board[0][0] = new Rook(PieceColor.BLACK);
		board[0][1] = new Knight(PieceColor.BLACK);
		board[0][2] = new Bishop(PieceColor.BLACK);
		board[0][3] = new King(PieceColor.BLACK);
		board[0][4] = new Queen(PieceColor.BLACK);
		board[0][5] = new Bishop(PieceColor.BLACK);
		board[0][6] = new Knight(PieceColor.BLACK);
		board[0][7] = new Rook(PieceColor.BLACK);
		
		// Allocate and position White pieces
		for (int i = 0; i < 8; i++)
			board[6][i] = new Pawn(PieceColor.WHITE);
		
		board[7][0] = new Rook(PieceColor.WHITE);
		board[7][1] = new Knight(PieceColor.WHITE);
		board[7][2] = new Bishop(PieceColor.WHITE);
		board[7][3] = new King(PieceColor.WHITE);
		board[7][4] = new Queen(PieceColor.WHITE);
		board[7][5] = new Bishop(PieceColor.WHITE);
		board[7][6] = new Knight(PieceColor.WHITE);
		board[7][7] = new Rook(PieceColor.WHITE);
	}
	
	/* Getter and Setter methods for board */
	public JChess_GamePiece[][] getBoard() {
		return board;
	}

	public void setBoard(JChess_GamePiece[][] board) {
		this.board = board;
	}
}