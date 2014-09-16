package com.javacodegeeks.examples.log4jappenders.foo;

import org.apache.log4j.Logger;

public class FooBean {
	private static final Logger logger = Logger.getLogger(FooBean.class);
	
	public void sayHello() {
		logger.debug("Hello there from FooBean class!");
		
		logger.info("Hello there from FooBean class!");
	}
}
