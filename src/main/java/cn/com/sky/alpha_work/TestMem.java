package cn.com.sky.alpha_work;

public class TestMem {

	public static final String MEMCACHED_SLASH = ":";

	public static void main(String args[]) {
		String str = getMemcachedKey(TestMem.class, "pid:" + 10 + ",day:" + 20131123);
		System.out.println(str);
	}

	public static String getMemcachedKey(Class clasz, String... args) {
		StringBuilder builder = new StringBuilder();
		builder.append(clasz.getName());
		for (String key : args) {
			builder.append(MEMCACHED_SLASH);
			builder.append(key);
		}
		return builder.toString();
	}

}
