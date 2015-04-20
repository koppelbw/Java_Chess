package jchess;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;

/* *****************************************************************************
 * Project: Java Chess
 * File: JChess_View.java
 * Description:
 * Author: William Koppelberger
 * Date: 4/20/15
 * *****************************************************************************/
public class JChess_View extends JFrame {

	/* Instantiate GUI related variables */
	private JPanel gamePanel;
	private GridLayout gameLayout;
	private JLabel[][] gameBoardLabels;
	private ImageIcon black;
	private ImageIcon white;
	private ImageIcon board;
	
	
	
	/* Constructor */
	public JChess_View() {
		gamePanel = new JPanel();
		gameLayout = new GridLayout(9, 9);
		gameBoardLabels = new JLabel[8][8];
		
		
		black = new ImageIcon(getClass().getResource("/black_marble.jpg"));
		white = new ImageIcon(getClass().getResource("/white_marble.jpg"));
		board = new ImageIcon(getClass().getResource("/chess_board.png"));
		
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				gameBoardLabels[r][c] = new JLabel(black);
				gamePanel.add(gameBoardLabels[r][c]);
			}
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(650,715);
		this.setResizable(false);
		this.setTitle("Java Chess");
		gamePanel.setLayout(gameLayout);
		
		
		this.add(gamePanel);
	}
	

}
