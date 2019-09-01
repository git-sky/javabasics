package cn.com.sky.basics.calculate;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * <pre>
 *
 * BigDecimal进行double加法也是不准确的。
 *
 * </pre>
 */
public class TestBigDecimalAdd {

    @Test
    public void addBigDecimalDouble() {

        BigDecimal total = new BigDecimal(0);
        BigDecimal[] nums = {new BigDecimal(0.88), new BigDecimal(0.16), new BigDecimal(1.32), new BigDecimal(7.84), new BigDecimal(1.46), new BigDecimal(8.0),
                new BigDecimal(1.5), new BigDecimal(12.0)};
        for (BigDecimal amount : nums) {
            total = total.add(amount);
            System.out.println("success= " + total);
        }
    }

    @Test
    public void addBigDecimalString() {

        BigDecimal total = new BigDecimal(0);
        BigDecimal[] nums = {new BigDecimal("0.88"), new BigDecimal("0.16"), new BigDecimal("1.32"), new BigDecimal("7.84"), new BigDecimal("1.46"), new BigDecimal("8.0"),
                new BigDecimal("1.5"), new BigDecimal("12.0")};
        for (BigDecimal amount : nums) {
            total = total.add(amount);
            System.out.println("success= " + total);
        }
    }
}
