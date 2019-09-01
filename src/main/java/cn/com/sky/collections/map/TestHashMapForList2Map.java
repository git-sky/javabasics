package cn.com.sky.collections.map;


import cn.com.sky.tools.json.jackson.JsonUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * list转map
 */
public class TestHashMapForList2Map {

    @Test
    public void test() {
        List<PersonInfo> list = init();

        System.out.println(JsonUtils.object2Json(list));

        System.out.println("==========================================");


//        Map<String, List<PersonInfo>> relationMap = getMap(list);

//        Map<String, List<PersonInfo>> relationMap = getMapOrDefault(list);

//        Map<String, List<PersonInfo>> relationMap = groupByNormal(list);

        Map<String, List<PersonInfo>> relationMap = groupByNormal2(list);


//        Map<String, List<PersonInfo>> relationMap = getMapByLamda(list);


        System.out.println(JsonUtils.object2Json(list));
        System.out.println("==========================================");

        System.out.println(JsonUtils.object2Json(relationMap));

        System.out.println("==========================================");

        for (Map.Entry<String, List<PersonInfo>> entry : relationMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private List<PersonInfo> init() {
        List<PersonInfo> list = Lists.newArrayList();
        list.add(new PersonInfo("zhangsan", "bj", 11));
        list.add(new PersonInfo("zhangsan", "hb", 12));
        list.add(new PersonInfo("zhangsan", "sd", 13));

        list.add(new PersonInfo("lisi", "bj", 11));
        list.add(new PersonInfo("lisi", "hb", 12));
        list.add(new PersonInfo("lisi", "sd", 13));
        list.add(new PersonInfo("lisi", "sd", 14));
        return list;
    }

    /**
     * 方式1：list 转 map
     */
    private Map<String, List<PersonInfo>> getMap(List<PersonInfo> list) {
        Map<String, List<PersonInfo>> relationMap = Maps.newHashMap();
        for (PersonInfo personInfo : list) {
            String key = personInfo.getName();
            if (relationMap.containsKey(key)) {
                List<PersonInfo> results = relationMap.get(key);
                results.add(personInfo);
            } else {
                List<PersonInfo> results = Lists.newArrayList();
                results.add(personInfo);
                relationMap.put(personInfo.getName(), results);
            }
        }
        return relationMap;
    }

    /**
     * 方式2： list 转 map
     */
    private Map<String, List<PersonInfo>> getMapOrDefault(List<PersonInfo> list) {
        Map<String, List<PersonInfo>> relationMap = Maps.newHashMap();
        for (PersonInfo personInfo : list) {
            String key = personInfo.getName();
            List<PersonInfo> results = relationMap.getOrDefault(key, Lists.newArrayList());
            results.add(personInfo);
            relationMap.put(key, results);
        }
        return relationMap;
    }

    /**
     * 方式3： list 转 map
     */
    private Map<String, List<PersonInfo>> groupByNormal(List<PersonInfo> list) {
        Map<String, List<PersonInfo>> relationMap = new HashMap<>();
        for (PersonInfo personInfo : list) {
            List<PersonInfo> infos = relationMap.get(personInfo.getName());
            if (null == infos) {
                infos = new ArrayList<>();
                relationMap.put(personInfo.getName(), infos);
            }
            infos.add(personInfo);
        }
        return relationMap;
    }

    /**
     * 方式4： list 转 map
     */
    private Map<String, List<PersonInfo>> groupByNormal2(List<PersonInfo> list) {
        Map<String, List<PersonInfo>> relationMap = new HashMap<>();
        for (PersonInfo personInfo : list) {
            List<PersonInfo> infos = relationMap.computeIfAbsent(personInfo.getName(), k -> new ArrayList<>());
            infos.add(personInfo);
        }
        return relationMap;
    }


    /**
     * 方式5：lamda方式(groupingBy)
     */
    private Map<String, List<PersonInfo>> getMapByLamda(List<PersonInfo> list) {
        Map<String, List<PersonInfo>> map = list.stream().collect(Collectors.groupingBy(PersonInfo::getName));
        return map;
    }


    private Map<String, PersonInfo> getMapsByLamda(List<PersonInfo> list) {
        //存在Duplicate key问题
        Map<String, PersonInfo> m1 = list.stream().collect(Collectors.toMap(PersonInfo::getName, java.util.function.Function.identity()));

        //解决Duplicate key问题
        Map<String, PersonInfo> m2 = list.stream().collect(Collectors.toMap(PersonInfo::getName, java.util.function.Function.identity(), (key1, key2) -> key1));

        Map<String, String> m3 = list.stream().collect(Collectors.toMap(PersonInfo::getName, PersonInfo::getAddr, (key1, key2) -> key2));

        System.out.println(m1);

        System.out.println(m2);

        System.out.println(m3);

        return m2;
    }

    class PersonInfo {
        private String name;
        private String addr;
        private Integer age;

        public PersonInfo(String name, String addr, Integer age) {
            this.name = name;
            this.addr = addr;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "PersonInfo{" +
                    "name='" + name + '\'' +
                    ", addr='" + addr + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}