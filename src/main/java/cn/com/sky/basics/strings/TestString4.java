package cn.com.sky.basics.strings;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * 避免Java应用中NullPointerException的技巧和最佳实践
 */
public class TestString4 {

    @Test
    public void testEquals() {
        /**
         * 非null值的放到前面。
         */
        String a = null;
        System.out.println("a".equals(a));
        System.out.println("a".equalsIgnoreCase(a));
    }

    @Test(expected = NullPointerException.class)
    public void testEqualsException() {
        /**
         * null的equals方法，报错NullPointerException。
         */
        String a = null;
        System.out.println(a.equals("a"));
        System.out.println(a.equalsIgnoreCase("a"));
    }

    @Test(expected = NullPointerException.class)
    public void testToString() {

        /**
         * null的toString方法，报错NullPointerException。
         */
        Integer ia = null;
        Float fa = null;
        Double da = null;
        BigDecimal bd = null;

        System.out.println(ia.toString());
        System.out.println(fa.toString());
        System.out.println(da.toString());
        System.out.println(bd.toString());
    }

    @Test
    public void testValueOf() {
        /**
         * String.valueOf(a)不报错。
         */
        Integer ia = null;
        Float fa = null;
        Double da = null;
        BigDecimal bd = null;
        Object s = null;

        System.out.println(String.valueOf(ia));// 不报错
        System.out.println(String.valueOf(fa));// 不报错
        System.out.println(String.valueOf(da));// 不报错
        System.out.println(String.valueOf(bd));// 不报错
        System.out.println(String.valueOf(s));// 不报错
        System.out.println(String.valueOf(null));// 报错
    }

    @Test(expected = NumberFormatException.class)
    public void testParse() {
        String s = null;
        System.out.println(Integer.parseInt(s));
        System.out.println(Integer.parseInt(null));
        System.out.println(Integer.valueOf(null));
    }

    @Test
    public void testStringUtils() {
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isEmpty(null));
    }

    @Test
    public void testCollections() {

        List list = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        Set set = Collections.EMPTY_SET;

        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
    }


}
