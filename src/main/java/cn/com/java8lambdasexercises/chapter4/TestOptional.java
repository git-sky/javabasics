package cn.com.java8lambdasexercises.chapter4;


import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;

public class TestOptional {

    @Test
    public void test() {
        Optional<String> a = Optional.of("a");
        Assert.assertEquals("a", a.get());
        Assert.assertTrue(a.isPresent());
    }

    @Test
    public void test2() {
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);

        Assert.assertFalse(emptyOptional.isPresent());

        Assert.assertTrue(emptyOptional.equals(alsoEmpty));
        Assert.assertTrue(emptyOptional == alsoEmpty);


        Assert.assertEquals("b", emptyOptional.orElse("b"));
        Assert.assertEquals("c", emptyOptional.orElseGet(() -> "c"));
    }


    @Test
    public void test3() {
        Optional emptyOptional = Optional.empty();
        Assert.assertEquals("b", emptyOptional.orElse("b"));
        Assert.assertEquals("c", emptyOptional.orElseGet(() -> "c"));
    }

    @Test
    public void testOptionalList() {
//        List<Integer> list = null;
//        List<Integer> list = Lists.newArrayList();
        List<Integer> list = Lists.newArrayList(1, 4, 3, 2, 5);

        System.out.println(list);

        //list类型转换，方式1
        List<String> retList = Optional.ofNullable(list)
                .map(x -> x.stream()
                        .map(item -> String.valueOf(item) + "a")
                        .collect(Collectors.toList()))
                .orElse(Lists.newArrayList());


        System.out.println(retList);

        //list类型转换，方式2
        List<String> retList2 = Optional.ofNullable(list)
                .orElseGet(() -> {
                    return new ArrayList<>();
                })
                .stream()
                .map(item -> {
                            return String.valueOf(item) + "b";
                        }
                ).collect(Collectors.toList());

        System.out.println(retList2);

        //Optional的一个坑。使用空列表的时候，需要注意。
        List<Double> a = new ArrayList<>();
        Optional<List<Double>> one1 = Optional.of(a);
        System.out.println(one1.isPresent());
        if (one1.isPresent()) {
            List<Double> list1 = one1.get();

            // one1.get()是空列表，执行下面操作会报错。
            double b = one1.get().stream().mapToDouble(x -> x).average().getAsDouble();
        }


        //下面的没问题。
//        List<Double> a = new ArrayList<>();
//        Optional<List<Double>> one1 = Optional.of(a);
//        System.out.println(one1.isPresent());
//        if (one1.isPresent()) {
//            List<Double> list1 = one1.get();
//            // one1.get()是空列表，执行下面操作不会报错。
//            List<String> ss = one1.get().stream().map(item -> {
//                        return String.valueOf(item) + "b";
//                    }
//            ).collect(Collectors.toList());
//
//            System.out.println("ss=" + ss);
//        }
    }

}