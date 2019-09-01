package cn.com.sky.basics.array;

/**
 * <pre>
 *
 * 数组的三种初始化方式：
 * 1.静态初始化
 * 2.动态初始化
 * 3.默认初始化
 *
 * </pre>
 */
public class TestArrayInitial {

    public static void main(String[] args) {

        // 1.静态初始化
//         staticInitial();
        // // 2.动态初始化
        dynamicInitial();
        // // 3.默认初始化
        defaultInitial();
    }

    static void staticInitial() {

        // 1.静态初始化
        // 1>先声明，后初始化
        int[] arrayName1;// 声明，没有初始化

        // for (int i = 0; i < arrayName1.length; i++) {
        // System.out.println(arrayName1[i]);
        // }

        arrayName1 = new int[]{1, 2, 3, 4};// 初始化

        // 输出
        for (int i = 0; i < arrayName1.length; i++) {
            System.out.println(arrayName1[i]);
        }

        // 2>声明的同时，进行初始化
        int[] arrayName2 = new int[]{1, 2, 3, 4};

        // 声明的同时，进行初始化
        int[] arrayNameSecond = {4, 5, 6, 7};

        // int[] a=new int[5]{1,2,3,4,5}; //错误,如果提供了数组初始化操作，则不能定义维表达式

        // int[] arrayNameSecond2;
        // arrayNameSecond2= { 4, 5, 6, 7 }; //错误,数组常量只能在初始化操作中使用

        System.out.println("=========================");

        for (int i = 0; i < arrayName2.length; i++) {
            System.out.println(arrayName2[i]);
        }

        System.out.println("=========================");

        for (int i = 0; i < arrayNameSecond.length; i++) {
            System.out.println(arrayNameSecond[i]);
        }
    }

    static void dynamicInitial() {

        // 2.动态初始化
        int[] a;
        a = new int[3];
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        System.out.println("==============================");


        a[0] = 10;
        a[1] = 11;
        a[2] = 12;

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        System.out.println("==============================");

        int[] b = new int[3];
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        System.out.println("==============================");


        b[0] = 110;
        b[1] = 111;
        b[2] = 112;

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }

    static void defaultInitial() {

        // 3.默认初始化

        // 定义一个数组
        int[] arrayNameDong;
        arrayNameDong = new int[5];

        //数组里面的元素默认初始化为0
        int[] arrayNameDongSecond = new int[9];

        for (int i = 0; i < arrayNameDong.length; i++) {
            System.out.println(arrayNameDong[i]);
        }

        for (int i = 0; i < arrayNameDongSecond.length; i++) {
            System.out.println(arrayNameDongSecond[i]);
        }

    }

}
