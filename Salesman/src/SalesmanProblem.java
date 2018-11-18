
public class SalesmanProblem {
	private int Dist;
	private int[][] table;

	public static void main(String[] args) {
		//A1 (10 for 10 cities)(100 a max distance for 100 units (clarity))
		SalesmanProblem Salesman = new SalesmanProblem(10, 100);

		System.out.println("Tabelle (A1)\n\n  0   1   2   3   4   5   6   7   8   9");
		Salesman.Table();
		
		//A2
		System.out.println("_______________________\n\nZufällige Route (A2)\n");
		Salesman.randomRoute(true);

		//A3
		System.out.println("________________________\n\nBeste Route (A3)\n");
		Salesman.BestRoute(10000);
	}

	//fills the table with random numbers 
	public SalesmanProblem(int cities, int maxDist) {
		this.Dist = cities;
		table = new int[Dist][Dist];

		for (int i = 0; i < Dist; i++) {
			for (int n = 0; n < Dist; n++) {

				//diagonal row of 0;
				if (i == n) {
					table[i][n] = 0;

				// 
				} else if (n > i) {
					int d = (int) (Math.random() * maxDist);
					//prevents the route between 2 cities of being 0
					while (d == 0) {
						d = (int) (Math.random() * maxDist);

					}
					table[i][n] = d;

				// reflects the random numbers so the distance between them is the same amount
				} else if (n < i) {
					table[i][n] = table[n][i];
				}
			}
		}

	}

	//generates a random route for the 10 cities
	public int[] randomRoute(boolean b) {
		//save the visited order
		int[] randomRoute = new int[Dist];
		for (int j = 0; j < Dist; j++) {
			randomRoute[j] = j;
		}
		//generates a random order for the 10 cities 
		for (int z = 0; z < Dist; z++) {
			int temp = randomRoute[z];
			int rand = (int) (Math.random() * Dist);
			randomRoute[z] = randomRoute[rand];
			randomRoute[rand] = temp;

		}
		//because boolean = true it gives out the route
		if (true) {
			
			//prints out the random route
			for (int i = 0; i < randomRoute.length; i++) {
				if (i == 0) {
					System.out.println("Stadt " + i + " : " + randomRoute[i] + ". Distanz von der letzten Stadt = 0");
				} else {
					System.out.println("Stadt " + i + " : " + randomRoute[i] + ". Distanz von der letzten Stadt = "
							+ table[randomRoute[i]][randomRoute[i - 1]]);
				}
			}
			// Prints out max distance
			System.out.println("\nGesamte Distanz =  " + Length(randomRoute) + " Einheiten\n");
		}
		return randomRoute;
	}

	//A3 tries to generate the best route
	public void BestRoute(int testRounds) {
		//memorizes the current best route
		int[] presentRoute = randomRoute(true);
		System.out.println("Erste Route =  " + Length(presentRoute));

		//checking for a different Route
		for (int i = 0; i < testRounds; i++) {
			//switches the new Route with the old one
			int[] genRoute = swapRoutes(presentRoute);
			//memorizes the new better route
			if (Length(genRoute) < Length(presentRoute)) {
				System.out.println("Eine bessere Route ist = " + Length(genRoute) + " Einheiten");
				presentRoute = genRoute;

			}
		}
		System.out.println("\nBeste gefundene Route = " + Length(presentRoute) + "\n\nDer Weg dazu ist :\n");

		//prints out the best route
		for (int i = 0; i < presentRoute.length; i++) {
			if (i == 0) {
				System.out.println("Stadt " + i + ": " + presentRoute[i] + ". Distanz von der letzten Stadt = 0");
			} else {
				System.out.println("Stadt " + i + ": " + presentRoute[i] + ". Distanz von der letzten Stadt = "
						+ table[presentRoute[i]][presentRoute[i - 1]]);
			}
		}
	}

	//gives the length of a route
	private int Length(int[] Route) {
		
		//save distance between 2 cities
		int[] distance = new int[Dist];

		for (int i = 0; i < distance.length - 1; i++) {
			distance[i] = table[Route[i]][Route[i + 1]];
		}

		//counts distances together
		int traveledDistance = 0;
		for (int i = 0; i < distance.length; i++) {
			traveledDistance = traveledDistance + distance[i];
		}

			//return to start point
		traveledDistance = traveledDistance + table[Route[Route.length - 1]][Route[0]];
		return traveledDistance;
	}

	//switches the routes
	private int[] swapRoutes(int[] presentRoute) {
		
		//saves copy of new route
		int[] newRoute = new int[Dist];

		for (int i = 0; i < newRoute.length; i++) {
			newRoute[i] = presentRoute[i];
		}
		//switches the order of visited cities randomly
		int rand1 = (int) (Math.random() * Dist);
		int rand2 = (int) (Math.random() * Dist);
		int bs = newRoute[rand1];
		newRoute[rand1] = newRoute[rand2];
		newRoute[rand2] = bs;
		return newRoute;

	}

	//prints Table
	public void Table() {
		for (int i = 0; i < Dist; i++) {
			for (int j = 0; j < Dist; j++) {
				if (table[i][j] < 10) {
					System.out.print("| " + table[i][j] + "|");
				} else {
					System.out.print("|" + table[i][j] + "|");
				}
			}
			System.out.println("\n|__||__||__||__||__||__||__||__||__||__|");
		}
	}
}
