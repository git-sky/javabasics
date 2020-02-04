package cn.com.sky.alpha_work;

public class Hong extends Person {

    public Hong(String name, int age) {
        super(name, age);
    }

    public Hong() {
    }

    public static void main(String[] args) {
        Hong p = new Hong();

        System.out.println(p.getName());

        String a = null;
        String b = null;
        System.out.println(a + b);

        Object obj = null;

        Hong h = (Hong) obj;
        System.out.println(h);
//		System.out.println(h.getAge());

        System.out.println(String.valueOf(null));

    }
}
