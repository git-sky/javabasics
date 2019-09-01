package cn.com.google_guava;

import org.junit.Test;
import com.google.common.base.Objects;

public class TestObjects {

    @Test
    public void equalTest() {
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));
    }

    @Test
    public void equalPersonTest() {
        System.out.println(Objects.equal(new Person("peida", 23), new Person("peida", 23)));
        Person person = new Person("peida", 23);
        System.out.println(Objects.equal(person, person));
    }

    @Test
    public void hashcodeTest() {
        System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a", "b"));
        System.out.println(Objects.hashCode("b", "a"));
        System.out.println(Objects.hashCode("a", "b", "c"));

        Person person = new Person("peida", 23);
        System.out.println(Objects.hashCode(person));
        System.out.println(Objects.hashCode(person));
    }


    class Person {
        public String name;
        public int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}