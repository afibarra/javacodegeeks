package com.javacodegeeks.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JavaNetURLExample {
	public static void main(String[] args) {
		try {
			// Generate absolute URL
			// Base URL = www.gnu.org
			URL url1 = new URL("http://www.gnu.org");
			System.out.println("URL1: " + url1.toString());

			// Generate URL for pages with a common base
			URL url2 = new URL(url1, "licenses/gpl.txt");
			System.out.println("URL2: " + url2.toString());

			// Generate URLs from different pieces of data
			URL url3 = new URL("http", "www.gnu.org", "/licenses/gpl.txt");
			System.out.println("URL3: " + url3.toString());	
			
			URL url4 = new URL("http", "www.gnu.org", 80, "/licenses/gpl.txt");
			System.out.println("URL4: " + url4.toString() + "\n");

			// Open URL stream as an input stream and print contents to command line
			try (BufferedReader in = new BufferedReader(new InputStreamReader(url4.openStream()))) {
				String inputLine;

				// Read the "gpl.txt" text file from its URL representation
				System.out.println("/***** File content (URL4) *****/\n");
				while((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace(System.err);
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace(System.err);
		}
	}
}
