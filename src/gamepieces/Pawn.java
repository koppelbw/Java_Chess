package gamepieces;

/* *****************************************************************************
 * Project: Java Chess
 * File: Pawn.java
 * Description: This class is a subclass of the abstract class JChess_GamePiece.
 * 					This class is required to implement the methods 
 * 					isLegalPieceMove() and getName().
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class Pawn extends JChess_GamePiece {

	public Pawn(PieceColor color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isLegalPieceMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard) {
		// TODO Auto-generated method stub
		JChess_GamePiece source = gamePieceBoard[sRow][sCol];
		JChess_GamePiece destination = gamePieceBoard[dRow][dCol];

		// Check if (forward one) destination is unoccupied
		if (destination == null) {
			if (source.getColor() == PieceColor.WHITE) {
				if (sRow - 1 == dRow && sCol == dCol)	// Moving 1 spot forward
						return true;
				if(sRow == 6 && dRow == 4 && sCol == dCol)
					return true;
			}
			else {
				if (sRow + 1 == dRow && sCol == dCol)
					return true;
				if(sRow + 2 == dRow && sCol == dCol)
					return true;
			}
		}
		else {	// Occupied by opponent (diagonal forward 1)
			if (sCol - 1 == dCol || sCol + 1 == dCol)
				if (destination.getColor() == PieceColor.WHITE) {
					if (sRow + 1 == dRow)
						return true;
				}
				else {
					if (sRow - 1 == dRow)
						return true;
				}
		}
		
		return false;
	}

	@Override
	public Piece getName() {
		return Piece.PAWN;
	}
}