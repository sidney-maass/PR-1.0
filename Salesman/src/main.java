import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		SalesmanBasic();
		}


	private static void SalesmanBasic() {
		// create a new salesman which travels 10 cities with a max distance of 100
		SalesmanProblem Salesman = new SalesmanProblem(10, 100);

		// print the table of the salesman
		Salesman.printTable();

		// print a random journey for the salesman
		System.out.println("RANDOM JOURNEY");
		Salesman.randomRoute(true);

		// print the best journey for the salesman
//		System.out.println("BEST JOURNEY");
//		Salesman.getBestJourney(10000);
	}
	}