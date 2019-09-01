package cn.com.sky.tools.json.jackson;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class TestJson {

    /**
     * json转为list
     */
    @Test
    public void testJson2List() {
        String json = "[1,2,3,4,5]";

        List<Long> jsonList = JsonUtils.json2Object(json, new TypeReference<List<Long>>() {
        });
        System.out.println(jsonList);

        for (Long a : jsonList) {
            System.out.println(a);
        }
    }

    @Test
    public void testJson2List2() {
        String json = "[1,2,3,4,5]";

        List<Integer> jsonList = JsonUtils.json2Object(json, List.class);
        System.out.println(jsonList);

        for (Integer a : jsonList) {
            System.out.println(a);
        }
    }

    /**
     * json转为model
     */
    @Test
    public void testJson2Model() {
        String pJson = "{\"id\":1,\"no\":1234567890123,\"name\":\"zhangsan\"}";
        Person person = JsonUtils.json2Object(pJson, new TypeReference<Person>() {
        });

        System.out.println(person);
        System.out.println(person.getId());
        System.out.println(person.getNo());
        System.out.println(person.getName());
    }


    @Test
    public void testJson2Model2() {
        String pJson = "{\"id\":1,\"no\":1234567890123,\"name\":\"zhangsan\"}";
        Person person = JsonUtils.json2Object(pJson, Person.class);

        System.out.println(person);
        System.out.println(person.getId());
        System.out.println(person.getNo());
        System.out.println(person.getName());
    }


    @Test
    public void testJson2ModelList() {
        String pJson = "[[{\"id\":1,\"no\":1234567890123,\"name\":\"zhangsan\"}]]";
        List<Person> person = JsonUtils.json2Object(pJson, List.class);

        System.out.println(person);
//        System.out.println(person.getId());
//        System.out.println(person.getNo());
//        System.out.println(person.getName());

        List<List<Person>> jsonList = JsonUtils.json2Object(pJson, new TypeReference<List<List<Person>>>() {
        });

        System.out.println(jsonList);
        for (List<Person> personList : jsonList) {
            System.out.println(personList);
            for (Person p : personList) {
                System.out.println(p);
                System.out.println(p.getName());
            }
        }
    }

    @Test
    public void testJson2ModelList2() {
        String pJson = "[[{\"id\":1,\"no\":1234567890123,\"name\":\"zhangsan\"}]]";

        List<List<Person>> jsonList = JsonUtils.json2DList(pJson, Person.class);

        System.out.println(jsonList);
        for (List<Person> personList : jsonList) {
            System.out.println(personList);
            for (Person p : personList) {
                System.out.println(p);
                System.out.println(p.getName());
            }
        }
    }


    @Test
    public void testJson2Map() {
        String pJson = "{\"id\":1,\"no\":1234567890123,\"name\":\"zhangsan\"}";

        Map<String, String> map = JsonUtils.json2Object(pJson, new TypeReference<Map<String, String>>() {
        });

        System.out.println(map);
        System.out.println(map.get("id"));
        System.out.println(map.get("no"));
        System.out.println(map.get("name"));

    }


}