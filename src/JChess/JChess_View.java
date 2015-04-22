package jchess;

import gamepieces.JChess_GamePiece;
import gamepieces.PieceColor;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;
/* *****************************************************************************
 * Project: Java Chess
 * File: JChess_View.java
 * Description: 
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
		this.setSize(720, 720);
		this.setResizable(false);
		this.setTitle("Java Chess");
		gamePanel.setLayout(gameLayout);
		
		this.add(gamePanel);
	}
	
	/* Creates & Colors in the Chess board(black & white checkered) */
	private void initializeCheckeredBoard() {
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
					getGameBoardLabels()[r][c] = new JLabel();
					
					if(r % 2 == 0 && r < 8 && c < 8) {
						getGameBoardLabels()[r][c].setBackground(Color.black);
						if(c % 2 == 0)
							getGameBoardLabels()[r][c].setBackground(Color.white);
					} else if(c % 2 == 0 && r < 8 && c < 8){
						getGameBoardLabels()[r][c].setBackground(Color.black);
						
					} else if(r < 8 && c < 8){
						getGameBoardLabels()[r][c].setBackground(Color.white);
					}
								
					getGameBoardLabels()[r][c].setOpaque(true);					
					gamePanel.add(getGameBoardLabels()[r][c]);
			}
		}
	}
	
	/* Updates GUI using the GamePieceBoard[][] passed by Controller class */
	public void updateGUI(JChess_GamePiece[][] gamePieceBoard) {
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(gamePieceBoard[r][c] != null) {
					
					// TODO: Replace with Icon images of pieces!!!
					char tmp;
					if(gamePieceBoard[r][c].getColor() == PieceColor.BLACK) {
						tmp = 'B';
						gameBoardLabels[r][c].setForeground(Color.blue);
					}
					else {
						tmp = 'W';
						gameBoardLabels[r][c].setForeground(Color.red);
					}
					
					gameBoardLabels[r][c].setText(
							tmp + ", " + gamePieceBoard[r][c].getName());
					
					
				}else {
					
					// TODO: Replace with null icon image
					gameBoardLabels[r][c].setText(" ");
				}
					
			}
		}
	}

	
	
	/* Adds ButtonListeners to all buttons. Corresponds with the Controller */
	public void addButtonListener(ActionListener listener) {
		//resetButton.addActionListener(listener);
	}

	/* Adds MouseListeners to all gameBoardLabels */
	public void addMouseListener(MouseListener listener) {
		for (int r = 0; r < 8; r++)
			for (int c = 0; c < 8; c++)
				gameBoardLabels[r][c].addMouseListener(listener);
	}
	
	
	public void highlightSelectedLabel(int sRow, int sCol) {
		gameBoardLabels[sRow][sCol].setBackground(Color.yellow);
	}
	
	public void unHighlightSelectedLabel(int sRow, int sCol) {
		gameBoardLabels[sRow][sCol].setBackground(Color.white);
	}
	
	public JLabel[][] getGameBoardLabels() {
		return gameBoardLabels;
	}

	public void setGameBoardLabels(JLabel[][] gameBoardLabels) {
		this.gameBoardLabels = gameBoardLabels;
	}
	
}