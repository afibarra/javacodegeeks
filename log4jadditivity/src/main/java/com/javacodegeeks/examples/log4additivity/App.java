package com.javacodegeeks.examples.log4additivity;

import org.apache.log4j.Logger;

import com.javacodegeeks.examples.log4jadditivity.bar.BarBean;
import com.javacodegeeks.examples.log4jadditivity.foo.FooBean;

public class App {
	private static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		FooBean fooBean = new FooBean();
		BarBean barBean = new BarBean();

		logger.debug("Hello there from App class!");

		fooBean.sayHello();
		barBean.sayHello();
	}
}
