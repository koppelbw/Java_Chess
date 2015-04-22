package gamepieces;

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
			}
			else {
				if (sRow + 1 == dRow && sCol == dCol)
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
