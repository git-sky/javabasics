package cn.com.google_guava;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestListsPartition {


    @Test
    public void test1() {

        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(2L);
//        list.add(3L);
//        list.add(4L);
//        list.add(5L);
//        list.add(6L);
//        list.add(7L);
//        list.add(8L);
//        list.add(null);

        List<List<Long>> groupList = Lists.partition(list, 5);
        for (List<Long> subList : groupList) {
            System.out.println("=" + subList);
        }
    }


    @Test
    public void test2() {

        Set<Long> set = new HashSet<>();
//        set.add(1L);
//        set.add(2L);
//        set.add(3L);
//        set.add(4L);
//        set.add(5L);
//        set.add(6L);


        List<List<Long>> groupList = Lists.partition(Lists.newArrayList(set), 5);
        for (List<Long> subList : groupList) {
            System.out.println("=" + subList);
        }
    }


    @Test
    public void tet() {

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(5L);
        list.add(6L);
        list.add(7L);
        list.add(8L);
        list.add(null);

        List<List<Long>> originalPageList = Lists.partition(list, 3);


        originalPageList.forEach(poiids -> {
            System.out.println(poiids);
            System.out.println("===");
        });

//        List<String> pageList = Lists.transform(originalPageList, new Function<List<Long>, String>() {
//            @Override
//            public String apply(List<Long> list) {
//                final StringBuffer pageSkuIds = new StringBuffer();
//                for (Long info : list) {
//                    pageSkuIds.append("AA_").append(info).append(",");
//                }
//                return pageSkuIds.toString();
//            }
//        });
//        System.out.println(pageList.toString());


//        List<List<Long>> lists = Lists.partition(poiIdList, 10);
//        lists.forEach(poiids -> {
//            poiKeyWordSearchGetPoiIdProducer.sendPoiIdMsg(poiids);
//        });
    }


}
