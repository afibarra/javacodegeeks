package com.javacodegeeks.examples.logbackexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicConfApp {
	final static Logger logger = LoggerFactory.getLogger(BasicConfApp.class);
	
	public static void main(String[] args) {
		logger.info("Msg #1");
		logger.warn("Msg #2");
		logger.error("Msg #3");
		logger.debug("Msg #4");
	}
}
