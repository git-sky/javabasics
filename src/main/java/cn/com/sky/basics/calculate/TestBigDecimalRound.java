package cn.com.sky.basics.calculate;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * <pre>
 *
 * java.math.BigDecimal
 *
 * 不可变的、任意精度的有符号十进制数。BigDecimal 由任意精度的整数非标度值和32位的整数标度(scale)组成。
 *
 * 如果为零或正数，则标度是小数点后的位数。如果为负数，则将该数的非标度值乘以10的负scale次幂。
 *
 * 因此，BigDecimal表示的数值是(unscaledValue × 10-scale)。
 *
 * 在银行、帐户、计费等领域，BigDecimal提供了精确的数值计算。其中8种舍入方式值得掌握。
 *
 * 不同舍入模式下的舍入操作汇总:
 *
 * 根据给定的舍入模式将输入数字舍入为一位数的结果
 *
 * 输入数字	UP	DOWN	CEILING		FLOOR	HALF_UP	HALF_DOWN	HALF_EVEN	UNNECESSARY
 * 5.5		6	5		6			5			6		5			6		抛出 ArithmeticException
 * 2.5		3	2		3			2			3		2			2		抛出 ArithmeticException
 * 1.6		2	1		2			1			2		2			2		抛出 ArithmeticException
 * 1.1		2	1		2			1			1		1			1		抛出 ArithmeticException
 * 1.0		1	1		1			1			1		1			1		1
 * -1.0		-1	-1		-1			-1			-1		-1			-1		-1
 * -1.1		-2	-1		-1			-2			-1		-1			-1		抛出 ArithmeticException
 * -1.6		-2	-1		-1			-2			-2		-2			-2		抛出 ArithmeticException
 * -2.5		-3	-2		-2			-3			-3		-2			-2		抛出 ArithmeticException
 * -5.5		-6	-5		-5			-6			-6		-5			-6		抛出 ArithmeticException
 *
 * </pre>
 */
public class TestBigDecimalRound {

    @Test
    public void round_unnecessay() {
        /**
         * <p>
         * 断言请求的操作具有精确的结果，因此不需要舍入。
         * </p>
         * <p>
         * 如果对获得精确结果的操作指定此舍入模式，则抛出ArithmeticException。
         * </p>
         */
        BigDecimal b = new BigDecimal("2.355");
        float f1 = b.setScale(2, BigDecimal.ROUND_UNNECESSARY).floatValue();
        System.out.println("ROUND_UNNECESSARY===" + f1);
    }

    @Test
    public void round_up() {
        /**
         * 舍入远离零的舍入模式。 在丢弃非零部分之前始终增加数字(始终对非零舍弃部分前面的数字加1)。 注意，此舍入模式始终不会减少计算值的大小。
         */
        BigDecimal b = new BigDecimal("2.351");
        float f1 = b.setScale(2, BigDecimal.ROUND_UP).floatValue();
        System.out.println("ROUND_UP===" + f1);
    }

    @Test
    public void round_down() {
        /**
         * 接近零的舍入模式。 在丢弃某部分之前始终不增加数字(从不对舍弃部分前面的数字加1，即截短)。 注意，此舍入模式始终不会增加计算值的大小。
         */
        BigDecimal b = new BigDecimal("2.359");
        float f1 = b.setScale(2, BigDecimal.ROUND_DOWN).floatValue();
        System.out.println("ROUND_DOWN===" + f1);
    }

    @Test
    public void round_ceiling() {
        /**
         * <p>
         * 接近正无穷大的舍入模式。
         * </p>
         * <p>
         * 如果 BigDecimal 为正，则舍入行为与 ROUND_UP 相同;
         * </p>
         * <p>
         * 如果为负，则舍入行为与 ROUND_DOWN 相同。
         * </p>
         * <p>
         * 注意，此舍入模式始终不会减少计算值。
         * </p>
         */
        BigDecimal b = new BigDecimal("2.351");
        float f1 = b.setScale(2, BigDecimal.ROUND_CEILING).floatValue();
        System.out.println("ROUND_CEILING===" + f1);
    }

    @Test
    public void round_floor() {
        /**
         * <p>
         * 接近负无穷大的舍入模式。
         * </p>
         * <p>
         * 如果 BigDecimal 为正，则舍入行为与 ROUND_DOWN 相同;
         * </p>
         * <p>
         * 如果为负，则舍入行为与 ROUND_UP 相同。
         * </p>
         * <p>
         * 注意，此舍入模式始终不会增加计算值。
         * </p>
         */
        BigDecimal b = new BigDecimal("2.359");
        float f1 = b.setScale(2, BigDecimal.ROUND_FLOOR).floatValue();
        System.out.println("ROUND_FLOOR===" + f1);
    }


    @Test
    public void round_half_up() {
        /**
         * <p>
         * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。
         * </p>
         * <p>
         * 如果舍弃部分 >= 0.5，则舍入行为与 ROUND_UP 相同；否则舍入行为与 ROUND_DOWN 相同。
         * </p>
         * <p>
         * 注意，这是我们大多数人在小学时就学过的舍入模式(四舍五入)。
         * </p>
         */
        BigDecimal b = new BigDecimal("2.354");
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("ROUND_HALF_UP===" + f1);

        BigDecimal b2 = new BigDecimal("2.355");
        double f2 = b2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("ROUND_HALF_UP===" + f2);

    }

    @Test
    public void round_half_down() {
        /**
         * <p>
         * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为上舍入的舍入模式。
         * </p>
         * <p>
         * 如果舍弃部分 > 0.5，则舍入行为与 ROUND_UP 相同；否则舍入行为与 ROUND_DOWN 相同(五舍六入)。
         * </p>
         */
        double f = 1.355;
        BigDecimal b = BigDecimal.valueOf(f);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        System.out.println("ROUND_HALF_DOWN===" + f1);
    }

    @Test
    public void round_half_even() {
        /**
         * <p>
         * 向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
         * </p>
         * <p>
         * 如果舍弃部分左边的数字为奇数，则舍入行为与 ROUND_HALF_UP 相同;
         * </p>
         * <p>
         * 如果为偶数，则舍入行为与 ROUND_HALF_DOWN 相同。
         * </p>
         * <p>
         * 注意，在重复进行一系列计算时，此舍入模式可以将累加错误减到最小。
         * </p>
         * <p>
         * 此舍入模式也称为“银行家舍入法”，主要在美国使用。四舍六入，五分两种情况。
         * </p>
         * <p>
         * 如果前一位为奇数，则入位，否则舍去。
         * </p>
         * <p>
         * 以下例子为保留小数点1位，那么这种舍入方式下的结果。
         * </p>
         * <p>
         *     四舍六入，逢五奇进偶舍
         *
         * 1.15>1.2 1.25>1.2
         * </p>
         */
        double f = 2.345;
        BigDecimal b = BigDecimal.valueOf(f);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        System.out.println("ROUND_HALF_EVEN===" + f1);


        BigDecimal b2 = new BigDecimal("1.15");
        double f2 = b2.setScale(1, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        System.out.println("ROUND_HALF_EVEN===" + f2);


        BigDecimal b3 = new BigDecimal("1.25");
        double f3 = b3.setScale(1, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        System.out.println("ROUND_HALF_EVEN===" + f3);
    }

}
