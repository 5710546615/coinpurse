package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CoinUtil is for coin purse.
 * 
 * @author Visurt Anuttivong
 * @version 571054661
 * 
 */

public class CoinUtil {

	/**
	 * Return a List of Coins that contains only the coins from coinlist (the
	 * parameter) that have same currency as the currency parameter.
	 * 
	 * @return List of Coin that contains the same currency.
	 * @param coinList
	 *            is the List of Coin which we want to look in and currency is
	 *            the currency of Coin in coinlist that we want to classify.
	 * 
	 */
	static List<Coin> filterByCurrency(List<Coin> coinlist, String currency) {
		List<Coin> templist = new ArrayList<Coin>();
		for (int i = 0; i < coinlist.size(); i++) {
			if (coinlist.get(i).getCurrency().equals(currency)) {
				templist.add(coinlist.get(i));
			}
		}
		Collections.sort(templist);
		return templist;
	}

	/**
	 * Sort the coins by currency.
	 * 
	 * @param coins
	 *            is the list of coins that we want to sort by currency.
	 * 
	 */
	static void sortByCurrency(List<Coin> coins) {
		Collections.sort(coins, (coin1, coin2) -> coin1.getCurrency().compareTo(coin2.getCurrency()));
	}

	/**
	 * Sum the value of coins for each currency that appears in the coins list.
	 * Print the sum for each currency on a separate line.
	 * 
	 * @param coins
	 *            is the list of coins that we want to sum by currency.
	 * 
	 */
	static void sumByCurrency(List<Coin> coins) {
		sortByCurrency(coins);
		boolean next = false;
		List<Coin> templist = new ArrayList<Coin>();

		for (int i = 0; i < coins.size(); i++) {
			if (i == 0 || next) {
				templist.add(coins.get(i));
				next = false;
			} else if (templist.get(0).getCurrency().equals(coins.get(i).getCurrency())) {
				templist.add(coins.get(i));
			} else {
				System.out.println("Sum-" + templist.get(0).getCurrency() + " = " + sum(templist) + "-"
						+ templist.get(0).getCurrency());
				templist.removeAll(templist);
				next = true;
				i--;
			}

			if (i == coins.size() - 1) {
				System.out.println("Sum-" + templist.get(0).getCurrency() + " = " + sum(templist) + "-"
						+ templist.get(0).getCurrency());
			}
		}
	}

	/**
	 * @param coins
	 *            is the list of coins that we want to sum.
	 * @return the value of summing all elements in list of coins.
	 * 
	 */
	public static double sum(List<Coin> coins) {
		double sum = 0;
		for (int i = 0; i < coins.size(); i++)
			sum += coins.get(i).getValue();

		return sum;
	}
}
