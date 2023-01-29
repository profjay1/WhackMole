pubic class WhackMoleTest {

/**
	 * Begin by creating a 10 by 10 grid where you randomly place the moles. 
	 * Place a total of 10 moles.
	 * Now allow the user  to enter the x and y coordinates of where they would like to take a whack. 
	 * Tell them they have a maximum of 50 attempts to get all the moles. 
	 * At any point in the game, they can input coordinates of -1, -1 in order to indicate that they are giving up. 
	 * If the user gives up they get to see the entire grid.  
	 * The game ends if the user is able to uncover all the moles or if the user runs out of attempts. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhackAMole game = new WhackAMole(50, 10);
		Random random = new Random();
		for (int i = 0; i < 10; i++) { // randomly place 10 moles
			game.place(random.nextInt(10), random.nextInt(10));
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the game!");
		
		while (game.attemptsLeft > 0 && game.molesLeft > 0) {
			System.out.println("Attempts left: " + game.attemptsLeft);
			System.out.println("Score: " + game.score);
			game.printGridToUser();
			System.out.print("Where do you like to whack? ");
			
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			if (x == -1 && y == -1) {
				game.printGrid();
				break;
			}
			
			game.whack(x, y);
			
		
		}
		System.out.println("Game over!");
		
	}

}

