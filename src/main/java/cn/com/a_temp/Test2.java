package cn.com.a_temp;

import java.util.Objects;

/**
 *
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(Objects.equals(1, 1L));

        Integer a = 999999;
        Integer b = 999999;
        System.out.println(Objects.equals(a, b));


        Long la = 999999L;
        Long lb = 999999L;
        System.out.println(Objects.equals(la, lb));
    }
}