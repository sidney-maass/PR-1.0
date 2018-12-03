package Stacks;

public class Stack {
	private static char[] elements;

	public Stack(int size) {
		elements = new char[size];
	}
	int stackPointer = 0;
	// adds one element to the stack 
	public void push(char c) {
		elements[stackPointer] = c;
		stackPointer++;
	}

	// get stack top element by lowering stack pointer by one and return it
	public char pop() {
		return (stackPointer > 0) ? elements[--stackPointer] : '\u0000';
	}

	// Check if brackets are correct
	public String checkInput() {
		// save all closed brackets that haven't been opened yet
		String brackets = "";
		// Initialize position variable with current position
		int position = stackPointer;
		String error;
		char currentChar;
		char nextOpen = '\u0000';
		char[] brackOpen = new char[] { '(', '[', '{', '<' };
		char[] brackClose = new char[] { ')', ']', '}', '>' };
		// repeat as long as there are elements in the stack
		while ((currentChar = pop()) != '\u0000') {
			// lower position to give current position
			position--;
			// check if the current character is a bracket by comparing to all types of brackets
			for (int i = 0; i < brackOpen.length; i++) {
				// if the bracket is a closing bracket
				if (currentChar == brackClose[i]) {
					// add the corresponding opening bracket to the brackets string
					brackets += brackOpen[i];
					// update the next Open
					nextOpen = brackOpen[i];
					// stop loop
					i = brackOpen.length;
					// if the current char is an opening bracket
				} else if (currentChar == brackOpen[i]) {
					// check if the current char is the corresponding opening bracket for the last closed bracket
					if (currentChar == nextOpen) {
						// update the remaining closed brackets String
						brackets = brackets.substring(0, brackets.length() - 1);
						// update the next Open
						nextOpen = (brackets.length() > 0) ? brackets.charAt(brackets.length() - 1) : '\u0000';

					} else 	if (nextOpen != '\u0000') {
							// if there is a closed bracket that should have been opened before return error
							error = "Semantischer Fehler\n";
						} else {
							// if there is no closed bracket for this opening bracket return error
							error = "Semantischer Fehler\n";
						

						return error;
					}
					// stop loop
					i = brackOpen.length;
				}
			}
		}
		// if a bracket is closed but never opened return error
		if (brackets.length() > 0) {
			error = "semanitscher Fehler\n";
			return error;
		}
		// if there is no error return no error
		return "Korrekte Semantik\n";
	}

}