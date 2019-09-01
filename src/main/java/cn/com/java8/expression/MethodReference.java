package cn.com.java8.expression;

import cn.com.java8.filter.Apple;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法推导
 */
public class MethodReference {

    @Test
    public void testComparator() {

        List<Apple> list = Arrays.asList(new Apple("cab", 123), new Apple("abc", 211), new Apple("abc", 123));

        //方式1：匿名内部类
        System.out.println("========== 方式1：匿名内部类 ==========");
        Collections.shuffle(list);
        System.out.println(list);

        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        System.out.println(list);


        System.out.println("========== 方式2：lamda方式 ==========");

        //方式2：lamda方式
        Collections.shuffle(list);
        System.out.println(list);

        list.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
//        list.sort((a1, a2) -> a2.getColor().compareTo(a1.getColor()));


        System.out.println(list);


        System.out.println("========== 方式3：使用lamda简化方式 ==========");

        //方式3：使用lamda简化方式
        Collections.shuffle(list);
        System.out.println(list);
        //升序可以简化为这样，降序不可以。
        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);
    }

    @Test
    public void testConsumer() {
        System.out.println("========== Consumer1 ==========");

        Consumer<String> consumer = (s) -> System.out.println(s);
        useConsumer(consumer, "Hello Alex1");


        System.out.println("========== Consumer2 ==========");

        useConsumer(s -> System.out.println(s), "Hello Alex2");

        System.out.println("========== Consumer3 ==========");

        //跟Consumer类似，可以推导；
        useConsumer(System.out::println, "Hello Alex3");

    }

    @Test
    public void testSupplier() {
        System.out.println("========== Supplier ==========");

        Supplier<String> supplier = String::new;

        String s = supplier.get();
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.getClass());
    }

    @Test
    public void testBiFunction() {
        System.out.println("========== BiFunction ==========");
        BiFunction<String, Long, Apple> appleFuntion = Apple::new;
        Apple apple = appleFuntion.apply("red", 100L);
        System.out.println(apple);


        BiFunction<String, Integer, Character> sBiFunction = String::charAt;
        Character c = sBiFunction.apply("abcdefg", 2);
        System.out.println(c);

        //使用对象进行方法推导
        String str = new String("abcdefg");
        Function<Integer, Character> f3 = str::charAt;
        Character c2 = f3.apply(4);
        System.out.println(c2);
    }

    @Test
    public void testThreeFunction() {
        System.out.println("========== ThreeFunction ==========");
        ThreeFunction<String, Long, String, ComplexApple> threeFunction = ComplexApple::new;
        ComplexApple complexApple = threeFunction.apply("Green", 123L, "FuShi");
        System.out.println(complexApple);
    }

    @Test
    public void testComparatorComparing() {
        System.out.println("========== Comparator.comparing ==========");
        List<Apple> list = Arrays.asList(new Apple("bac", 123), new Apple("abc", 211), new Apple("abc", 123));
        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);
    }

    @Test
    public void testInteger() {
        System.out.println("========== Integer::parseInt ==========");
        int value = Integer.parseInt("123");

        Function<String, Integer> f = Integer::parseInt;

        Integer result = f.apply("123");
        System.out.println(result);
    }

    @Test
    public void testForEach() {
        System.out.println("========== Comparator ==========");

        List<Apple> list = Arrays.asList(new Apple("abc", 123), new Apple("Green", 110), new Apple("red", 123));
        System.out.println(list);

        list.sort(Comparator.comparing(Apple::getColor));
        //等同于
        //list.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
        System.out.println(list);


        System.out.println("========== stream.forEach ==========");

        list.stream().forEach(System.out::println);
        //等同于
        list.stream().forEach(a -> System.out.println(a));

    }

    private static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
}
