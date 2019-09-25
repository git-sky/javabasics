package cn.com.sky.lamda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * map方法，类型转换
 */
public class TestMap {

    @Test
    public void test_NullPointerException() {
        List<Long> ticketIds = null;
        System.out.println(ticketIds);

        //guava方式，java.lang.NullPointerException
        List<Integer> ticketIdsInteger = Lists.transform(ticketIds, Long::intValue);
        System.out.println(ticketIdsInteger);

        //jdk8方式，java.lang.NullPointerException
        List<Integer> ticketIdsInteger2 = ticketIds.stream().map(Long::intValue).collect(Collectors.toList());
        System.out.println(ticketIdsInteger2);
    }


    @Test
    public void test_map() {
        List<Long> ticketIds = Lists.newArrayList(3L, 1L, 5L, 2L, 9L);
        System.out.println(ticketIds);

        //guava方式，Long转为Integer类型
        List<Integer> ticketIdsInteger = Lists.transform(ticketIds, Long::intValue);
        System.out.println(ticketIdsInteger);

        //jdk8方式，Long转为Integer类型
        List<Integer> ticketIdsInteger2 = ticketIds.stream().map(Long::intValue).collect(Collectors.toList());
        System.out.println(ticketIdsInteger2);
    }


    @Test
    public void test_map_collect() {
        List<Integer> ids = Lists.newArrayList(1, 2, 3, 4, 5, 6, 6, 6);
        System.out.println(ids);

        List<Long> idsLong = ids.stream().map(Long::valueOf).collect(Collectors.toList());
        System.out.println(idsLong);

        Set<Long> idsSet = ids.stream().map(Long::valueOf).collect(Collectors.toSet());
        System.out.println(idsSet);
    }

}