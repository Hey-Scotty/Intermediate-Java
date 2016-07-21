import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Minesweeper.java
 *
 *
 * @author TinieT
 * @version Feb 17, 2015
 * 
 */
public class Minesweeper extends JFrame{
	JPanel p = new JPanel();
	MineButton buttons[][];
	int rows;
	int columns;
	Grid grid;
	int mineCount;
	public Minesweeper(int _rows, int _columns){
		super("Minesweeper");
		rows = _rows;
		columns = _columns;
		buttons = new MineButton[rows][columns];
		grid = new Grid(rows, columns);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Cell[][] holder = grid.getGrid();
		p.setLayout(new GridLayout(rows,columns));
		for(int i = 0; i < rows; i++){
			for(int k = 0; k < columns; k++){
				buttons[i][k] = new MineButton(holder[i][k]);
				p.add(buttons[i][k]);
			}	
		}
		for(int i = 0; i < rows; i++){
			for(int k = 0; k < columns; k++){
				if(buttons[i][k].isMine())
					mineCount++;
			}
		}
		setSize(rows*26,columns*26);
		setVisible(true);
		add(p);
	}
	public void check(){
		for(int i = 0; i < rows; i++){
			for(int k = 0; k < columns; k++){
				if(buttons[i][k].isRevealed()){
					buttons[i][k].setMineIcon();
				}
			}
		}
	}
}
