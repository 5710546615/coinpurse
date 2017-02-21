package coinpurse;

/**
 * Interface for objects having a monetary value and currency.
 * 
 * @author Visurt Anuttivong
 * @version 571054661
 * 
 */

public interface Valuable {

	/**
	 * Get the monetary value of this object, in its own currency.
	 * 
	 * @return the value of this object.
	 */
	public double getValue();

	/**
	 * Get the monetary currency of this object.
	 * 
	 * @return the currency of this object.
	 */
	public String getCurrency();

	/**
	 * Get the monetary description of this object.
	 * 
	 * @return the description of this object.
	 */
	public String toString();

	/**
	 * Get the compare of monetary object and this object.
	 * 
	 * @param obj
	 *            is the object which we want to compare.
	 * @return true if the value and Currency of this object is equal. Otherwise
	 *         false.
	 */
	public boolean equals(Object obj);
}