/** Controller.java collates they classes of view and canvas to be run in a main method
 * 
 * @author Tevin Scott
 * @version 02/15/2015
 * 
 */
import java.util.Scanner;


public class Controller {
	/**
	 * creates an instance of the view class and other options to be printed for the user
	 */
	public void start(){
		View view = new View();
		Scanner keyboard = new Scanner(System.in);
		int input;
		int rows = view.setRows();
		int columns = view.setCols();
		char original;
		char newChar;
		Canvas canvas = new Canvas(rows, columns);
		boolean done = false;
		int rowHolder,colHolder;
		char token;
		while (!(done))
		{
			view.display(canvas.toString());
			System.out.println("choose options");
			System.out.println("1. paint");
			System.out.println("2. multi paint (change all)");
			System.out.println("3. character count");
			System.out.println("4. exit editor");
			input = keyboard.nextInt();
			if(input == 1){
				rowHolder = view.askRow();
				colHolder = view.askCol();
				token = view.getToken();
				canvas.update(rowHolder, colHolder, token);
			}
			else if(input == 2){
				System.out.println("input character to be changed");
				original= keyboard.next().charAt(0);
				System.out.println("input new character");
				newChar = keyboard.next().charAt(0);

				canvas.changeAll(original, newChar);
			}
			else if(input == 3){
				System.out.println(" The number of characters on the canvas is " + canvas.charCount());
			}
			else if(input == 4){
				done = true;
			}
		}	
			
	}
}
