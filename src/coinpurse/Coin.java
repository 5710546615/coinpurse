package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 */

public class Coin extends AbstractValuable {

	/** The currency, default set to "Baht". */
	private static String default_currency = "Baht";

	/**
	 * Initialize a new Coin with the value.
	 * 
	 * @param value
	 *            is the value of coin.
	 */
	public Coin(double value) {
		super(value, default_currency);
	}

	/**
	 * Initialize a new Coin with the value and currency.
	 * 
	 * @param value
	 *            is the value of coin. Curr is the currency of Coin.
	 */
	public Coin(double value, String curr) {
		super(value, curr);
	}

	/**
	 * To get the information of the Coin.
	 * 
	 * @return a String describing the Coin.
	 */
	public String toString() {
		return (int) this.getValue() + "-" + this.getCurrency() + " coin";
	}

}
