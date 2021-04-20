package cn.com.sky.basics.generics.one_generic_clazz;

/**
 * 范型类型demo
 */
public class TestGenericA {

    public static void main(String[] args) {

        //demo1
        Person<String> p1 = new Person(101);
        p1.setSecrecy("芝麻开门");
        //强转
        String s = (String) p1.getSecrecy();
        System.out.println(p1.getId() + "，密码是:" + s);

        //demo2
        Person<Double> p2 = new Person<>(102);
        p2.setSecrecy(8700.45);
        double money = p2.getSecrecy();
        System.out.println(p2.getId() + "，秘密资金数额:" + money);

    }

    private static final class Person<a> {

        private final int id;
        private a secrecy;

        public Person(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public a getSecrecy() {
            return secrecy;
        }

        public void setSecrecy(a secrecy) {
            this.secrecy = secrecy;
        }
    }

}
