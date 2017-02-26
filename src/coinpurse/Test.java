package coinpurse;

/**
 * Test Class for MoneyFactory.
 * 
 * @author Visurt Anuttivong
 * @version 571054661
 */

public class Test {

	/**
	 * Start the test cases.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		MoneyFactory.getInstance();
		MoneyFactory factory = MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		Valuable m005 = factory.createMoney(0.05);
		System.out.println(m005.toString());
		Valuable m05 = factory.createMoney(0.5);
		System.out.println(m05.toString());
		Valuable m1 = factory.createMoney(1);
		System.out.println(m1.toString());
		Valuable m100 = factory.createMoney(100);
		System.out.println(m100.toString());

		System.out.println("-----------------");

		MoneyFactory factory2 = MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		Valuable n1 = factory2.createMoney(1);
		System.out.println(n1.toString());
		Valuable n5 = factory2.createMoney(5);
		System.out.println(n5.toString());
		Valuable n100 = factory2.createMoney(100);
		System.out.println(n100.toString());
		Valuable n500 = factory2.createMoney(500);
		System.out.println(n500.toString());
	}
}