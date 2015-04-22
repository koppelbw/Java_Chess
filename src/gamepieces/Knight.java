package gamepieces;

public class Knight extends JChess_GamePiece {

	public Knight(PieceColor color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isLegalPieceMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard) {
		// TODO Auto-generated method stub

		// Check if Knight movement is legal
		if (dRow == sRow - 1 || dRow == sRow + 1)
			if (dCol == sCol - 2 || dCol == sCol + 2)
				return true;

		if (dRow == sRow - 2 || dRow == sRow + 2)
			if (dCol == sCol - 1 || dCol == sCol + 1)
				return true;

		return false;
	}

	@Override
	public Piece getName() {
		return Piece.KNIGHT;
	}
}
