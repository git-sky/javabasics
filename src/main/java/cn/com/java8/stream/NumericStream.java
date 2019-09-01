package cn.com.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * IntStream用法
 * <p>
 * 使用具体的元数据类型，可以减少内存占用。
 */
public class NumericStream {


    @Test
    public void Stream() {
        System.out.println("====== Stream ====== ");

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        Stream<Integer> integerStream = stream.filter(i -> i.intValue() > 3);

        Integer result = integerStream.reduce(0, Integer::sum);

        System.out.println(result);
    }

    @Test
    public void IntStream() {
        System.out.println("====== IntStream ====== ");
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //Stream -> IntStream
        IntStream intStream = stream.mapToInt(i -> i.intValue());

        int result = intStream.filter(i -> i > 3).sum();

        System.out.println(result);
    }


    public static void main(String[] args) {

        int a = 9;

        //1..1000
        //result int[a,b,c];

        //
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()//装箱
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));

        System.out.println("=======================");


        //mapToObj 相当于 boxed+map
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));
    }
}
