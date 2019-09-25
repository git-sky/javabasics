package cn.com.sky.lamda;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TestFilter2 {

    @Test
    public void test() {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add(null);
        list.add("6");
        System.out.println("source=" + JSON.toJSON(list));
        System.out.println(list);

//        long count = list.stream().filter(s -> !s.isEmpty()).count();
//        System.out.println("count=" + count);

        long count2 = list.stream().filter(s -> StringUtils.isNotBlank(s)).count();
        System.out.println("count2=" + count2);


        List<Long> afterFilterLists = list.stream().filter(s -> StringUtils.isNotBlank(s)).map(s -> Long.valueOf(s)).collect(Collectors.toList());
        System.out.println("afterFilterLists=" + afterFilterLists);

    }


}
