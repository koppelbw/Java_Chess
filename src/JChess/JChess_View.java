package jchess;

import gamepieces.JChess_GamePiece;
import gamepieces.PieceColor;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
/* *****************************************************************************
 * Project: Java Chess
 * File: JChess_View.java
 * Description: This class holds all of the GUI logic using Java Swing.
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class JChess_View extends JFrame {

	private static final long serialVersionUID = 1L;	// Auto-generated
	
	/* Instantiate GUI related variables */
	private JPanel gamePanel;
	private GridLayout gameLayout;
	private JLabel[][] gameBoardLabels;
	
	/* Constructor */
	public JChess_View() {
		gamePanel = new JPanel();
		gameLayout = new GridLayout(9, 9);
		setGameBoardLabels(new JLabel[9][9]);
		initializeCheckeredBoard();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 720);
		this.setResizable(false);
		this.setTitle("Java Chess");
		gamePanel.setLayout(gameLayout);
		this.add(gamePanel);
		
		// Set Look&Feel to Nimbus style
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}
	}
	
	/* Creates & Colors in the Chess board(black & white checkered) */
	private void initializeCheckeredBoard() {
		
		Border raised = BorderFactory.createRaisedBevelBorder();
		Border inline = BorderFactory.createLineBorder(Color.white);
		
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 8; c++) {
					getGameBoardLabels()[r][c] = new JLabel();
					
					if(r % 2 == 0 && r < 8 && c < 8) {
						getGameBoardLabels()[r][c].setBackground(Color.gray);
						if(c % 2 == 0)
							getGameBoardLabels()[r][c].setBackground(Color.lightGray);
						gameBoardLabels[r][c].setBorder(raised);
					} else if(c % 2 == 0 && r < 8 && c < 8){
						getGameBoardLabels()[r][c].setBackground(Color.gray);
						gameBoardLabels[r][c].setBorder(raised);
					} else if(r < 8 && c < 8){
						getGameBoardLabels()[r][c].setBackground(Color.lightGray);
						gameBoardLabels[r][c].setBorder(raised);
					} else {
						getGameBoardLabels()[r][c].setBackground(Color.darkGray);
						getGameBoardLabels()[r][c].setForeground(Color.white);
					}
					
					getGameBoardLabels()[r][c].setOpaque(true);					
					gamePanel.add(getGameBoardLabels()[r][c]);
			}
		}
		
		// Sets up the Reset Label
		gameBoardLabels[8][3].setText("<html><u><b><br>Reset</br><br>Game</br></b></u></html>");
		gameBoardLabels[8][3].setHorizontalAlignment(JLabel.CENTER);
		gameBoardLabels[8][3].setBorder(inline);
	}
	
	/* Updates GUI using the GamePieceBoard[][] passed by Controller class */
	public void updateGUI(JChess_GamePiece[][] gamePieceBoard, PieceColor playerTurn, int blackWins, int whiteWins) {
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(gamePieceBoard[r][c] != null) {
					
					// TODO: Replace with Icon images of pieces
					char tmp;
					if(gamePieceBoard[r][c].getColor() == PieceColor.BLACK) {
						tmp = 'B';
						gameBoardLabels[r][c].setForeground(Color.black);
					}
					else {
						tmp = 'W';
						gameBoardLabels[r][c].setForeground(Color.white);
					}
					
					gameBoardLabels[r][c].setText(
							tmp + ", " + gamePieceBoard[r][c].getName());
					gameBoardLabels[r][c].setHorizontalAlignment(JLabel.CENTER);
					
				}else {
					
					// TODO: Replace with null icon image
					gameBoardLabels[r][c].setText(" ");
				}
					
			}
		}
		
		// Updates the Labels located under the Chess board
		Border inline = BorderFactory.createLineBorder(Color.white);
		
		gameBoardLabels[8][2].setText("<html><b><br>" + playerTurn + "</br><br>TURN</br></b></html>");
		gameBoardLabels[8][2].setHorizontalAlignment(JLabel.CENTER);
		gameBoardLabels[8][2].setBorder(inline);
		
		gameBoardLabels[8][4].setText("<html><b><br>Black</br><br>Wins</br><br>" + blackWins + "</br></b></html>");
		gameBoardLabels[8][4].setHorizontalAlignment(JLabel.CENTER);
		gameBoardLabels[8][4].setBorder(inline);
		
		gameBoardLabels[8][5].setText("<html><b><br>White</br><br>Wins</br><br>" + whiteWins + "</br></b></html>");
		gameBoardLabels[8][5].setHorizontalAlignment(JLabel.CENTER);
		gameBoardLabels[8][5].setBorder(inline);
	}
	
	/* Adds ButtonListeners to all buttons. Corresponds with the Controller */
	public void addButtonListener(ActionListener listener) {
		// Unused at the moment
	}

	/* Adds MouseListeners to all gameBoardLabels */
	public void addMouseListener(MouseListener listener) {
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 8; c++)
				gameBoardLabels[r][c].addMouseListener(listener);
	}
	
	// TODO: Highlighting
	public void highlightSelectedLabel(int sRow, int sCol) {
		gameBoardLabels[sRow][sCol].setForeground(Color.yellow);
	}
	
	public void unHighlightSelectedLabel(int sRow, int sCol, PieceColor pieceColor) {
		if(pieceColor == PieceColor.BLACK)
			gameBoardLabels[sRow][sCol].setForeground(Color.black);
		else
			gameBoardLabels[sRow][sCol].setForeground(Color.white);
			
	}
	
	public JLabel[][] getGameBoardLabels() {
		return gameBoardLabels;
	}

	public void setGameBoardLabels(JLabel[][] gameBoardLabels) {
		this.gameBoardLabels = gameBoardLabels;
	}
}