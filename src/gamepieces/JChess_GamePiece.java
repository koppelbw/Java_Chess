package gamepieces;

public abstract class JChess_GamePiece {

	/* Instance variable */
	private PieceColor color;
	
	// Check if legal move
	//   In Java, all non-static methods are by default "virtual functions."
	//   Only methods marked with the keyword final, which cannot be overridden, 
	//   along with private methods, which are not inherited, are non-virtual.
	protected abstract boolean isLegalPieceMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard);
	
	// Must be public. protected is not visible to other packages
	public abstract Piece getName();
	
	/* Constructor (No Destructor in Java, just Garbage Collector) */
	public JChess_GamePiece(PieceColor color) {
		this.color = color;
	}
	
	/* Returns the color of the GamePiece */
	public PieceColor getColor() { 
		return color;
	}
	
	/* Checks if GamePiece is moving linearly */
	public boolean isLegalLinearMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard) {
		if(sCol == dCol) {
			if(sRow > dRow) {	// Moving UP
				// Check if spaces BETWEEN source and destination are empty
				for (int i = 1; i < (sRow - dRow); i++) {
					if (gamePieceBoard[sRow - i][sCol] != null)
						return false;
				}

				return true;
			}else {				// Moving DOWN

				// Check if spaces BETWEEN source and destination are empty
				for (int i = 1; i < (dRow - sRow); i++) {
					if (gamePieceBoard[sRow + i][sCol] != null)
						return false;
				}

				return true;
			}
		}else if (sRow == dRow) {
			if (sCol > dCol) {	// Moving Left

				// Check if spaces BETWEEN source and destination are empty
				for (int i = 1; i < (sCol - dCol); i++) {
					if (gamePieceBoard[sRow][sCol - i] != null)
						return false;
				}

				return true;
			}
			else {				// Moving Right

				// Check if spaces BETWEEN source and destination are empty
				for (int i = 1; i < (dCol - sCol); i++) {
					if (gamePieceBoard[sRow][sCol + i] != null)
						return false;
				}

				return true;
			}
		}

		return false;
	}
	
	/* Checks if GamePiece is moving diagonally */
	public boolean isLegalDiagonalMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard) {
		
		if (dCol - sCol == dRow - sRow || dCol - sCol == sRow - dRow) {

			// Check if spaces BETWEEN source and destination are empty
			int rowDirection = (dRow - sRow > 0) ? 1 : -1;
			int colDirection = (dCol - sCol > 0) ? 1 : -1;
			int tmpRow, tmpCol;

			for (tmpRow = sRow + rowDirection, tmpCol = sCol + colDirection;
				tmpRow != dRow;
				tmpRow = tmpRow + rowDirection, tmpCol = tmpCol + colDirection)
			{
				if (gamePieceBoard[tmpRow][tmpCol] != null)
					return false;
			}

			return true;
		}
		return false;
	}
	
	/* Checks if GamePiece move is legal to make */
	public boolean isLegalMove(int sRow, int sCol, int dRow, int dCol, JChess_GamePiece[][] gamePieceBoard) {
		
		JChess_GamePiece destination = gamePieceBoard[dRow][dCol];
		
		// Check out-of-bounds, open/legit dest, and if isLegalPieceMove()
		if(dRow < 8 && dCol < 8 && dRow >= 0 && dCol >= 0 && 
				destination == null || color != destination.getColor())
			return isLegalPieceMove(sRow, sCol, dRow, dCol, gamePieceBoard);
		else
			return false;
	}
}
