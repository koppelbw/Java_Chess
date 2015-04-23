package gamepieces;

/* *****************************************************************************
 * Project: Java Chess
 * File: King.java
 * Description: This class is a subclass of the abstract class JChess_GamePiece.
 * 					This class is required to implement the methods 
 * 					isLegalPieceMove() and getName().
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class King extends JChess_GamePiece {

	/* Constructor */
	public King(PieceColor color) {
		super(color);
	}

	@Override
	protected boolean isLegalPieceMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard) {
		// Check moves: Up(1), Right(1), Down(1), Left(1), Diagonals(1)
		if (sRow - dRow <= 1
				&& sRow - dRow >= -1
				&& sCol - dCol <= 1
				&& sCol - dCol >= -1)
			return true;
		else
			return false;
	}

	@Override
	public Piece getName() {
		return Piece.KING;
	}	
}