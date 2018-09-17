//package cn.com.sky.tools.diamond;
//
//import org.apache.commons.configuration.ConfigurationException;
//
//import java.io.IOException;
//import java.util.List;
//
//public class ReloadableConfig {
//
//	private final static String APP_GROUP = "DEFAULT_GROUP";
//
//	private ReloadableConfig() {
//	}
//
//	static {
//		try {
//			init();
//		} catch (Exception e) {
//			throw new ExceptionInInitializerError(e);
//		}
//	}
//
//	public synchronized static void init() throws IOException, ConfigurationException {
//		try {
//			String APP_NAME = "gome_rebate_config";
//			if (null != System.getProperty("appName")) {
//				APP_NAME = System.getProperty("appName");
//			}
//			DiamondConfig.setAppName(APP_NAME);
//			DiamondConfig.setGroupName(APP_GROUP);
//			DiamondConfig.init();
//
//		} catch (Exception e) {
//			throw new ExceptionInInitializerError(e);
//		}
//	}
//
//	public static List<Object> getList(String key) {
//		return DiamondConfig.getList(key);
//	}
//
//	public static Object getProperty(String name) {
//		return DiamondConfig.getProperty(name);
//	}
//
//	public static String getString(String name) {
//		return DiamondConfig.getString(name);
//	}
//
//	public static String getString(String name, String def) {
//		return DiamondConfig.getProperty(name, def);
//	}
//
//	public static int getInt(String name, int def) {
//		return DiamondConfig.getInt(name, def);
//	}
//
//	public static boolean getBoolean(String name, boolean def) {
//		return DiamondConfig.getBoolean(name, def);
//	}
//}
