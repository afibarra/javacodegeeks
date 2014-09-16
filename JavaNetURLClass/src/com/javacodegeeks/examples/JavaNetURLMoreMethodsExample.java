package com.javacodegeeks.examples;

import java.io.IOException;
import java.net.URL;

public class JavaNetURLMoreMethodsExample {
	public static void main(String[] args) {
		try {
			// Creates a URL object from the String representation.
			URL url = new URL("http://www.gnu.org/licenses/gpl.txt");

			// Gets the authority part of this URL.
			System.out.println("URL Authority: " + url.getAuthority());

			// Gets the default port number of the protocol associated with this
			// URL.
			System.out.println("URL Default Port: " + url.getDefaultPort());

			// Gets the file name of this URL.
			System.out.println("URL File Name: " + url.getFile());

			// Gets the host name of this URL, if applicable.
			System.out.println("URL Host Name: " + url.getHost());

			// Gets the path part of this URL.
			System.out.println("URL Path: " + url.getPath());

			// Gets the protocol name of this URL.
			System.out.println("URL Protocal Name: " + url.getProtocol());
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
		}
	}
}
