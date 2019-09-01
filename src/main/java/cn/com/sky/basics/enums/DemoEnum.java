package cn.com.sky.basics.enums;

public enum DemoEnum {
    A, B, C, d;

    public static void main(String[] args) {
        for (DemoEnum c : DemoEnum.values()) {
            System.out.println(c.ordinal() + ":" + c.name());
        }
    }

}
