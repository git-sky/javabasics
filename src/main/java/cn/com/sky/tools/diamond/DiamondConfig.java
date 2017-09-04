package cn.com.sky.tools.diamond;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taobao.diamond.manager.DiamondManager;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.diamond.manager.impl.DefaultDiamondManager;

public class DiamondConfig {
	private static final String CONFIG_PREFIX = "cn.com.gome.rebate.config";
	private static String appName;
	private static String groupName;
	private static String encode = "utf-8";
	private static final Logger log = LoggerFactory.getLogger(DiamondConfig.class);
	private static PropertiesConfiguration prop;
	private static ReentrantLock lock = new ReentrantLock();
	private static long timeout = 10000L;

	public static void init() {
		appName = CONFIG_PREFIX + "." + appName;
		load();
	}

	public static void load() {
		// if (StringUtil.isTrimEmpty(appName) || StringUtil.isTrimEmpty(groupName)) {
		// throw new RuntimeException("appName or groupName can't is null or empty");
		// }
		DiamondManager manager = new DefaultDiamondManager(groupName, appName, new ManagerListener() {
			public Executor getExecutor() {
				return null;
			}

			public void receiveConfigInfo(String configInfo) {
				log.info("config reloaded......");
				addData(configInfo);
			}
		});
		addData(manager.getAvailableConfigureInfomation(timeout));
	}

	private static void addData(String config) {
		//
		// if (StringUtil.isTrimEmpty(config)) {
		// return;
		// }

		if (log.isDebugEnabled()) {
			log.debug(config);
		}

		InputStream in = null;
		try {
			in = new ByteArrayInputStream(config.getBytes(encode));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			lock.lock();

			PropertiesConfiguration temp = new PropertiesConfiguration();
			temp.setEncoding(encode);
			temp.load(in);
			prop = temp;
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
			}
			lock.unlock();
		}
	}

	public static String getProperty(String key, String defaultValue) {
		return prop.getString(key, defaultValue);
	}

	public static String getString(String key) {
		return prop.getString(key);
	}

	public static Integer getInt(String key, int defaultVal) {
		return Integer.valueOf(prop.getInt(key, defaultVal));
	}

	public static Double getDouble(String key, Double defaultVal) {
		return prop.getDouble(key, defaultVal);
	}

	public static boolean getBoolean(String key, boolean defaultVal) {
		return prop.getBoolean(key, defaultVal);
	}

	public static List<Object> getList(String key) {
		return prop.getList(key);
	}

	public static Object getProperty(String name) {
		return prop.getProperty(name);
	}

	public static void setAppName(String appName) {
		DiamondConfig.appName = appName;
	}

	public static void setGroupName(String groupName) {
		DiamondConfig.groupName = groupName;
	}

	public static void setEncode(String encode) {
		DiamondConfig.encode = encode;
	}
}