package cn.com.sky.basics.test_runtime;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class TestSystem {

	public static void main(String[] args) {
		try {
			new TestSystem().index();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void index() throws Exception {
		Map<String, String> properties = new TreeMap<>();
		properties.put("Java", System.getProperty("java.runtime.name") + " " + System.getProperty("java.runtime.version"));
		properties.put("OS", System.getProperty("os.name") + " " + System.getProperty("os.version"));
		properties.put("CPU", System.getProperty("os.arch", "") + ", " + String.valueOf(Runtime.getRuntime().availableProcessors()) + " cores");
		properties.put("Locale", Locale.getDefault().toString() + "/" + System.getProperty("file.encoding"));
		properties.put(
				"Uptime",
				formatUptime(ManagementFactory.getRuntimeMXBean().getUptime()) + " From "
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z").format(new Date(ManagementFactory.getRuntimeMXBean().getStartTime())) + " To "
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z").format(new Date()));

		System.out.println(properties);

		for (Map.Entry<String, String> entry : properties.entrySet()) {
			System.out.println(entry.getKey() + " ---> " + entry.getValue());
		}

	}

	private static final long SECOND = 1000;

	private static final long MINUTE = 60 * SECOND;

	private static final long HOUR = 60 * MINUTE;

	private static final long DAY = 24 * HOUR;

	private String formatUptime(long uptime) {
		StringBuilder buf = new StringBuilder();
		if (uptime > DAY) {
			long days = (uptime - uptime % DAY) / DAY;
			buf.append(days);
			buf.append(" Days");
			uptime = uptime % DAY;
		}
		if (uptime > HOUR) {
			long hours = (uptime - uptime % HOUR) / HOUR;
			if (buf.length() > 0) {
				buf.append(", ");
			}
			buf.append(hours);
			buf.append(" Hours");
			uptime = uptime % HOUR;
		}
		if (uptime > MINUTE) {
			long minutes = (uptime - uptime % MINUTE) / MINUTE;
			if (buf.length() > 0) {
				buf.append(", ");
			}
			buf.append(minutes);
			buf.append(" Minutes");
			uptime = uptime % MINUTE;
		}
		if (uptime > SECOND) {
			long seconds = (uptime - uptime % SECOND) / SECOND;
			if (buf.length() > 0) {
				buf.append(", ");
			}
			buf.append(seconds);
			buf.append(" Seconds");
			uptime = uptime % SECOND;
		}
		if (uptime > 0) {
			if (buf.length() > 0) {
				buf.append(", ");
			}
			buf.append(uptime);
			buf.append(" Milliseconds");
		}
		return buf.toString();
	}

}
