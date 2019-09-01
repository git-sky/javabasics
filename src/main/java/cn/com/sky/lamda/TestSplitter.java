package cn.com.sky.lamda;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestSplitter {

    @Test
    public void test() {


        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("");
        list.add("3");
        list.add("4");
        list.add("5");

        System.out.println("source=" + JSON.toJSON(list));


        long count = list.stream().filter(s -> !s.isEmpty()).count();

        System.out.println("count=" + count);


        List<Long> afterFilterLists = list.stream().filter(s -> !s.isEmpty()).map(s -> Long.valueOf(s)).collect(Collectors.toList());

        System.out.println("afterFilterLists=" + afterFilterLists);

    }


}
