package com.javacodegeeks.examples;

import java.util.Enumeration;
import java.util.Hashtable;

public class JavaHashtableExample {
	public static void main(String[] args) {
		// Declare and instantiate the Hashtable.
		Hashtable<String, Double> balance = new Hashtable<>();

		Enumeration<String> names;
		String name;
		double bal;

		// Insert some keys and values.
		balance.put("John Doe", 3434.34);
		balance.put("Tom Smith", 123.22);
		balance.put("Jane Baker", 1378.00);
		balance.put("Tod Hall", 99.22);
		balance.put("Ralph Smith", -19.08);

		// Show all balances in Hashtable.
		names = balance.keys();

		// Enumerate through the keys of the Hashtable.
		while (names.hasMoreElements()) {
			name = names.nextElement();
			System.out.printf("%s: %.2f\n", name, balance.get(name));
		}

		System.out.println();

		// Deposit 1,000 into John Doe's account.
		bal = balance.get("John Doe");
		balance.put("John Doe", bal + 1000);

		System.out.printf("John Doe's new balance: %.2f",
				balance.get("John Doe"));
	}
}
