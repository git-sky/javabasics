package cn.com.sky.collections;

import java.util.Enumeration;
import java.util.Properties;

/**
 * System.getProperty()方法。
 * 
 */
public class TestSystemProperty {
	public static void main(String[] args) {
		Properties p = System.getProperties();
		Enumeration enu = p.keys();
		String property = "";
		String constantName = "";
		String note = "";
		while (enu.hasMoreElements()) {
			property = (String) enu.nextElement();
			note = "\t//" + System.getProperty(property) + "\n";
			constantName = "\tpublic final static String " + property.replace(".", "_").toUpperCase() + " = " + property;
			System.out.println(note + constantName);
		}
		System.out.println("}");
	}
}