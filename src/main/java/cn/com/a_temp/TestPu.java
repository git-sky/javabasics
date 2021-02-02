package cn.com.a_temp;

/**
 *
 */
public class TestPu {

    public static void main(String[] args) {
        System.out.println("268e505845f69b130f2c9882d1786d57f4136a78268e505845f69b130f2c9882d1786d57f4136a78f2c9882d1786d57f4136".length());


        System.out.println("268e505845f69b130f2c9882d1786d57f4136a78268e505845".length());


        System.out.println("268e505845f69b130f2c9882d1786d57f4136a78268e505845f69b130f2c9882".length());

        System.out.println("016de8d743484d5aae356d118704b998".length());

        System.out.println(("4503b3691d974573a747ed85f74f1a29" + "268e505845f69b130f2c9882d1786d57f4136a78").length());

        System.out.println("c0564e81d2da40198c1e8ae323710403".length());

        long begin = System.currentTimeMillis();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis() - begin;
        if (time > 10000) {
            System.out.println("time===" + time);
        }

    }
}