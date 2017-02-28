package coinpurse;

/**
 * ThaiMoneyFactory is the subclass of MoneyFactory. Factory creates money using
 * the local currency.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 */

public class ThaiMoneyFactory extends MoneyFactory {

	/** counter of serial number. */
	private static long nextSerialNumber = 1000000;

	/**
	 * Create a new Money via Thai currency. If can't, throw
	 * IllegalArgumentException
	 * 
	 * @param value
	 *            is the value of Valuable.
	 */
	public Valuable createMoney(double value) {
		if (value == 1 || value == 5 || value == 10)
			return new Coin(value, "Baht");

		if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			BankNote temp = new BankNote(value, "Baht");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		throw new IllegalArgumentException();
	}

}