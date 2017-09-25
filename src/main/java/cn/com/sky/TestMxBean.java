package cn.com.sky;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;

public class TestMxBean {

	public static void main(String[] args) {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		double load;
		try {
			Method method = OperatingSystemMXBean.class.getMethod("getSystemLoadAverage", new Class<?>[0]);
			load = (Double) method.invoke(operatingSystemMXBean, new Object[0]);
			System.out.println("---");
		} catch (Throwable e) {
			e.printStackTrace();
			load = -1;
		}
		int cpu = operatingSystemMXBean.getAvailableProcessors();
		System.out.println("Load: " + load + " / CPU: " + cpu);
	}
}
