package cn.com.a_temp;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class Test222 {

    public static void main(String[] args) {
        String url = "";
        if (StringUtils.contains(url, " ")) {
            System.out.println(url);
        }


        String dateStr = DateFormatUtils.format("yyyy-MM-dd", new Date());
        dateStr = null;

        if (dateStr == null || dateStr.length() != 10) {
            System.out.println(dateStr);
        }

        boolean createAble = NumberUtils.isCreatable("4.0");
        System.out.println(createAble);
        if (createAble) {
            BigDecimal bigDecimal = NumberUtils.createBigDecimal("4.0");
            if (new BigDecimal(5).compareTo(bigDecimal) > 0) {
                System.out.println("..jfalsdfjalsdfjl");
            }
        }
    }
}