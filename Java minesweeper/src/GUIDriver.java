import javax.swing.JOptionPane;

/**
 * 
 */

/** GUIDriver.java
 *
 *
 * @author TinieT
 * @version Feb 24, 2015
 * 
 */
public class GUIDriver {
	public static void main(String[] args){
		int height = Integer.parseInt(JOptionPane.showInputDialog(null, "input height"));
		int width = Integer.parseInt(JOptionPane.showInputDialog(null, "input width"));
		Minesweeper game = new Minesweeper(height, width);
		game.check();
		
	}
}
