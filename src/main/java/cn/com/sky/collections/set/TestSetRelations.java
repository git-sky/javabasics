package cn.com.sky.collections.set;


import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

public class TestSetRelations {


    @Test
    public void equals() {
        Set<String> setA = Sets.newHashSet("a", "b", "c");
        Set<String> setB = Sets.newHashSet("a", "b", "d");

        System.out.println(setA.containsAll(setB));
        System.out.println(setB.containsAll(setA));

        System.out.println(Sets.difference(setA, setB));
        System.out.println(Sets.difference(setB, setA));

    }


    @Test
    public void test() {
        Set<String> setA = Sets.newHashSet("a", "b", "c");
        Set<String> setB = Sets.newHashSet("a", "b", "c");

        System.out.println(eq(setA, setB));
        System.out.println(contains(setA, setB));

    }

    /**
     * 互相包含，则相同
     */
    private boolean eq(Set<String> setA, Set<String> setB) {
        if (setA.containsAll(setB) && setB.containsAll(setA)) {
            return true;
        }
        return false;
    }

    /**
     * A包含B，B不包含A
     */
    private boolean contains(Set<String> setA, Set<String> setB) {
        if (setA.containsAll(setB) && !setB.containsAll(setA)) {
            return true;
        }
        return false;
    }


}