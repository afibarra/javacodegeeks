package com.javacodegeeks.examples.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class App {
	private static final Logger logger = Logger.getLogger("App");

	public static void main(String[] args) {

		// ResourceBundle class will use SystemMessages.properties file
		ResourceBundle resourceBundle = ResourceBundle.getBundle(
				"SystemMessages", Locale.getDefault());
		logger.info(resourceBundle.getString("first_name") + ": Armando");
		logger.info(resourceBundle.getString("last_name") + ": Flores");

		// ResourceBundle class will use SystemMessages_es.properties file
		resourceBundle = ResourceBundle.getBundle("SystemMessages",
				Locale.forLanguageTag("es"));
		logger.info(resourceBundle.getString("first_name") + ": Armando");
		logger.info(resourceBundle.getString("last_name") + ": Flores");

		// ResourceBundle class will use SystemMessages_fr.properties file
		resourceBundle = ResourceBundle.getBundle("SystemMessages",
				Locale.FRANCE);
		logger.info(resourceBundle.getString("first_name") + ": Armando");
		logger.info(resourceBundle.getString("last_name") + ": Flores");
	}
}
