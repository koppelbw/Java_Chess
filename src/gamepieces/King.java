package gamepieces;

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
