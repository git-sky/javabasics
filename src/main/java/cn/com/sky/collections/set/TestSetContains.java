package cn.com.sky.collections.set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

/**
 * Long和Integer是不同类型，同样的数值，也是不相同的。
 */
public class TestSetContains {

    @Test
    public void testContainsString() {

        Set<String> set = Sets.newHashSet();
        set.add(new String("哈哈哈"));

        String s = new String("哈哈哈");

        System.out.println(set.contains(s));
    }

    @Test
    public void testContainsInteger() {
        Set<Integer> set = Sets.newHashSet();
        set.add(new Integer(987654321));
        System.out.println(set.contains(987654321));//true
        System.out.println(set.contains(new Integer(987654321)));//true
        System.out.println(set.contains(987654321L));//false
        System.out.println(set.contains(new Long(987654321)));//false
        System.out.println(set.contains(new Long(987654321L)));//false
    }

    @Test
    public void testEqualsInteger() {
        System.out.println(new Integer(987654321).equals(new Integer(987654321)));//true
        System.out.println(new Integer(987654321).equals(987654321));//true
        System.out.println(new Integer(987654321).equals(987654321L));//false
        System.out.println(new Integer(987654321).equals(new Long(987654321L)));//false
        System.out.println(new Integer(987654321).equals(new Long(987654321)));//false
        System.out.println(new Integer(987654321).equals(new Long(987654321).intValue()));//true
        System.out.println(new Integer(987654321).equals(new Long(987654321).longValue()));//false
    }

    @Test
    public void testContainsLong() {
        Set<Long> set = Sets.newHashSet();
        set.add(new Long(987654321L));
        System.out.println(set.contains(987654321L));//true
        System.out.println(set.contains(new Long(987654321)));//true
        System.out.println(set.contains(new Long(987654321L)));//true
        System.out.println(set.contains(987654321));//false 不加L，默认是int类型，Long和Integer是不同类型。
        System.out.println(set.contains(new Integer(987654321)));//false

    }


}