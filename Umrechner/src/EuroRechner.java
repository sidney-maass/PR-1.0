import java.util.*;
import java.io.*;

public class EuroRechner {
	public static void main(String[] arg) {
		// repetition of the given task with WHILE loop (1)
		do {
			System.out.println("Für input = 0 : rechne $ in € / Für input = 1 : rechne € in $");
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			// in case of pressing 0, the program calculates € into $
			if (i == 0) {
				System.out.println("Geben sie ihren Betrag ein : \n");
				double E = sc.nextDouble();
				double D;
				String text = sc.nextLine();
				D = 0.74;
				System.out.println(E + "€=" + E * D + "$");
				// in case of any other input, the program calculates $ in €
			} else {
				System.out.println("Geben sie ihren Betrag ein : \n");
				double E = sc.nextDouble();
				double D;
				String text = sc.nextLine();
				D = 1.34;
				System.out.println(E + "$=" + E * D + "€");
			}

			// query, if the program is supposed to stop or keep running (2)
			Scanner LUmrechnung = new Scanner(System.in);
			System.out.println("Möchten Sie erneut umrechnen? " + "j-Ja/n-Nein");
			char ende;
			ende = LUmrechnung.next().charAt(0);
			if (ende == 'n') {
				return;
			}
		} while (true);
	}
}
