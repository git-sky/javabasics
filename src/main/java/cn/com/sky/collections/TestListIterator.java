package cn.com.sky.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestListIterator {

    @Test
    public void testFor() {
        List<Person> persons = new ArrayList<>();
        for (Iterator<Person> iterator = persons.iterator(); ; ) {
            //直接获取元素，如果不存在，则会报错 java.util.NoSuchElementException
            Person person = iterator.next();
            System.out.println(person.getName() + "" + person.getAge());
            if (!iterator.hasNext()) {
                break;
            }
        }

    }

    @Test
    public void testWhile() {
        List<Person> persons = new ArrayList<>();
        Iterator<Person> it = persons.iterator();
        //先判断，再获取元素
        while (it.hasNext()) {
            Person person = it.next();
            System.out.println(person.getName() + "" + person.getAge());
        }
    }

    private class Person {
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
