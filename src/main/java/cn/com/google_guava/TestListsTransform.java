package cn.com.google_guava;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class TestListsTransform {


    /**
     * Lists.transform使用可能遇到的问题，已经转换后得到的list会受到源list的改动而改变。
     */
    @Test
    public void listToList() {
        //源list
        List<Result> listResults = Lists.newArrayList(new Result(1, "test1"), new Result(2, "test2"), new Result(3, "test3"));
        //转换为目标list
        List<String> strLists = Lists.transform(listResults, new Function<Result, String>() {
            @Override
            public String apply(Result result) {
                return result.getName();
            }
        });
        //转换后目标list打印
        System.out.println("strLists 1 values:");
        for (String str : strLists) {
            System.out.println(str + ";");
        }
        //修改源list的值
        for (Result result : listResults) {
            result.setName("reset");
        }
        //再次打印目标list
        System.out.println("strLists 2 values:");
        for (String str : strLists) {
            System.out.println(str + ";");
        }
    }


    @Test
    public void test2() {

        List<Long> alist = Lists.newArrayList();
        alist.add(9999999999L);
        alist.add(1L);
        alist.add(2L);


        List<Integer> blist = Lists.transform(alist, new Function<Long, Integer>() {
            @Override
            public Integer apply(Long poiLong) {
                return poiLong.intValue();
            }
        });

        System.out.println(alist);

        System.out.println(blist);
    }


}
