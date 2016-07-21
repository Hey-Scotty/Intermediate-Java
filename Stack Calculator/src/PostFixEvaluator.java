import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */

/** PostFixEvaluator.java
 *
 *
 * @author TinieT
 * @version Feb 25, 2015
 * 
 */
public class PostFixEvaluator {

	private LinkedList<Double> stackHolder;
	private String userInput;
	private String shortenedInput;
	

	public PostFixEvaluator(){
		stackHolder = new LinkedList<Double>();
		userInput = "";
	}
	
	/**
	 * takes String text and stores it within the object
	 * @param input - text to be stored as Attribute
	 */
	public void addInput(String input){
		this.userInput = input;
	}
	
	/**
	 * Evaluates the inputed postfix expression
	 * @return output - outputs the evaluated postfix expression 
	 */
	public double Evaluate(){
		double output = 0;
		whiteSpace();
		Scanner scan = new Scanner(userInput);
		scan.useDelimiter(" ");
		String pointer = "";
		while(scan.hasNext()){
			this.stack(userInput);
			scan = new Scanner(userInput);
			pointer = scan.next();
			if(oprandCheck(pointer))
				this.checkOperation(pointer);
		}
		System.out.println("number of elements on stack after computation: " + stackHolder.size());
		output = stackHolder.pop();
		return output;
	}
	/**
	 * pushes numbers up to the next oprand onto the stack
	 * @param input
	 */
	private void stack(String input){
		Scanner scan = new Scanner(input);
		int cutTracker = 0;
		double numberHolder = 0;
		String numCheck = scan.next();
		scan.useDelimiter(" ");
		while(!oprandCheck(numCheck)){
			numberHolder = Double.parseDouble(numCheck);
			stackHolder.push(numberHolder);
			cutTracker += numCheck.length() + 1;
			numCheck = scan.next();
			if(!scan.hasNext())
				break;
		}
		userInput = this.shorten(this.userInput, cutTracker);
	}
	
	/**
	 * checks the user input for correct postfix notation
	 * @return answer if inputed expression is the correct format returns true if not returns false
	 */
	public boolean validate(){
		int counter = 0;
		int initialCheck = 0;
		Scanner scan = new Scanner(userInput);
		scan.useDelimiter(" ");
		String holder = "";
		while(scan.hasNext()){
			holder = scan.next();
			if(isNumeric(holder))
				counter++;
			if(oprandCheck(holder)){
				counter -= 2;
				counter += 1;
			}
			if(initialCheck == 1)
				if(!isNumeric(holder)){
					counter = 0;
					break;
				}
			initialCheck++;
		}
		if(counter == 1)
			return true;
		else 
			return false;
	}
	/**
	 * taken from stack overflow from user Jayamohan - checks string for a parsable number
	 * @param str input to be checked
	 * @return if input is a number returns true if not returns false
	 */
	public boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	/**
	 *	the first two values on the stack are popped and added together the result is then pushed onto the stack
	 * @param input
	 */
	private void addVal(){
		double valueOne = stackHolder.pop();
		double valueTwo = stackHolder.pop();
		stackHolder.push(valueTwo + valueOne);
	}
	/**
	 *	the first two values on the stack are popped and subtracted from each other. the result is then pushed onto the stack
	 * @param input
	 */
	private void subtractVal(){
		double valueOne = stackHolder.pop();
		double valueTwo = stackHolder.pop();
		stackHolder.push(valueTwo - valueOne);
	}
	/**
	 *	the first two values on the stack are popped and multiplied together the result is then pushed onto the stack
	 * @param input
	 */
	private void multiplyVal(){
		double valueOne = stackHolder.pop();
		double valueTwo = stackHolder.pop();
		stackHolder.push(valueTwo * valueOne);
	}
	/**
	 *	the first two values on the stack are popped and divided. the result is then pushed onto the stack
	 * @param input
	 */
	private void divideVal(){
		double valueOne = stackHolder.pop();
		double valueTwo = stackHolder.pop();
		stackHolder.push(valueTwo / valueOne);
	}
	/**
	 * checks the string for binary operators. if an operand is found, the corresponding operator method is called and the string is shortened   
	 * @param input
	 */
	private void checkOperation(String input){
		boolean answer = false;
		if(input.equals("+")){
			userInput = shorten(userInput, 2);
			this.addVal();
		}
		if(input.equals("-")){
			this.subtractVal();
			userInput = shorten(userInput, 2);
		}
		if(input.equals("*")){
			this.multiplyVal();
			userInput = shorten(userInput, 2);
		}
		if(input.equals("/")){
			this.divideVal();
			userInput = shorten(userInput, 2);
		}	
	}
	
	/** 
	 * Checks the inputed string for an operator
	 * @param input
	 * @return answer if the operator is present the method returns true otherwise it will be false; 
	 */
	private boolean oprandCheck(String input){
		boolean answer = false;
		if(input.equals("+")){
			answer = true;
		}	
		if(input.equals("-")){
			answer = true;
		}
		if(input.equals("*")){
			answer = true;
		}	
		if(input.equals("/")){
			answer = true;
		}
		return answer;
	}
	private String shorten(String text, int location){
		String output = "";
			output = text.substring(location, text.length());	
		return output;
	}
	
	private void whiteSpace(){
		if(userInput.substring(userInput.length() - 1).equals(" "));
		   userInput+= " ";
	}
}
