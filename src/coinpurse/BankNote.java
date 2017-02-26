package coinpurse;

/**
 * Banknote represents money with a fixed value, currency and serial number.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 * 
 */

public class BankNote extends AbstractValuable {

	/** serial number of banknote. */
	private long serialNumber;
	/** The currency, default set to "Baht". */
	private static String default_currency = "Baht";

	/**
	 * Initialize a new Banknote with the value.
	 * 
	 * @param value
	 *            is the value of Banknote.
	 */
	public BankNote(double value) {
		super(value, default_currency);
	}

	/**
	 * Initialize a new Banknote with the value and currency.
	 * 
	 * @param value
	 *            is the value of Banknote. currency is the currency of
	 *            Banknote.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
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
	 * Set the serial number of Banknote.
	 * 
	 * @param serialNumber
	 *            is the serial number which we want to set.
	 */
	public void setSerial(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * To get the information of the Banknote.
	 * 
	 * @return a String describing the Banknote.
	 */
	public String toString() {
		return (int) this.getValue() + "-" + this.getCurrency() + " note [" + this.serialNumber + "]";
	}
}