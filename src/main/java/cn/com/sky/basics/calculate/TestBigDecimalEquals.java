package cn.com.sky.basics.calculate;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * <pre>
 *
 * 对于BigDecimal的大小比较，
 *
 * 用equals方法的话会不仅会比较值的大小，还会比较两个对象的精确度，
 *
 * 而compareTo方法则不会比较精确度，只比较数值的大小。
 *
 * </pre>
 */
public class TestBigDecimalEquals {

    @Test
    public void testEquals() {
        BigDecimal bd1 = new BigDecimal("3.0");
        BigDecimal bd2 = new BigDecimal("3.00");

        System.out.println("equals:" + bd1.equals(bd2));
        System.out.println("compareTo:" + (bd1.compareTo(bd2) == 0));

        System.out.println("equals:" + new BigDecimal("1.2").equals(new BigDecimal("1.20"))); // 输出false
        System.out.println("compareTo:" + (new BigDecimal("1.2").compareTo(new BigDecimal("1.20")) == 0)); // 输出true


    }


    @Test
    public void compare() {
        BigDecimal[] nums = {null, new BigDecimal("1.23"), new BigDecimal("1"), new BigDecimal("1.00"), new BigDecimal("0.1")};
        for (BigDecimal amount : nums) {
            //比较大小使用compareTo，不能用equals。
            if (amount == null || new BigDecimal("1").compareTo(amount) >= 0) {
                System.out.println("need continue：" + amount);
                continue;
            }
            System.out.println("success: " + amount);
        }

        System.out.println("=================================");
        for (BigDecimal amount : nums) {
            //比较大小使用compareTo，不能用equals。
            if (amount == null || new BigDecimal("1").equals(amount)) {
                System.out.println("need continue：" + amount);
                continue;
            }
            System.out.println("success: " + amount);
        }

    }
}
