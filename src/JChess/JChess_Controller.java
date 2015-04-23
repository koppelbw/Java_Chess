package jchess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import gamepieces.JChess_GamePiece;
import gamepieces.PieceColor;
/* *****************************************************************************
 * Project: Java Chess
 * File: JChess_Controller.java
 * Description: This class acts as the middle man for the Model and View.
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class JChess_Controller {
	
	/* Instantiate instance variables */
	private JChess_Model gameModel;
	private JChess_View gameView;
	private JChess_GamePiece[][] gamePieceBoard;
	private JLabel[][] gameBoardLabels;
	private boolean selectedPiece;
	private int tmpRow, tmpCol;
	private JChess_GamePiece tmpPiece;
	private PieceColor playerTurn;
	private int blackWins, whiteWins;
	
	/* Constructor */
	public JChess_Controller(JChess_Model gameModel, JChess_View gameView) {
		
		this.gameModel = gameModel;
		this.gameView = gameView;
		gamePieceBoard = gameModel.getGamePieceBoard();
		gameBoardLabels = gameView.getGameBoardLabels();
		selectedPiece = false;
		updatePlayerTurn();
		blackWins = 0;
		whiteWins = 0;
		
		this.gameView.updateGUI(gamePieceBoard, playerTurn, blackWins, whiteWins);

		// Tells the View that if buttons are clicked, call actionPerformed
		this.gameView.addButtonListener(new ButtonListener());
		this.gameView.addMouseListener(new MouseHandler());
	}


	/* This method handles game interactions. Corresponds to View method */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	/* This method handles game interactions. Corresponds to View method */
	private class MouseHandler implements MouseListener {

		//public void actionPerformed(ActionEvent e) {

		//}

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			for(int r = 0; r < 8; r++) {
				for(int c = 0; c < 8; c++) {
					
					// Finds the Label that has been clicked
					if(gameBoardLabels[r][c] == arg0.getSource()) {
						
						if(selectedPiece && tmpPiece != null) {	// SECOND CLICK to move the piece
							
							// Attempts to advance game by moving the selected piece
							if(gameModel.movePieceAttempt(tmpRow, tmpCol, r, c, tmpPiece)) {
								updatePlayerTurn();
								gameView.updateGUI(gamePieceBoard, playerTurn, blackWins, whiteWins);
							}
							
							gameView.unHighlightSelectedLabel(tmpRow, tmpCol, tmpPiece.getColor());
							selectedPiece = false;
							
							// Checks for GAMEOVER
							if(gameModel.isGameOver()) {
								PieceColor winner = PieceColor.BLACK;
								
								if(playerTurn == PieceColor.BLACK) {
									winner = PieceColor.WHITE;
									whiteWins++;
								} else
									blackWins++;
								
								JOptionPane.showMessageDialog(null,
									    "Congratulations " + winner + ", you win!",
									    "WINNER!!!",
									    JOptionPane.PLAIN_MESSAGE);
								
								gameModel.resetGame();
								updatePlayerTurn();
								gameView.updateGUI(gamePieceBoard, playerTurn, blackWins, whiteWins);
							}
								
						}else {	// Selects the clicked piece
							selectedPiece = true;
							tmpRow = r;
							tmpCol = c;
							tmpPiece = gamePieceBoard[r][c];
							
							gameView.highlightSelectedLabel(r, c);
						}
					}					
				}
			}
			
			// Resets the game if "Reset" is clicked
			if(arg0.getSource() == gameBoardLabels[8][3]) {
				gameModel.resetGame();
				updatePlayerTurn();
				gameView.updateGUI(gamePieceBoard, playerTurn, blackWins, whiteWins);
			} 
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	/* Updates the playerTurn to send to GUI */
	public void updatePlayerTurn() {
		playerTurn = gameModel.getPlayerTurn();
	}
}