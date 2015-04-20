package jchess;

public class Queen extends JChess_GamePiece {

	public Queen(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isLegalPieceMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Piece getName() {
		return Piece.QUEEN;
	}
	

}
