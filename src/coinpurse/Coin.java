package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 * 
 */

public class Coin implements Valuable {

	/** Value of the coin. */
	private double value;
	/** The currency, default set to "Baht". */
	private String currency = "Baht";

	/**
	 * Initialize a new Coin with the value.
	 * 
	 * @param value
	 *            is the value of coin.
	 */
	public Coin(double value) {
		this.value = value;
	}

	/**
	 * Initialize a new Coin with the value and currency.
	 * 
	 * @param value
	 *            is the value of coin. Curr is the currency of Coin.
	 */
	public Coin(double value, String curr) {
		this.value = value;
		this.currency = curr;
	}

	/**
	 * Get the value of the Coin.
	 * 
	 * @return the value of the Coin.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of the Coin.
	 * 
	 * @return the currency of the Coin.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * To check that Coin is equal or not.
	 * 
	 * @param obj
	 *            is the object which we want to check.
	 * @return true if the Value and Currency of Coin is equal. Otherwise false.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj.getClass() != this.getClass())
			return false;

		Coin coin = (Coin) obj;

		if (this.getValue() == coin.getValue() && this.getCurrency() == coin.getCurrency())
			return true;

		return false;
	}

	/**
	 * To check the value of a Coin that is more, less or equal.
	 * 
	 * @param o
	 *            is the Coin which we want to compare.
	 * @return 1 if more, -1 if less, 0 if equal.
	 */
	public int compareTo(Coin o) {
		if (this.getValue() > o.getValue())
			return 1;

		if (this.getValue() < o.getValue())
			return -1;

		return 0;
	}

	/**
	 * To get the information of the Coin.
	 * 
	 * @return a String describing the Coin.
	 */
	public String toString() {
		return (int) this.value + "-" + this.currency + " coin";
	}

}
