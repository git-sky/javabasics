package cn.com.sky.alpha_work;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class fsdf {

    public static void main(String[] args) {
        // Float f = Float.MIN_VALUE;
        // System.out.println(f);
        //
        // System.out.println(Float.valueOf(f.toString()) > 0);
        // System.out.println(Double.valueOf(f.toString()) > 0);
        //
        // System.out.println(Float.valueOf(f.toString()) == 0);
        // System.out.println(Double.valueOf(f.toString()) == 0);
        // System.out.println(f == 0);
        //
         System.out.print(UUID.randomUUID().toString());

        System.out.println(3 / 2);
        System.out.println(3.2 / 2);

        System.out.println(3 % 2);
        System.out.println(3.2 % 2);
        new fsdf().say();
    }

    public void say() {
        System.out.println(getClass());
        System.out.println(getClass().getName());

        long a = 3456L;
        Long b = Long.valueOf(3456);
        System.out.println(a == b.intValue());
    }

    @Test
    public void vvvvvv() {
        String version = "3435450001";
        if (version.length() >= 4) {
            String suffix = version.substring(version.length() - 4);
            System.out.println(suffix);
        }

    }

}
