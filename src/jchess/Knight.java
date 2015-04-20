package jchess;

public class Knight extends JChess_GamePiece {

	public Knight(Color color) {
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
		return Piece.KNIGHT;
	}
	

}
