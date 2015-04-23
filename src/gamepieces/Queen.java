package gamepieces;

/* *****************************************************************************
 * Project: Java Chess
 * File: Queen.java
 * Description: This class is a subclass of the abstract class JChess_GamePiece.
 * 					This class is required to implement the methods 
 * 					isLegalPieceMove() and getName().
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class Queen extends JChess_GamePiece {

	public Queen(PieceColor color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isLegalPieceMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard) {
		// Check if Queen movement is legal
		if (isLegalLinearMove(sRow, sCol, dRow, dCol, gamePieceBoard) ||
				isLegalDiagonalMove(sRow, sCol, dRow, dCol, gamePieceBoard))
			return true;
		else
			return false;
	}

	@Override
	public Piece getName() {
		return Piece.QUEEN;
	}
}