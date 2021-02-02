package cn.com.apache_commons;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 */
public class TestString {


    @Test
    public void test1() {
        String a = null;
        System.out.println("StringUtils.isNumeric(null)=" + StringUtils.isNumeric(a));

        String b = "";
        System.out.println("StringUtils.isNumeric(\"\")=" + StringUtils.isNumeric(b));

        String c = "   ";
        System.out.println("StringUtils.isNumeric(\"   \")=" + StringUtils.isNumeric(c));

        String d = "a";
        System.out.println("StringUtils.isNumeric(a)=" + StringUtils.isNumeric(d));


        System.out.println(System.currentTimeMillis());
        System.out.println(LongToString(System.currentTimeMillis()));


    }


    private String LongToString(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = sdf.format(timestamp);
        return string;
    }

    public static void main(String[] args) {
        List list = Lists.newArrayList(Maps.newHashMap().values());
        System.out.println("list=" + list);

        System.out.println(CollectionUtils.isEmpty(list));
    }


}