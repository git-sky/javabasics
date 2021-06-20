package cn.com.todo.test_property;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

/*
 * ��ȡ�����ļ�
 */

public class TestProperty {

	// ����key��ȡvalue
	public static String readValue(String filePath, String key) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			String value = props.getProperty(key);
			System.out.println(key + ": " + value);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ��ȡproperties��ȫ����Ϣ
	@SuppressWarnings("unchecked")
	public static void readProperties(String filePath) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value = props.getProperty(key);
				System.out.println(key + ": " + value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// д��properties��Ϣ
	public static void writeProperties(String filePath, String parameterName,
			String parameterValue) {
		Properties prop = new Properties();
		try {
			InputStream fis = new FileInputStream(filePath);

			prop.load(fis);

			OutputStream fos = new FileOutputStream(filePath);

			prop.setProperty(parameterName, parameterValue);

			prop.store(fos, "Update '" + parameterName + "' value");

		} catch (IOException e) {
			System.err.println("Visit " + filePath + " for updating "
					+ parameterName + " value error");
		}
	}

	public static final String FILE_NAME = "f:\\info.properties";

	public static void main(String[] args) {

		readValue(FILE_NAME, "url");

		System.out.println("readValue ............");

		writeProperties(FILE_NAME, "age", "21");

		System.out.println("writeProperties ............");

		readProperties(FILE_NAME);

		System.out.println("readProperties ..........");
	}
}
