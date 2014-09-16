package com.javacodegeeks.examples;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class JavaHashtableIterator {
	public static void main(String[] args) {
		// Declare and instantiate the Hashtable.
		Hashtable<String, Double> balance = new Hashtable<>();

		String name;
		double bal;

		// Insert some keys and values.
		balance.put("John Doe", 3434.34);
		balance.put("Tom Smith", 123.22);
		balance.put("Jane Baker", 1378.00);
		balance.put("Tod Hall", 99.22);
		balance.put("Ralph Smith", -19.08);

		// Show all balances in hashtable.
		// First, get a set view of the keys.
		Set<String> keys = balance.keySet();

		// Get an Iterator.
		Iterator<String> iterator = keys.iterator();

		// Iterate.
		while (iterator.hasNext()) {
			name = iterator.next();
			System.out.printf("%s: %.2f\n", name, balance.get(name));
		}
	}
}
