package cn.com.sky.tools.apache_commons;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

public class TestStopWatch {

	@Test
	public void test() {

		StopWatch swatch = new StopWatch();

		swatch.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		swatch.stop();

		System.out.println(swatch.getTime());

		swatch.reset();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		swatch.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		swatch.stop();
		System.out.println(swatch.getTime());
	}

	@Test
	public void test2() {
		StopWatch swatch = new StopWatch();

		swatch.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(swatch.getTime());

		swatch.suspend();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		swatch.resume();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		swatch.stop();
		System.out.println(swatch.getTime());
	}

}
