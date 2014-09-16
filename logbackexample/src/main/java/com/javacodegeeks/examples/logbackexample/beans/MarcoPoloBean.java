package com.javacodegeeks.examples.logbackexample.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarcoPoloBean {
	private static final Logger logger = LoggerFactory.getLogger(MarcoPoloBean.class);
	
	public void sayMarco() {
		String msg = "I'm Marco";
		
		logger.info("Hello there. I am {}", msg);
		
		logger.debug("Debugging message");
	}
}
