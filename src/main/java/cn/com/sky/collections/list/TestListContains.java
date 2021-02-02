package cn.com.sky.collections.list;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestListContains {

    @Test
    public void test1() {

        Integer a = new Integer(1000);
        Integer b = new Integer(2000);

        ArrayList<Integer> list = Lists.newArrayList(a, b);

        Integer c = new Integer(2000);

        System.out.println(list.contains(c));

    }

}