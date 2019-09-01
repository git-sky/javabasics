package cn.com.sky.basics.number;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.junit.Test;

public class TestNumberFormat {

    @Test
    public void test1() {

        Double myNumber = 23323.3323232323;
        Double test = 0.3434;
        // getInstance()
        // 返回当前缺省语言环境的缺省数值格式。
        String myString = NumberFormat.getInstance().format(myNumber);
        System.out.println(myString);
        // getCurrencyInstance()返回当前缺省语言环境的通用格式
        myString = NumberFormat.getCurrencyInstance().format(myNumber);
        System.out.println(myString);
        // getNumberInstance() 返回当前缺省语言环境的通用数值格式。
        myString = NumberFormat.getNumberInstance().format(myNumber);
        System.out.println(myString);

        // getPercentInstance() 返回当前缺省语言环境的百分比格式。
        myString = NumberFormat.getPercentInstance().format(test);
        System.out.println(myString);

        // setMaximumFractionDigits(int) 设置数值的小数部分允许的最大位数。
        // setMaximumIntegerDigits(int) 设置数值的整数部分允许的最大位数。
        // setMinimumFractionDigits(int) 设置数值的小数部分允许的最小位数。
        // setMinimumIntegerDigits(int) 设置数值的整数部分允许的最小位数.
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(3);
        format.setMaximumFractionDigits(5);
        format.setMaximumIntegerDigits(10);
        format.setMinimumIntegerDigits(4);
        System.out.println(format.format(2132323213.23266666666));
    }

    @Test
    public void Test2() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));
        System.out.println("利息:\t" + currency.format(interest));
    }

}

// 结果为:
// 23,323.332
// ￥23,323.33
// 23,323.332
// 34%
// 2,132,323,213.23267