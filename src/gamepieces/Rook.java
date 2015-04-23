package gamepieces;

/* *****************************************************************************
 * Project: Java Chess
 * File: Rook.java
 * Description: This class is a subclass of the abstract class JChess_GamePiece.
 * 					This class is required to implement the methods 
 * 					isLegalPieceMove() and getName().
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class Rook extends JChess_GamePiece {

	public Rook(PieceColor color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isLegalPieceMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard) {
		// TODO Auto-generated method stub
		return gamePieceBoard[sRow][sCol].isLegalLinearMove(sRow, sCol, dRow, dCol, gamePieceBoard);
	}

	@Override
	public Piece getName() {
		return Piece.ROOK;
	}
}