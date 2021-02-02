package cn.com.sky.lamda;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class TestStreamList {


    public static void main(String[] args) {
        List<Integer> integerList = Lists.newArrayList(1, 2, 3, 4, 5);
        for (Integer i : integerList) {
            System.out.println("i=" + i);
        }

        List<String> stringList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(integerList)) {
            stringList = integerList.stream().map(e -> String.valueOf(e)).collect(Collectors.toList());
        }

        for (String s : stringList) {
            System.out.println("s=" + s);
        }

        for (Integer i : integerList) {
            System.out.println("i=" + i);
        }

        List<String> stringList2 = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(integerList)) {
            stringList2 = integerList.stream().map(e -> String.valueOf(e)).collect(Collectors.toList());
        }

        for (String s : stringList2) {
            System.out.println("s=" + s);
        }

    }
}