package cn.com.sky.mock.junit.demo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

    private Calculator cal;

    @BeforeClass
    public static void globalInit() {
        System.out.println("globalInit");
    }

    @AfterClass
    public static void globalDestroy() {
        System.out.println("globalDestroy");
    }

    @Before
    public void init() {
        cal = new Calculator();
        System.out.println("init invoked");
    }

    @After
    public void destroy() {
        System.out.println("destroy invoked");
    }

    @Test
    public void testAdd() {

        int result = cal.add(1, 2);

        assertEquals(3, result);

    }

    @Test
    public void testMinus() {

        int result = cal.minus(1, 2);

        assertEquals(-1, result);
    }

    @Test
    public void testMultiply() {

        int result = cal.multiply(2, 3);

        assertEquals(6, result);
    }

    @Test
    public void testDivide() {
        try {
            int result = cal.divide(6, 5);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 期望测试方法中能够抛出Exception异常
    @Test(expected = Exception.class)
    public void testDivide2() throws Exception {
        cal.divide(6, 0);
    }

    // 期望测试方法运行时间在100毫秒以内，此方法中使用Thread.sleep(110)来故意延迟线程操作时间
    @Test(timeout = 100)
    public void testDivide3() {
        try {
            cal.divide(4, 2);
            Thread.sleep(110);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}