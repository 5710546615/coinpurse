package coinpurse;

/**
 * AbstractValuable is the parent class for Coin and BankNote.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 * 
 */

public abstract class AbstractValuable implements Valuable {

	/* Value of Valuable */
	private double value;
	/* Currency of Valuable */
	private String currency;

	/**
	 * Initialize a new Valuable with the value and currency.
	 * 
	 * @param value
	 *            is the value of Valuable. currency is the currency of
	 *            Valuable.
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * To check the value of a Valuable that is more, less or equal.
	 * 
	 * @param v
	 *            is the Valuable which we want to compare.
	 * @return positive if more, negative if less, zero if equal.
	 */
	public int compareTo(Valuable v) {
		if (v == null)
			return -1;

		return (int) (this.getValue() - v.getValue());
	}

	/**
	 * To check that object is equal or not.
	 * 
	 * @param obj
	 *            is the object which we want to check.
	 * @return true if the Value and Currency is equal. Otherwise false.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj.getClass() != this.getClass())
			return false;

		Valuable v = (Valuable) obj;

		if (this.getValue() == v.getValue() && this.getCurrency().equals(v.getCurrency()))
			return true;

		return false;
	}

	/**
	 * Get the value of the Valuable.
	 * 
	 * @return the value of the Valuable.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of the Valuable.
	 * 
	 * @return the currency of the Valuable.
	 */
	public String getCurrency() {
		return this.currency;
	}

}