package jchess;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

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
	
	
	/* Constructor */
	public JChess_Controller(JChess_Model gameModel, JChess_View gameView) {
		this.gameModel = gameModel;
		this.gameView = gameView;
		
	}

}
