package coinpurse;

/**
 * MoneyFactory is the parent class for ThaiMoneyFactory and MalayMoneyFactory.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 */

public abstract class MoneyFactory {

	/* factory which we want to use. */
	private static MoneyFactory factory;

	/**
	 * Initialize a new factory. Default set to ThaiMoneyFactory.
	 */
	public static MoneyFactory getInstance() {
		factory = new ThaiMoneyFactory();
		return factory;
	}

	/**
	 * Create a new money with numberic value. If can't, throw
	 * IllegalArgumentException
	 * 
	 * @param value
	 *            is the value of money.
	 * @return Valuable is a new money.
	 */
	public Valuable createMoney(double value) {
		try {
			return createMoney(value);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Create a new money with non-numberic value. If can't, throw
	 * IllegalArgumentException
	 * 
	 * @param value
	 *            is the value of money.
	 * @return Valuable is a new money.
	 */
	public Valuable createMoney(String value) {
		try {
			double d = Double.parseDouble(value);
			return createMoney(d);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Set the type of MoneyFactory.
	 * 
	 * @param factory
	 *            is the factory which we want to use.
	 * @return MoneyFactory is the new factory.
	 */
	public static MoneyFactory setMoneyFactory(MoneyFactory factory) {
		return factory;
	}

}