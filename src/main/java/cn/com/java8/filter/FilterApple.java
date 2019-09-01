package cn.com.java8.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilterApple {


    //方式3：lamda表达式

    @FunctionalInterface
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    //方式2：策略模式
    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd160WeightFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight() >= 160);
        }
    }

    public static class YellowLess150WeightFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("yellow") && apple.getWeight() < 150);
        }
    }

    //方式1：传统for方式
    public static List<Apple> findGreenApple(List<Apple> apples) {

        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static List<Apple> findApple(List<Apple> apples, String color) {
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));

        //方式1：传统for方式
//         List<Apple> greenApples = findGreenApple(list);
//        assert greenApples.size() == 2;

//       List<Apple> greenApples = findApple(list, "green");
//        System.out.println(greenApples);
//
//        List<Apple> redApples = findApple(list, "red");
//        System.out.println(redApples);

        //方式2：策略模式
//        List<Apple> result = findApple(list, new GreenAnd160WeightFilter());
//        System.out.println(result);
//
//        List<Apple> yellowList = findApple(list, new AppleFilter() {
//            @Override
//            public boolean filter(Apple apple) {
//                return "yellow".equals(apple.getColor());
//            }
//        });
//
//        System.out.println(yellowList);

        //方式3：lamda表达式
        List<Apple> lambdaResult1 = findApple(list, (Apple apple) -> {
            return apple.getColor().equals("green");
        });

        List<Apple> lambdaResult2 = findApple(list, (apple) -> {
            return apple.getColor().equals("green");
        });


        List<Apple> lambdaResult3 = findApple(list, apple -> apple.getColor().equals("green"));

        System.out.println(lambdaResult3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();


        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();


        Thread.currentThread().join();
    }


}
