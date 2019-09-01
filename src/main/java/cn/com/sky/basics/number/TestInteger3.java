package cn.com.sky.basics.number;

import org.junit.Test;

public class TestInteger3 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        Integer c = 1;

        System.out.println(a + b + c + "a");//3a

        System.out.println("a" + a + b + c);//a111

        System.out.println("中国abc".length());//5
    }

    @Test
    public void test() {
        String usableArea = "20.99-99.08";
        String[] split = usableArea.split("-");
        if (split.length == 1) {
            Integer area;
            try {
                area = Integer.valueOf(split[0]);
            } catch (Exception e) {
                area = Double.valueOf(split[0]).intValue();
            }
            System.out.println(area);

        }
        if (split.length == 2) {
            Integer low;
            try {
                low = Integer.valueOf(split[0]);
            } catch (Exception e) {
                low = Double.valueOf(split[0]).intValue();
            }

            Integer high;
            try {
                high = Integer.valueOf(split[1]);
            } catch (Exception e) {
                high = Double.valueOf(split[1]).intValue();
            }

            System.out.println(low);
            System.out.println(high);
        }
    }
}
