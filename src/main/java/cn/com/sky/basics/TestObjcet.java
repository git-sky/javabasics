package cn.com.sky.basics;

public class TestObjcet {

    private int a = 10;

    public static void main(String[] args) {
        TestObjcet s = new TestObjcet();
        TestObjcet d = s;
        System.out.println(s.a);
        System.out.println(d.a);
        d.a = 1000;
        System.out.println(s.a);
        System.out.println(d.a);
    }
}
