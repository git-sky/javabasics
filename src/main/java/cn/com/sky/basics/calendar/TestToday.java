package cn.com.sky.basics.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 
 * 【强制】SimpleDateFormat 是线程不安全的类，一般不要定义为static变量，如果定义为static，必须加锁，或者使用DateUtils工具类。
 *  正例：注意线程安全，使用DateUtils。亦推荐如下处理：
 *   private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
 *    @Override 
 *    protected DateFormat initialValue() {
 *     return new SimpleDateFormat("yyyy-MM-dd"); 
 *    } 
 *   }; 
 *   
 *   说明：如果是JDK8的应用，可以使用instant代替Date，Localdatetime代替Calendar，
 *   Datetimeformatter代替Simpledateformatter，
 *   官方给出的解释：simple beautiful strong immutable thread-safe。
 * 
 * </pre>
 */
public class TestToday {

	public static void main(String[] args) {
		System.out.println(getToday("yyyy-MM-dd"));
	}

	public static String getToday(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}

}
