/** Canvas.java Controls the grid in which text art can be created
 * 
 * @author Tevin Scott
 * @version 02/15/2015
 * 
 */
public class Canvas {
	private int rows;
	private int columns;
	private Pixel[][] canvas;
	private final char BLANK = '-';
	/**
	 * this constructs a canvas
	 * @param _rows the height of the canvas
	 * @param _colomns the width of the canvas
	 */
	public Canvas(int _rows, int _colomns){
		this.rows = _rows;
		this.columns = _colomns;
		canvas = new Pixel[this.rows][this.columns];
		for(int rowCtrl = 0; rowCtrl < this.rows; rowCtrl++){
			for(int colCtrl = 0; colCtrl < this.columns; colCtrl++){
				this.canvas[rowCtrl][colCtrl] = new Pixel(BLANK);
			}
		}
	}
	/**
	 * allows the array to be printed
	 * @return holder collates the pixels' toStrings and prints them
	 */
	public String toString(){
		String holder = "";
		
		for(int rowCtrl = 0; rowCtrl < this.rows; rowCtrl++){
			holder += "\n"; 
			for(int colCtrl = 0; colCtrl < this.columns; colCtrl++){
				holder += canvas[rowCtrl][colCtrl].toString();
			}
		}	
		return holder;
	}
	/**
	 * returns the character at the specified location
	 * @param row the selected row
	 * @param col the selected column
	 * @return output the character at the specified location
	 */
	private char getToken(int row, int col){
		char output = this.canvas[row][col].getElement();
		return output;
	}
	/**
	 * checks to see if the inputed character is in the array
	 * @param input character to be searched for
	 * @return answer answers if the character is within the array
	 */
	private boolean changeCheck(char input){
		boolean answer = false;
		for(int row = 0; row < this.rows; row++){
			for(int col = 0; col < this.columns; col++){
				if(input == getToken(row,col)){
					answer = true;
				}
			}
		}
		return answer;
	}
	/**
	 * changes all occurances of the inputed character with the new character
	 * @param previous the character that will be changed
	 * @param newToken the character that will replace the previous
	 */
	public void changeAll(char previous, char newToken){
		for(int row = 0; row < this.rows; row++){
			for(int col = 0; col < this.columns; col++){
				if(canvas[row][col].getElement() == previous)
					canvas[row][col].update(newToken);
			}
		}	
	}
	/**
	 * this returns the number of rows in the canvas
	 * @return rows of the canvas
	 */
	public int getRows(){
		return this.rows;
	}
	/**
	 * this returns the number of columns in the canvas
	 * @return columns of the canvas
	 */
	public int getCols(){
		return this.columns;
	}
	/**
	 * counts the amount of occurrences of given character
	 * @return count the amount of occurrences of given character
	 */
	public int charCount(){
		int count = 0;
		for(int row = 0; row < this.rows; row++){
			for(int col = 0; col < this.columns; col++){
				if(canvas[row][col].getElement() != '-')
					count++;
			}
		}
		return count;
	}
	/**
	 * 
	 * @param rowInput row location
	 * @param colInput column location
	 * @param tokenInput the new character that will be placed at the specified location
	 */
	public void update(int rowInput, int colInput, char tokenInput){
		this.canvas[rowInput][colInput].update(tokenInput);;
	}
	
}
