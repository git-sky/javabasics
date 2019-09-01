package cn.com.sky.basics.enums;

public class TestEnum {
    DemoEnum s = DemoEnum.d;

    public static void main(String[] args) {
        new TestEnum().print();
        System.out.println(new TestEnum().s == DemoEnum.d);

    }

    public void print() {
        switch (s) {
            case A:
                System.out.println(s);
                break;

            case B:
                System.out.println(s);
                break;

            case C:
                System.out.println(s);
                break;

            case d:
                System.out.println(s);
                break;

        }
    }

}
