package jchess;

public class JChess_GameBoard {

	private JChess_GamePiece[][] board;
	
	/* Constructor */
	public JChess_GameBoard() {
		setBoard(new JChess_GamePiece[8][8]);
		initializeBoard();
		resetBoard();
	}
	
	/* Initializes the game board to null pointers */
	public void initializeBoard() {
		for(int r = 0; r < 8; r++)
			for(int c = 0; c < 8; c++)
				board[r][c] = null;
	}
	
	/* Resets the gameBoard pieces to starting positions */
	public void resetBoard() {
		
		initializeBoard();
		
		// Allocate and position Black pieces
		for (int i = 0; i < 8; i++)
			board[1][i] = new Pawn(Color.BLACK);

		board[0][0] = new Rook(Color.BLACK);
		board[0][1] = new Knight(Color.BLACK);
		board[0][2] = new Bishop(Color.BLACK);
		board[0][3] = new King(Color.BLACK);
		board[0][4] = new Queen(Color.BLACK);
		board[0][5] = new Bishop(Color.BLACK);
		board[0][6] = new Knight(Color.BLACK);
		board[0][7] = new Rook(Color.BLACK);
		
		// Allocate and position White pieces
		for (int i = 0; i < 8; i++)
			board[6][i] = new Pawn(Color.WHITE);
		
		board[7][0] = new Rook(Color.WHITE);
		board[7][1] = new Knight(Color.WHITE);
		board[7][2] = new Bishop(Color.WHITE);
		board[7][3] = new King(Color.WHITE);
		board[7][4] = new Queen(Color.WHITE);
		board[7][5] = new Bishop(Color.WHITE);
		board[7][6] = new Knight(Color.WHITE);
		board[7][7] = new Rook(Color.WHITE);
	}
	
	public void drawBoardToConsole() {
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				try{
				System.out.print("-" + board[r][c].getColor() + "." + board[r][c].getName() + "-");
				}catch(NullPointerException e) {
					System.out.print("-**********-");
				}
			}
			System.out.println();
		}
	}
	
	/* Getter and Setter methods for board */
	public JChess_GamePiece[][] getBoard() {
		return board;
	}

	public void setBoard(JChess_GamePiece[][] board) {
		this.board = board;
	}
	
	
}
