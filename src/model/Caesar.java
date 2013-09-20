package model;

public class Caesar {
	
  /**
   * Encrypts the given string using a Caesar cipher (right shift). The
   * characters A-Z, a-z, and 0-9 will be shifted, other characters will not be
   * changed.
   * @param input The string to be encrypted.
   * @param digitShift The number of places digits should be shifted by.
   * @param charShift The number of places characters should be
   *                  shifted by.
   * @return The encrypted string. 
   */
	public static String ShiftString(String input, int digitShift,
	                                 int charShift) {
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			if (Character.isDigit(current)) {
				output += ShiftDigit(current, digitShift);
			} else if(Character.getType(current) == Character.LOWERCASE_LETTER ||
			          Character.getType(current) == Character.UPPERCASE_LETTER) {
				output += ShiftChar(current, charShift);
			} else {
			  output += current;
			}
		}
		return output;		
	}
	
	/**
	 * Encrypts the given digit using a Caesar cipher (right shift). 
	 * @param input The digit to be encrypted.
	 * @param shift The number of places the digit should be shifted by.
	 * @throws IllegalArgumentException if the input is not a base-10 digit.
	 * @return The encrypted digit.
	 */
	public static int ShiftDigit(int input, int shift) {
	  if(input < 0 || input > 9){
	    throw new IllegalArgumentException("Attempted to shift integer larger" +
	                                       "than one base-10 digit");
	  }
		return (input + shift) % 10;
	}
	
	/**
	 * Encrypts the given character using a Caesar cipher (left shift).
	 * @param input The character to be encrypted.
	 * @param shift The number of places the character should be shifted by.
	 * @throws IllegalArgumentException if input is not a basic latin alphabet
	 *         character
	 * @return The encrypted character. 
	 */
	public static char ShiftChar(char input, int shift) {
		int offset;
		if (Character.getType(input) == Character.UPPERCASE_LETTER) {
			offset = 65;
		} else if (Character.getType(input) == Character.LOWERCASE_LETTER) {
			offset = 97;
		} else {
			throw new IllegalArgumentException("Attempted to shift non-basic latin" +
			                                   "character");
		}
		
		// Get number of letter, where A=0 and Z=25, for easier modulo arithmetic
		int inputLetter = (int) input - offset;
		int outputLetter = (inputLetter + shift) % 26;
		// Convert back to codepoint
		return (char) (outputLetter + offset);
	}
}
