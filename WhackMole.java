import java.util.*;

public class WhackMole {
	int score;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid; 
	
	/**
	 * Specifies total number of whacks allowed, and the grid dimension.  
	 * Initializes the moleGrid with the * character.
	 * 
	 * @param numAttempts the total number of whacks allowed 
	 * @param gridDimension of the moleGrid
	 */
	public WhackAMole(int numAttempts, int gridDimension) {
		this.score = 0;
		this.molesLeft = 0;
		this.attemptsLeft = numAttempts;
		this.moleGrid = new char[gridDimension][gridDimension];
		for (char[] r : moleGrid) {
			Arrays.fill(r, '*');
		}
		
	}
	
	/**
	 * Given a location, place a mole at that location. 
	 * Update number of moles left.
	 * Return whether it is possible to place. 
	 */
	public boolean place(int x, int y) {
		if (moleGrid[x][y] == 'M') return false;
		moleGrid[x][y] = 'M';
		molesLeft += 1;
		return true;
	}
	
	/**
	 * Given a location, take a whack at that location. 
	 * If that location contains a mole, the score, number of attemptsLeft, and molesLeft is updated. 
	 * If that location does not contain a mole, only attemptsLeft is updated.
	 */
	public void whack(int x, int y) {
		if (moleGrid[x][y] == 'M') {
			score += 10;
			molesLeft--;
			moleGrid[x][y] = 'W';
		}
		attemptsLeft--;
	}
	
	/**
	 * Print the grid without showing where the moles are. 
	 * For every spot that has recorded a “whacked mole” print out a W, 
	 * or * otherwise.
	 */
	public void printGridToUser() {
		for (char[] r : moleGrid) {
			for (char e : r) {
				if (e != 'W') {
					System.out.print("*");
				} else {
					System.out.print("W");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Print the grid completely. 
	 * This is effectively dumping the 2d array on the screen. 
	 * The places where the moles are should be printed as an ‘M’. 
	 * The places where the moles have been whacked should be printed as a ‘W’. 
	 * The places that don’t have a mole should be printed as *.
	 */
	public void printGrid() {
		for (char[] r : moleGrid) {
			for (char e : r) {
				if (e == 'M') {
					System.out.print("M");
				} else if (e == 'W') {
					System.out.print("W");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
