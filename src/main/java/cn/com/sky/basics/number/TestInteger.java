package cn.com.sky.basics.number;

import org.junit.Test;

/**
 * <pre>
 *
 * 【强制】所有的相同类型的包装类对象之间值的比较，全部使用equals方法比较。
 * 说明：对于Integer var=?在-128至127之间的赋值，Integer对象是在IntegerCache.cache产生，会复用已有对象，
 * 这个区间内的Integer值可以直接使用==进行判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，推荐使用equals方法进行判断。
 *
 * </pre>
 */
public class TestInteger {

    // （1） Integer和 int之间可以进行各种比较；Integer对象将自动拆箱后与int值比较
    // （2） 两个Integer对象之间也可以用>、<等符号比较大小；两个Integer对象都自动拆箱后，再比较大小
    // （3）两个Integer对象不要用==比较。因为：-128~127范围(一般是这个范围)内是取缓存内对象用，所以相等，该范围外是两个不同对象引用比较，所以不等。

    @Test
    public void test1() {
        Integer num1 = 297;
        int num2 = 297;
        System.out.println("num1==num2: " + (num1 == num2));
    }

    @Test
    public void test2() {

        // 在自动装箱时对于值从–128到127之间的值，它们被装箱为Integer对象后，会存在内存中被重用，始终只存在一个对象.
        // 而如果超过了从–128到127之间的值，被装箱后的Integer对象并不会被重用，即相当于每次装箱时都新建一个 Integer对象。

        Integer num1 = 297;
        Integer num2 = 297;
        System.out.println("num1==num2: " + (num1 == num2));
        System.out.println("num1>num2: " + (num1 > num2));
        System.out.println("num1<num2: " + (num1 < num2));

        System.out.println("===================================");

        // 在-128~127 之内的数，则相等。
        Integer num3 = 97;
        Integer num4 = 97;
        System.out.println("num3==num4: " + (num3 == num4));
        System.out.println("num3>num4: " + (num3 > num4));
        System.out.println("num3<num4: " + (num3 < num4));

        System.out.println("===================================");

        //两个Integer，无论大小，都不相等。
        Integer num5 = new Integer(97);
        Integer num6 = new Integer(97);
        System.out.println("num3==num4: " + (num5 == num6));
        System.out.println("num3>num4: " + (num5 > num6));
        System.out.println("num3<num4: " + (num5 < num6));

    }

    @Test
    public void test3() {
        long a = 59999L;
        int b = 10000;
        //取整
        System.out.println(a / b);

    }

    @Test
    public void test4() {

        long a = 1221212222555L;
        int b = (int) a;

        System.out.println(b);

        Long c = 27L;

        int d = Integer.parseInt(String.valueOf(c));

        System.out.println(d);
    }


    @Test
    public void test5() {
        String user_id = "100000000004";
        String friend_id = "100000000005";
        if (Long.valueOf(user_id) < Long.valueOf(friend_id)) {
            System.out.println("--------------------------");
        } else {
            System.out.println("-===========================");
        }
    }

    @Test
    public void test6() {
        Integer num = new Integer(1);
        System.out.println(validStatus(num));
    }

    private boolean validStatus(Integer num) {
//        return num == 1;
        //返回false，在–128到127之间，也不相等。
        return num == new Integer(1);
    }

    @Test
    public void tes(){
        long a=-1;
        System.out.println(a!=-1);
    }
}
