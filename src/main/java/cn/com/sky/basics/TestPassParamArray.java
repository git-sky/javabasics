package cn.com.sky.basics;


/**
 * 数组的传递，传递的是数组地址值。
 */
public class TestPassParamArray {


    public static void main(String[] args) {

        int[] array = {1};
        test1(array);
        System.out.println(array[0]);

        test2(array[0]);
        System.out.println(array[0]);

        test3(array);
        System.out.println(array[0]);


    }

    private static void test1(int array[]) {
        array[0] = array[0] + 100;
    }

    private static void test2(int param) {
        param = param + 100;
    }

    private static void test3(int array[]) {
        array = new int[5];
        array[0] = 100;
        System.out.println(array[0]);
        System.out.println(array[1]);

        Integer i = new Integer(1);
        System.out.println(i);

        String s = new String();
        System.out.println(s);

    }


}
