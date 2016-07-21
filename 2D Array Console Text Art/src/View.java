/** View.java Various methods that allow the text art program to be viewed and altered 
 * 
 * @author Tevin Scott
 * @version 02/15/2015
 * 
 */
import java.util.Scanner;
public class View {
	final private int LOWER_BOUND = 5;
	final private int UPPER_BOUND = 50;
	/**
	 * displays the canvas
	 * @param input input to be printed
	 */
	public void display(String input){
		System.out.println(input);
	}
	/**
	 * sets the row length of the canvas from user input
	 * @return size length of the rows
	 */
	public int setRows(){
		int size = 0;
		Scanner keyboard = new Scanner(System.in);
		boolean checker = false;
		while(!checker){
			System.out.println("input row size (5 - 50)");
			size = keyboard.nextInt();
			if(size < LOWER_BOUND || size > UPPER_BOUND){
				System.out.print("That Number is not valid\n");
			}
			else
				checker = true;
		}
		return size;
	}
	/**
	 * sets the column length of the canvas from user input
	 * @return size length of the columns
	 */
	public int setCols(){
		int size = 0;
		Scanner keyboard = new Scanner(System.in);
		boolean checker = false;
		while(!checker){
			System.out.println("input column size (5 - 50)");
			size = keyboard.nextInt();
			if(size < LOWER_BOUND || size > UPPER_BOUND){
				System.out.print("That Number is not valid\n");
			}
			else
				checker = true;
		}
		return size;
	}
	/**
	 * Verifies the user has input the correct location
	 * @param input column location to be checked
	 * @param check checks to see if the input is within the range
	 * @return answer if the input is indeed within the range
	 */
	public boolean checkCol(int input, Canvas check){
		boolean answer = false;
		if(input <= check.getCols() || input > 1)
			answer = true;
		else
			System.out.println("invalid location. please try again");
		return answer;
	}
	/**
	 * Verifies the user has input the correct location
	 * @param input row location to be checked
	 * @param check checks to see if the input is within the range
	 * @return answer if the input is indeed within the range
	 */
	public boolean checkRow(int input, Canvas check){
		boolean answer = false;
		if(input <= check.getRows() || input > 1)
			answer = true;
		else
			System.out.println("invalid location. please try again");
		return answer;
	}
	/**
	 * checks to see if the character inputed is valid
	 * @param input character to be checked
	 * @return answer if the character fits the requirements
	 */
	private boolean checkToken(char input){
		boolean answer = false;
		if(input == '-' || input == '+' || input == 'v' || input == 'V' || input == '^' || input == '/' ||input == '\\' || input == '|')
				answer = true;
		return answer;
	}
	/**
	 * prompts user for the row they would like to select
	 * @return rowLocation selected row
	 */
	public int askRow(){
		int rowLocation = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("select location of next pixel");
		rowLocation = keyboard.nextInt() - 1;
		return rowLocation;
	}
	/**
	 * prompts user for the column they would like to select
	 * @return colLocation selected column
	 */
	public int askCol(){
		int colLocation = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("select location of next pixel");
		colLocation = keyboard.nextInt() - 1;
		return colLocation;
	}
	/**
	 * prompts user for the character they would like to use
	 * @return token the character from the user's input
	 */
	public char getToken(){
		char token;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("choose token to be placed");
		token = keyboard.next().charAt(0);
		if(!checkToken(token)){
			while(!checkToken(token)){
				System.out.println("invalid token chosen. Please try again.");
				System.out.println("choose token to be placed");
				token = keyboard.next().charAt(0);
			}
		}
		return token;
	}
	
}
