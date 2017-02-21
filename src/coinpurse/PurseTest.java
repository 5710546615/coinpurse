package coinpurse;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Purse. This is a JUnit test. If you don't know how to use this, just
 * ignore it.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 */
public class PurseTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;

	/**
	 * Sets up the test fixture.
	 *
	 * Called before every test case method.
	 */
	@Before
	public void setUp() {

	}

	/**
	 * Tears down the test fixture.
	 *
	 * Called after every test case method.
	 */
	@After
	public void tearDown() {

	}

	@Test
	public void testConstructor() {
		Purse purse = new Purse(3);
		assertEquals(3, purse.getCapacity());
		assertEquals(false, purse.isFull());
		assertEquals(0, purse.count());
	}

	@Test
	public void testInsert() {
		Purse purse = new Purse(3);
		Coin coin1 = new Coin(5);
		Coin coin2 = new Coin(10);
		Coin fakeCoin = new Coin(0);
		Coin oneBaht = new Coin(1);
		assertTrue(purse.insert(coin1));
		assertFalse(purse.isFull());
		assertFalse(purse.insert(fakeCoin));
		assertTrue(purse.insert(oneBaht));
		assertTrue(purse.insert(coin2));
		assertEquals(3, purse.count());
	}

	@Test
	public void testIsFull() { // borderline case (capacity 1)
		Purse purse = new Purse(1);
		assertFalse(purse.isFull());
		purse.insert(new Coin(1));
		assertTrue(purse.isFull());
		// harder test
		int capacity = 4;
		purse = new Purse(capacity);
		for (int k = 1; k <= capacity; k++) {
			assertFalse(purse.isFull());
			purse.insert(new Coin(k));
		}
		// full now
		assertTrue(purse.isFull());
		assertFalse(purse.insert(new Coin(5)));
	}

	/**
	 * Should be able to insert same coin many times, since spec doesn't say
	 * anything about this.
	 */
	@Test
	public void testInsertSameCoin() {
		Purse purse = new Purse(3);
		Coin coin = new Coin(1000000);
		assertTrue(purse.insert(coin));
		assertTrue(purse.insert(coin)); // should be allowed
	}

	@Test
	public void testEasyWithdraw() {
		Purse purse = new Purse(10);
		int[] values = { 1, 10, 1000000 };
		for (int value : values) {
			Coin coin = new Coin(value);
			assertTrue(purse.insert(coin));
			assertEquals(value, purse.getBalance(), TOL);
			Valuable[] result = purse.withdraw(value);
			assertTrue(result != null);
			assertEquals(1, result.length);
			assertSame(coin, result[0]);
			assertEquals(0, purse.getBalance(), TOL);
		}
	}

	@Test
	public void testMultiWithdraw() {
		Purse purse = new Purse(10);
		int value = 1;
		int amount1 = 0;
		int amount2 = 0;
		for (int k = 1; k < 10; k = k + 2) {
			assertTrue(purse.insert(new Coin(value)));
			amount1 += value;
			value = 2 * value;
			assertTrue(purse.insert(new Coin(value)));
			amount2 += value;
			value = 2 * value;
		}
		assertEquals(amount1 + amount2, purse.getBalance(), TOL);
		assertEquals(10, purse.count());
		Valuable[] wd1 = purse.withdraw(amount1);
		assertEquals(amount1, sumValue(wd1), 0.00001);
		assertEquals(amount2, purse.getBalance(), TOL);
		Valuable[] wd2 = purse.withdraw(amount2);
		assertEquals(0, purse.getBalance(), TOL);
	}

	@Test
	public void testImpossibleWithdraw() {
		Purse purse = new Purse(10);
		assertNull(purse.withdraw(1));
		purse.insert(new Coin(20));
		assertNull(purse.withdraw(1));
		assertNull(purse.withdraw(19));
		assertNull(purse.withdraw(21));
		purse.insert(new Coin(20));
		assertNull(purse.withdraw(30));
	}

	@Test
	public void testInsertValuable() {
		Purse purse = new Purse(3);
		Valuable c10 = new Coin(10);
		Valuable bn50 = new BankNote(50);
		Valuable fakeCoin = new Coin(0);
		Valuable fakebn = new BankNote(0);
		Valuable bn100 = new BankNote(100);
		assertTrue(purse.insert(c10));
		assertFalse(purse.isFull());
		assertFalse(purse.insert(fakeCoin));
		assertFalse(purse.insert(fakebn));
		assertTrue(purse.insert(bn50));
		assertTrue(purse.insert(bn100));
		assertEquals(3, purse.count());
		assertTrue(purse.isFull());
	}

	@Test
	public void testWithdrawValuable() {
		Purse purse = new Purse(10);
		int[] values = { 1, 2, 5, 10, 20, 50 };
		for (int value : values) {
			Valuable v = new BankNote(value);
			assertTrue(purse.insert(v));
			assertEquals(value, purse.getBalance(), TOL);
			Valuable[] result = purse.withdraw(value);
			assertTrue(result != null);
			assertEquals(1, result.length);
			assertSame(v, result[0]);
			assertEquals(0, purse.getBalance(), TOL);
		}
	}

	@Test
	public void testGetBalanceValuable() {
		Purse purse = new Purse(3);
		Valuable c10 = new Coin(10);
		Valuable bn50 = new BankNote(50);
		Valuable bn100 = new BankNote(100);
		assertTrue(purse.insert(c10));
		assertTrue(purse.insert(bn50));
		assertTrue(purse.insert(bn100));
		assertEquals(160, purse.getBalance(), TOL);
		Valuable[] result = purse.withdraw(60);
		assertTrue(result != null);
		assertEquals(100, purse.getBalance(), TOL);
	}

	/**
	 * Some the value of some valuable items.
	 * 
	 * @param vals
	 *            array of Valuable.
	 * @return sum of values of the vals.
	 */
	private double sumValue(Valuable[] vals) {
		if (vals == null)
			return 0;
		double sum = 0;
		for (Valuable v : vals)
			if (v != null)
				sum += v.getValue();
		return sum;
	}
}
