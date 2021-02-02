package cn.com.apache_commons;


import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.math.RoundingMode;


public class TestNumberUtils {

    //校验功能
    @Test
    public void test1s() {
        //检查字符串是否是有效的Java数字
//isCreatable 慎用，有效数字包括进制标有0x或0X预选项，八进制数、科学记数法和标有类型限定符的数字
//所以08，09返回false，不是有效的八进制
        NumberUtils.isCreatable("abc");//return false
        NumberUtils.isCreatable("123");//return true
        NumberUtils.isCreatable("08");//return false
        NumberUtils.isCreatable("09");//return false
//检查给定字符串是否是可解析的数字
        NumberUtils.isParsable("abc");//return false
        NumberUtils.isParsable("001");//return true
//检查给定字符串是否是否只包含数字字符
        NumberUtils.isDigits("abc");//return false
        NumberUtils.isDigits("123");//return true
        System.out.println(Long.valueOf("001"));
        int a = 012;
        System.out.println(a);
        System.out.println(012);
    }


    //转换功能
    @Test
    public void tests() {
        //将一个字符串转换为int类型，失败返回0
        NumberUtils.toInt("123");
//将一个字符串转换为int类型，失败返回自定义
        NumberUtils.toInt("123", 1);
//将一个字符串转换为long类型，失败返回0
        NumberUtils.toLong("123");
//将一个字符串转换为long类型，失败返回自定义
        NumberUtils.toLong("123", 2);
//将一个字符串转换为单精度浮点类型,失败返回0.0
        NumberUtils.toFloat("12.3");
//将一个字符串转换为单精度浮点类型,失败返回自定义
        NumberUtils.toFloat("12.3", 2.1f);
//将一个字符串转换为双精度浮点类型,失败返回0.0
        NumberUtils.toDouble("2.1");
//将一个字符串转换为双精度浮点类型，失败返回自定义
        NumberUtils.toDouble("2.1", 1.0d);
//将一个字符串转换为BigDecimal,默认保留2位小数,舍入模式为RoundingMode.HALF_EVEN
        NumberUtils.toScaledBigDecimal("2.1");
//将一个字符串转换为BigDecimal,自定义小数位数,自定义舍入模式
        NumberUtils.toScaledBigDecimal("2.1", 2, RoundingMode.HALF_UP);
    }

    @Test
    public void test1() {
        //获取最大最小值,支持各种类型
        int[] array = {2, 4, 6, 10};
//获取数组中最小的元素,并返回
        NumberUtils.min(array);
//获取数据中最大的元素,并返回
        NumberUtils.max(array);
        int n = 1, n1 = 4, n2 = 10;
//获取n个变量最小值
        NumberUtils.min(n, n1, n2);
//获取n个变量最大值
        NumberUtils.max(n, n1, n2);
//比较大小,大于返回1,等于返回0,小于返回-1
        NumberUtils.compare(n, n1);
    }
}