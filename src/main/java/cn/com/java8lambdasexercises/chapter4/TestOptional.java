package cn.com.java8lambdasexercises.chapter4;


import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;

public class TestOptional {

    @Test
    public void test() {
        Optional<String> a = Optional.of("a");
        Assert.assertEquals("a", a.get());
        Assert.assertTrue(a.isPresent());
    }

    @Test
    public void test2() {
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);

        Assert.assertFalse(emptyOptional.isPresent());

        Assert.assertTrue(emptyOptional.equals(alsoEmpty));
        Assert.assertTrue(emptyOptional == alsoEmpty);


        Assert.assertEquals("b", emptyOptional.orElse("b"));
        Assert.assertEquals("c", emptyOptional.orElseGet(() -> "c"));
    }


    @Test
    public void test3() {
        Optional emptyOptional = Optional.empty();
        Assert.assertEquals("b", emptyOptional.orElse("b"));
        Assert.assertEquals("c", emptyOptional.orElseGet(() -> "c"));
    }
}