package cn.com.sky.basics;

//可变参数
public class TestVariableParameter {

    public static void main(String args[]) {
        print(1);
        print(1, "1");
        print(1, "2", "3");
        print(1, new String[]{"abc", "13", "xx"});
    }

    public static void print(int a, String... messages) {// 相当于String[] messages,但不能修改成数组，否则会出错。

        System.out.println("传入的参数数量：" + messages.length);
        System.out.println(a);

        for (String s : messages) {
            System.out.println(s);
        }

        System.out.println("===========================");
    }


}
