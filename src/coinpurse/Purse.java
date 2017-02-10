package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 * 
 */

public class Purse {

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** Money is a list for collection of coins. */
	private List<Coin> money;

	/**
	 * Initialize a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 *
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<Coin>(capacity);
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;

		for (int i = 0; i < money.size(); i++)
			sum += money.get(i).getValue();

		return sum;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (this.count() == this.capacity)
			return true;

		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		if (isFull())
			return false;

		if (coin.getValue() > 0) {
			money.add(coin);
			return true;
		}

		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {

		Collections.sort(money);
		Collections.reverse(money);

		List<Coin> templist = new ArrayList<Coin>();

		for (int i = 0; i < money.size(); i++) {

			amount -= money.get(i).getValue();

			if (amount == 0) {
				templist.add(money.get(i));
				break;
			} else if (amount > 0) {
				templist.add(money.get(i));
			} else {
				amount += money.get(i).getValue();
			}
		}

		if (amount == 0) {
			for (int i = 0; i < templist.size(); i++)
				money.remove(templist.get(i));

			return templist.toArray(new Coin[templist.size()]);
		}
		return null;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 * 
	 * @return a String describing the purse contents.
	 */
	public String toString() {
		return count() + " coins with value " + getBalance();
	}

}
