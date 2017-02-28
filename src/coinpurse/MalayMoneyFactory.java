package coinpurse;

/**
 * MalayMoneyFactory is the subclass of MoneyFactory. Factory creates money
 * using the local currency.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 */

public class MalayMoneyFactory extends MoneyFactory {

	/** counter of serial number. */
	private static long nextSerialNumber = 1000000;

	/**
	 * Create a new Money via Malay currency. If can't, throw
	 * IllegalArgumentException
	 * 
	 * @param value
	 *            is the value of Valuable.
	 */
	public Valuable createMoney(double value) {
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50)
			return new Coin(value * 100, "Sen");

		if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) {
			BankNote temp = new BankNote(value, "Ringgit");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		throw new IllegalArgumentException();
	}

}