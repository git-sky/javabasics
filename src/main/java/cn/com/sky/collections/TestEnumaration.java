package cn.com.sky.collections;

import java.util.Enumeration;

/**
 * Enumeration 与 Iterator 功能类似, 属于遗留接口。
 */
public class TestEnumaration {

	public static void main(String[] args) {

		Enumeration<Object> e = new Enumeration<Object>() {

			@Override
			public boolean hasMoreElements() {
				return false;
			}

			@Override
			public Object nextElement() {
				return null;
			}
		};

		e.hasMoreElements();

	}
}
