package Stacks;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Create new stack
		Stack s = new Stack(100);
		Scanner sc = new Scanner(System.in);
		String input = "";
		do {

				System.out.println("Eingabe:");
				input = sc.nextLine();

			for (int i = 0; i < input.length(); i++) {
				s.push(input.charAt(i));
			}
			System.out.println(s.checkInput());
		} while (true);

	}
}