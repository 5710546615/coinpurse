package coinpurse;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coinpurse.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 * 
 */

public class Main {

	/** Capacity is maximum number of valuable items the purse can hold. */
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		Purse purse = new Purse(CAPACITY);
		ConsoleDialog ui = new ConsoleDialog(purse);
		ui.run();
	}
}
