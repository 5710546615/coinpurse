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
		if (value == 0.05)
			return new Coin(5, "Sen");

		if (value == 0.10)
			return new Coin(10, "Sen");

		if (value == 0.20)
			return new Coin(20, "Sen");

		if (value == 0.50)
			return new Coin(50, "Sen");

		if (value == 1) {
			BankNote temp = new BankNote(1, "Ringgit");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		if (value == 2) {
			BankNote temp = new BankNote(2, "Ringgit");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		if (value == 5) {
			BankNote temp = new BankNote(5, "Ringgit");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		if (value == 10) {
			BankNote temp = new BankNote(10, "Ringgit");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		if (value == 20) {
			BankNote temp = new BankNote(20, "Ringgit");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		if (value == 50) {
			BankNote temp = new BankNote(50, "Ringgit");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		if (value == 100) {
			BankNote temp = new BankNote(100, "Ringgit");
			temp.setSerial(nextSerialNumber++);
			return temp;
		}

		throw new IllegalArgumentException();
	}

}