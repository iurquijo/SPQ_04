package com.moviemanager.app;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class Log4JPropertiesTest {
		private static final Logger log4j = LogManager.getLogger(Log4JPropertiesTest.class.getName()); //Log4JPropertiesTest??????

		public static void main(String[] args) {
			log4j.debug("This is a debug message");
			myMethod();
			log4j.info("This is an info message");
			log4j.trace("This is a trace message."); 
			log4j.error("This is an error message");
		}

		private static void myMethod() {
			try {
				throw new Exception("My Exception");
			} catch (Exception e) {
				log4j.error("This is an exception", e);
			}
		}
}

//http://syncor.blogspot.com.es/2013/09/getting-started-with-log4j-2-in-eclipse.html