package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CoinUtil is for valuable items purse.
 * 
 * @author Visurt Anuttivong
 * @version 571054661
 */

public class CoinUtil {

	/**
	 * Return a List of valuable items that contains the valuable items from
	 * vallist (the parameter) that have same currency as the currency
	 * parameter.
	 * 
	 * @return List of valuable items that contains the same currency.
	 * @param vallist
	 *            is the List of valuable items which we want to look in and
	 *            currency is the currency of valuable items in vallist that we
	 *            want to classify.
	 * 
	 */
	static List<Valuable> filterByCurrency(List<Valuable> vallist, String currency) {
		List<Valuable> templist = new ArrayList<Valuable>();
		for (int i = 0; i < vallist.size(); i++) {
			if (vallist.get(i).getCurrency().equals(currency)) {
				templist.add(vallist.get(i));
			}
		}

		return templist;
	}

	/**
	 * Sort the valuable items by currency.
	 * 
	 * @param vallist
	 *            is the list of valuable items that we want to sort by
	 *            currency.
	 * 
	 */
	static void sortByCurrency(List<Valuable> vallist) {
		Collections.sort(vallist, (a, b) -> a.getCurrency().compareTo(b.getCurrency()));
	}

	/**
	 * Sum the value of valuable items for each currency. Print the sum for each
	 * currency on a separate line.
	 * 
	 * @param valuable
	 *            is the list of valuable items that we want to sum by currency.
	 * 
	 */
	static void sumByCurrency(List<Valuable> valuable) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < valuable.size(); i++) {
			int value = map.getOrDefault(valuable.get(i).getCurrency(), 0) + (int) valuable.get(i).getValue();
			map.put(valuable.get(i).getCurrency(), value);
		}

		for (String word : map.keySet()) {
			int count = map.get(word);
			System.out.printf("Sum-%s = %d\n", word, count);
		}
	}
}
