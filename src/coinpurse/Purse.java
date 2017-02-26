package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A item purse contains valuable items. You can insert valuable items, withdraw
 * money, check the balance, and check if the purse is full. When you withdraw
 * money, the item purse decides which valuable items to remove.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 */

public class Purse {

	/**
	 * Capacity is maximum number of valuable items the purse can hold. Capacity
	 * is set when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** Money is a list for collection of valuable items. */
	private List<Valuable> money;

	/**
	 * Initialize a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of valuable items you can put in purse.
	 *
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<Valuable>(capacity);
	}

	/**
	 * Count and return the number of valuable items in the purse. This is the
	 * number of valuable items, not their value.
	 * 
	 * @return the number of valuable items in the purse
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
	 * Return the capacity of the valuable items purse.
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
	 * Insert valuable items into the purse. The valuable items is only inserted
	 * if the purse has space for it and the valuable items has positive value.
	 * No worthless valuable items!
	 * 
	 * @param valuable
	 *            is a Valuable object to insert into purse
	 * @return true if valuable items inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (isFull())
			return false;

		if (valuable.getValue() > 0) {
			money.add(valuable);
			return true;
		}

		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of valuable items
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of valuable items objects for money withdrawn, or null if
	 *         cannot withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {

		Comparator<Valuable> comp = (Valuable a, Valuable b) -> {
			return b.getCurrency().compareTo(a.getCurrency());
		};

		Collections.sort(money, comp);
		Collections.reverse(money);

		List<Valuable> templist = new ArrayList<Valuable>();

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

			return templist.toArray(new Valuable[templist.size()]);
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
		return count() + " items with value " + getBalance();
	}

}
