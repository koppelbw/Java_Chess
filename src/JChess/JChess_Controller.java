package jchess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import gamepieces.JChess_GamePiece;

/* *****************************************************************************
 * Project: Java Chess
 * File: JChess_Controller.java
 * Description: 
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class JChess_Controller {
	
	private JChess_Model gameModel;
	private JChess_View gameView;
	private JChess_GamePiece[][] gamePieceBoard;
	private JLabel[][] gameBoardLabels;
	private boolean selectedPiece;
	private int tmpRow, tmpCol;
	private JChess_GamePiece tmpPiece;
	
	/* Constructor */
	public JChess_Controller(JChess_Model gameModel, JChess_View gameView) {
		this.gameModel = gameModel;
		this.gameView = gameView;
		gamePieceBoard = gameModel.getGamePieceBoard();
		gameBoardLabels = gameView.getGameBoardLabels();
		selectedPiece = false;
		
		
		this.gameView.updateGUI(gamePieceBoard);

		// Tells the View that if buttons are clicked, call actionPerformed
		this.gameView.addButtonListener(new ButtonListener());
		this.gameView.addMouseListener(new MouseHandler());
	}


	/* This method handles game interactions. Corresponds to View method */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//JButton resetButton = gameView.getResetButton();
			
			//if(e.getSource() == resetButton) {
			//}
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
					if(gameBoardLabels[r][c] == arg0.getSource()) {
						if(selectedPiece && tmpPiece != null) {	// SECOND CLICK to move the piece
							if(gameModel.movePieceAttempt(tmpRow, tmpCol, r, c, tmpPiece)) {
								gameView.updateGUI(gamePieceBoard);
							}
							selectedPiece = false;
						}else {
							selectedPiece = true;
							tmpRow = r;
							tmpCol = c;
							tmpPiece = gamePieceBoard[r][c];
							
						}
						
						
						
					}
				}
			}
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

}
