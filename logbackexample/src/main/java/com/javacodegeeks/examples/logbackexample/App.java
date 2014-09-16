package com.javacodegeeks.examples.logbackexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javacodegeeks.examples.logbackexample.beans.MarcoPoloBean;

public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		MarcoPoloBean poloBean = new MarcoPoloBean();
		poloBean.sayMarco();
		
		logger.debug("I am Polo");
	}
}
