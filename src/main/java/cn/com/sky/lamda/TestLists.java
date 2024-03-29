package cn.com.sky.lamda;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestLists {
    public static void main(String[] args) throws Exception {

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        list.add(4L);
        list.add(5L);
//        list.add(6L);

//        list.add(7L);
//        list.add(8L);
//        list.add(9L);

        List<List<Long>> originalPageList = Lists.partition(list, 3);

        for (List<Long> longList : originalPageList) {
            for (Long s : longList) {
                System.out.println(s);
            }
            System.out.println("---------");
        }

        List<String> pageList = Lists.transform(originalPageList, new Function<List<Long>, String>() {
            @Override
            public String apply(List<Long> list) {
                final StringBuffer pageSkuIds = new StringBuffer();
                for (Long info : list) {
                    pageSkuIds.append("AA_").append(info).append(",");
                }
                return pageSkuIds.toString();
            }
        });
        System.out.println(pageList.toString());
    }
}