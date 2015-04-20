package jchess;

public abstract class JChess_GamePiece {

	/* Instance variable */
	private Color color;
	
	// Check if legal move
	//   In Java, all non-static methods are by default "virtual functions."
	//   Only methods marked with the keyword final, which cannot be overridden, 
	//   along with private methods, which are not inherited, are non-virtual.
	protected abstract boolean isLegalPieceMove();
	protected abstract Piece getName();
	
	/* Constructor (No Destructor in Java, just Garbage Collector) */
	public JChess_GamePiece(Color color) {
		this.color = color;
	}
	
	/* Returns the color of the GamePiece */
	protected Color getColor() { 
		return color;
	}
	
	/* Checks if GamePiece is moving linearly */
	protected boolean isMoveLinear() {
		
		return false;
	}
	
	/* Checks if GamePiece is moving diagonally */
	protected boolean isMoveDiagonal() {
		
		return false;
	}
	
	/* Checks if GamePiece move is legal to make */
	protected boolean isLegalMove() {
		
		return false;
	}
	
}
