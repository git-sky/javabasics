package cn.com.sky.basics;

public class TestNull {

    public static void main(String[] args) {
        String a = "a";
        String b = null;

        System.out.println(a);
        b = a;
        System.out.println(a);
        System.out.println(b);
        b = null;
        System.out.println(a);
        System.out.println(b);
    }

}
