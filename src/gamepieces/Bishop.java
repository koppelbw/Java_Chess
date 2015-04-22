package gamepieces;

public class Bishop extends JChess_GamePiece {

	public Bishop(PieceColor color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isLegalPieceMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard) {
		// TODO Auto-generated method stub
		return gamePieceBoard[sRow][sCol].isLegalDiagonalMove(sRow, sCol, dRow, dCol, gamePieceBoard);
	}

	@Override
	public Piece getName() {
		return Piece.BISHOP;
	}
	

}
