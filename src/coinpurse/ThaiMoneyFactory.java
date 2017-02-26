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
		if (value == 1)
			return new Coin(1, "Baht");

		if (value == 5)
			return new Coin(5, "Baht");

		if (value == 10)
			return new Coin(10, "Baht");

		if (value == 20) {
			BankNote temp = new BankNote(20, "Baht");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}
		if (value == 50) {
			BankNote temp = new BankNote(50, "Baht");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		if (value == 100) {
			BankNote temp = new BankNote(100, "Baht");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		if (value == 500) {
			BankNote temp = new BankNote(500, "Baht");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		if (value == 1000) {
			BankNote temp = new BankNote(1000, "Baht");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		throw new IllegalArgumentException();
	}

}