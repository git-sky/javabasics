package cn.com.a_temp;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatUtils {

    private static final ThreadLocal threadLocal = new ThreadLocal();

    public static DateFormat getDateFormat(String pattern) {
        DateFormat dateFormat = (DateFormat) threadLocal.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat(pattern);
            threadLocal.set(dateFormat);
        }
        return dateFormat;
    }

    public static Date parse(String pattern, String textDate) throws ParseException {
        return getDateFormat(pattern).parse(textDate);
    }

    public static Date parse(Long milliseconds) {
        if (milliseconds == null) {
            return new Date();
        }
        return new Date(milliseconds);
    }

    public static String format(String pattern, Date date) {
        return getDateFormat(pattern).format(date);
    }

    public static String formatDefault(Date date) {
        return getDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}