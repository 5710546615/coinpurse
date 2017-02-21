package coinpurse;

/**
 * Banknote represents money with a fixed value, currency and serial number.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 * 
 */

public class BankNote implements Valuable {

	/** counter of serial number. */
	private static long nextSerialNumber = 1000000;
	/** value of banknote. */
	private double value;
	/** The currency, default set to "Baht". */
	private String currency = "Baht";
	/** serial number of banknote. */
	private long serialNumber;

	/**
	 * Initialize a new Banknote with the value.
	 * 
	 * @param value
	 *            is the value of banknote.
	 */
	public BankNote(double value) {
		this.value = value;
		this.serialNumber = nextSerialNumber++;
	}

	/**
	 * Initialize a new Banknote with the value and currency.
	 * 
	 * @param value
	 *            is the value of Banknote. Curr is the currency of Banknote,
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}

	/**
	 * Get the value of the Banknote.
	 * 
	 * @return the value of the Banknote.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of the Banknote.
	 * 
	 * @return the currency of the Banknote.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Get the serial number of the Banknote.
	 * 
	 * @return the serial number of the Banknote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * To check that Banknote is equal or not.
	 * 
	 * @param obj
	 *            is the object which we want to check.
	 * @return true if the value and Currency of Banknote is equal. Otherwise
	 *         false.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj.getClass() != this.getClass())
			return false;

		BankNote banknote = (BankNote) obj;

		if (this.getValue() == banknote.getValue() && this.getCurrency().equals(banknote.getCurrency()))
			return true;

		return false;
	}

	/**
	 * To get the information of the Banknote.
	 * 
	 * @return a String describing the Banknote.
	 */
	public String toString() {
		return (int) this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}
}