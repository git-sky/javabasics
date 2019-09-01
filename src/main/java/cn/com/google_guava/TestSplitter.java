package cn.com.google_guava;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestSplitter {

    @Test
    public void test() {
        String poiList = ",1,2 ,3 , 4 ,           5,,,,  ,, ,6,";
        List<String> mtIds = Splitter.on(",").trimResults().splitToList(poiList);

//        List<String> mtIds = Arrays.asList(poiList.split(","));

//        List<String> mtIds = Arrays.asList(StringUtils.split(poiList,","));


        System.out.println(mtIds);
        for (String id : mtIds) {
            System.out.println("|" + id + "|");
        }

        List<Long> afterFilterLists = mtIds.stream().filter(s -> !s.isEmpty()).map(s -> Long.valueOf(s)).collect(Collectors.toList());

        System.out.println(mtIds);
        System.out.println(afterFilterLists);

    }


    @Test
    public void teest() {
        String str = "|a | b | c||";
        List<String> aliasList = Splitter.on("|").trimResults().splitToList(str);

        for (String ax : aliasList) {
            System.out.println("=" + ax + "=");
        }
    }

}
