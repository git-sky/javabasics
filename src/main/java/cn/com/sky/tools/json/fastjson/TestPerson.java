package cn.com.sky.tools.json.fastjson;

import cn.com.sky.tools.json.fastjson.domain.Person;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class TestPerson {

    @Test
    public void test() {
        Person person = new Person(new Long(123456L), "张三", 25, 160, 55.23);

        String jsonString = JSONObject.toJSONString(person);
        System.out.println(jsonString);

        Person p = JSONObject.parseObject(jsonString, Person.class);
        System.out.println(p);
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.getHeight());
        System.out.println(p.getWeight());
    }
}
