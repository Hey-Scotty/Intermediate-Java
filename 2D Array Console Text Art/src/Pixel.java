/** Pixel.java This stores a character for a specific pixel and has methods for altering and printing the value
 * 
 * @author Tevin Scott
 * @version 02/15/2015
 * 
 */
public class Pixel {
	
	private char element;
	
	/**
	 * creates a instance of a pixel
	 * @param _element the character to be stored
	 */
	public Pixel (char _element){
		this.element = _element;
	}
	/**
	 * changes the character to the input
	 * @param token the new character
	 */
	public void update(char token){
		this.element = token;
	}
	/**
	 *  returns the character stored within the pixel
	 * @return the charactered stored within the pixel
	 */
	public char getElement(){
		return this.element;
	}
	/**
	 * prints the pixel
	 * @return output prints char as string
	 */
	public String toString(){
		String output = "";
		output += element;
		return output;
	}
}
