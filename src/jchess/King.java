package jchess;

public class King extends JChess_GamePiece {

	/* Constructor */
	public King(Color color) {
		super(color);
	}

	@Override
	protected boolean isLegalPieceMove() {
		
		return false;
	}

	@Override
	protected Piece getName() {
		return Piece.KING;
	}

	
}
