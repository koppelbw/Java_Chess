package jchess;

public class Pawn extends JChess_GamePiece {

	public Pawn(Color color) {
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
		return Piece.PAWN;
	}
	

}
