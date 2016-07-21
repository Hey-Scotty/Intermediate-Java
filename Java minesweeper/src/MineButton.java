import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/** MineButton.java
 *
 *
 * @author TinieT
 * @version Feb 17, 2015
 * 
 */
public class MineButton extends JButton implements MouseListener{
	ImageIcon blank, one, two, three, four, five, six, seven, eight, mine, untouched,flag;
	private int value;
	private boolean answer;
	private boolean isFlag;
	private boolean mineRevealed;
	/*
	 0 = blank(0)
	 1 = one
	 2 = two
	 3 = three
	 4 = four
	 5 = five
	 6 = six
	 7 = seven
	 8 = eight
	 9 = mine (nice rhyme :D)
	 10 = untouched
	 */
	
	public MineButton(Cell cell){
		blank = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/blank.png");
		one = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/1.png");
		two = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/2.png");
		three = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/3.png");
		four = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/4.png");
		five = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/5.png");
		six = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/6.png");
		seven = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/7.png");
		eight = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/8.png");
		mine  = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/mine.png");
		untouched  = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/untouched.png");
		flag = new ImageIcon("C:/Users/TinieT/Google Drive/Radford course/Computer science/XML/minesweeper/sprites/flag.png");
		
		answer = cell.isMine();
		value = cell.getMineCount();
		setIcon(untouched);
		this.addMouseListener(this);
		isFlag = false;
		mineRevealed = false;
	}
	public boolean isRevealed(){
		return mineRevealed;
	}
	public boolean isMine(){
		return answer;
	}
	public void setMineIcon(){
		setIcon(mine);
	}
	public void mouseClicked(MouseEvent e){
		if(SwingUtilities.isRightMouseButton(e)){
			if(!isFlag){
				setIcon(flag);
				isFlag = true;
			}	
			else if(isFlag){
				setIcon(untouched);
				isFlag = false;
			}	
		}		
		if(SwingUtilities.isLeftMouseButton(e)){
			if(answer){
				setIcon(mine);
				JOptionPane.showMessageDialog(null, "game over. You hit a mine buddy!");
				mineRevealed = true;
			}
			else if(!answer){
				switch(value){
				case 0:
					setIcon(blank);
					break;
				case 1:
					setIcon(one);
					break;
				case 2:
					setIcon(two);
					break;
				case 3:
					setIcon(three);
					break;
				case 4:
					setIcon(four);
					break;
				case 5:
					setIcon(five);
					break;
				case 6:
					setIcon(six);
					break;
				case 7:
					setIcon(seven);
					break;	
				case 8:
					setIcon(eight);
					break;
				}	
			}
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
}	
