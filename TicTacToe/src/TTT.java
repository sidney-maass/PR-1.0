import java.util.*;

public class TTT {
	static Scanner sc;
	static String[] board;
	static int turn;
	private static int x;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		board = new String[9];

		String winner = null;
		populateEmptyBoard();
		System.out.println("Wilkommen zu Tic-Tac-Toe");
		printBoard();

		while (winner == null) {
			int Eingabe;

			Eingabe = sc.nextInt();
			if (turn == 0) {

				board[Eingabe - 1] = "X";
				turn = 1;
			}

			else {

				while (true) {

					int h = (int) ((Math.random()) * 8) + 1;
					if (board[h].equals("O") | board[h].equals("X")) {

					} else {

						board[h] = "O";
						turn = 0;

						break;
					}
				}

			}

			printBoard();

			winner = checkWinner();
			x++;
			if (x == 9) {
				System.out.println("draw");
				break;
			}
		}

		if (winner != null) {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}

	}

	static String checkWinner() {
		for (int i = 0; i < 8; i++) {
			String Z = null;
			switch (i) {
			case 0:
				Z = board[0] + board[1] + board[2];
				break;
			case 1:
				Z = board[3] + board[4] + board[5];
				break;
			case 2:
				Z = board[6] + board[7] + board[8];
				break;
			case 3:
				Z = board[0] + board[3] + board[6];
				break;
			case 4:
				Z = board[1] + board[4] + board[7];
				break;
			case 5:
				Z = board[2] + board[5] + board[8];
				break;
			case 6:
				Z = board[0] + board[4] + board[8];
				break;
			case 7:
				Z = board[2] + board[4] + board[6];
				break;

			}
			if (Z.equals("XXX")) {
				return "X";
			} else if (Z.equals("OOO")) {
				return "O";

			}

		}
		return null;

	}

	static void printBoard() {

		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");

	}

	static void populateEmptyBoard() {
		for (int i = 0; i < 9; i++) {
			board[i] = String.valueOf(i + 1);
		}
	}

}
