package cn.com.sky.tools.logback.demo2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
	private static Logger log = LoggerFactory.getLogger(LogbackDemo.class);
	private static Logger logName = LoggerFactory.getLogger("warn_log");

	@Test
	public void testLog() {

		System.out.println("aaaaaaaaaaa");
		log.trace(getClass().getName() + "======trace");
		log.debug(getClass().getName() + "======debug");
		log.info(getClass().getName() + "======info");
		log.warn(getClass().getName() + "======warn");
		log.error(getClass().getName() + "======error");

//		logName.trace(getClass().getName() + "======trace===logName===");
//		logName.debug(getClass().getName() + "======debug===logName===");
//		logName.info(getClass().getName() + "======info===logName===");
//		logName.warn(getClass().getName() + "======warn===logName===");
//		logName.error(getClass().getName() + "======error===logName===");

	}
}