package cn.com.sky.basics.innerclass;

/**
 * 匿名类
 */
public class TestAnonymousClass {

    public static void main(String args[]) {

        MyInterface action = new MyInterface() {
            public Object get() {
                return "haha";
            }
        };

        System.out.println(action.get());
    }

}
