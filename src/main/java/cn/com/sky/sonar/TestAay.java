package cn.com.sky.sonar;

import java.util.Arrays;

/**
 * <pre>
 *
 *  While hashCode and toString are available on arrays, they are largely useless. hashCode returns the array's "identity hash code", and toString returns nearly the same value. Neither method's output actually reflects the array's contents. Instead, you should pass the array to the relevant static Arrays method.
 *
 *
 * </pre>
 */
public class TestAay {

    public static void main(String[] args) {
        String[] arr = {"ab", "c", "d", "e", "a"};

        //推荐的方式。
        String argStr = Arrays.toString(arr);
        System.out.println(argStr);
        int argHash = Arrays.hashCode(arr);
        System.out.println(argHash);

        //不推荐使用下面的方式。
        String argStr2 = arr.toString(); // Noncompliant
        int argHash2 = arr.hashCode(); // Noncompliant
        System.out.println(argStr2);
        System.out.println(argHash2);
    }
}