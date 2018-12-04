package Stacks;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Create new stack
		Stack myStack = new Stack(100);
		Scanner sc = new Scanner(System.in);
		String input = "";
		do {

				System.out.println("Eingabe:");
				input = sc.nextLine();

			for (int i = 0; i < input.length(); i++) {
				myStack.push(input.charAt(i));
			}
			System.out.println(myStack.checkInput());
		} while (true);

	}
}
