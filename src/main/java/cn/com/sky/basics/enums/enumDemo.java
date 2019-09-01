package cn.com.sky.basics.enums;

enum Mobile {
    Samsung(400), Nokia(250), Motorola(325);

    private int price;

    Mobile(int p) {
        price = p;
    }

    int showPrice() {
        return price;
    }
}

public class EnumDemo {

    public static void main(String args[]) {

        System.out.println("CellPhone List:");
        for (Mobile m : Mobile.values()) {
            System.out.println(m + " costs " + m.showPrice() + " dollars");
        }

        Mobile ret;
        ret = Mobile.valueOf("Samsung");
        System.out.println("Selected : " + ret);
    }
}