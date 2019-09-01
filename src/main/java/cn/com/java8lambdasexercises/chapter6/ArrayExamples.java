package cn.com.java8lambdasexercises.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayExamples {

    public static double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length); //复制了一份输入数据
        Arrays.parallelPrefix(sums, Double::sum); //执行并行操作，将数组的元素相加
        int start = n - 1;
        return IntStream.range(start, sums.length) // <3>
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) / n; //使用总和减去窗口起始值，然后再除以 n 得到平均值
                })
                .toArray(); //将流转换为数组
    }

    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    public static double[] imperativeInitilize(int size) {
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        return values;
    }


}
