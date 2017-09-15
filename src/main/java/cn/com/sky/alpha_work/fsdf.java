package cn.com.sky.alpha_work;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class fsdf {

	public static void main(String[] args) {
		// Float f = Float.MIN_VALUE;
		// System.out.println(f);
		//
		// System.out.println(Float.valueOf(f.toString()) > 0);
		// System.out.println(Double.valueOf(f.toString()) > 0);
		//
		// System.out.println(Float.valueOf(f.toString()) == 0);
		// System.out.println(Double.valueOf(f.toString()) == 0);
		// System.out.println(f == 0);
		//
		// System.out.print(UUID.randomUUID().toString());

		System.out.println(3 / 2);
		System.out.println(3.2 / 2);

		System.out.println(3 % 2);
		System.out.println(3.2 % 2);
		new fsdf().say();
	}

	public void say() {
		System.out.println(getClass());
		System.out.println(getClass().getName());
	}

}
