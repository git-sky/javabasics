package cn.com.sky.collections.map;


import cn.com.json_tools.jackson.JsonUtils;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * list转map
 */
public class TestHashMapForList2Map2 {

    @Test
    public void test1() {
        List<PersonInfo> list = init();
        System.out.println(JsonUtils.object2Json(list));

    }

    @Test
    public void test2() {
        List<PersonInfo> list = init();
        System.out.println(JsonUtils.object2Json(list));

        // 多字段分组统计
        Map<String, List<PersonInfo>> nameRoomsMap = list.stream().collect(Collectors.groupingBy(e -> fetchGroupKey(e)));
        System.out.println(JsonUtils.object2Json(nameRoomsMap));

        //去重后的
        list = nameRoomsMap.values().stream()
                .map(sameNameList -> sameNameList.stream()
                        //同名房型会保留修改时间最近的
                        .max((o1, o2) -> {
                            if (o1.getBirth() == null) {
                                return -1;
                            }
                            if (o2.getBirth() == null) {
                                return 1;
                            }
                            return o1.getBirth().getTime() - o2.getBirth().getTime() > 0 ? 1 : -1;
                        })
                        .get())
                .collect(Collectors.toList());

        System.out.println(JsonUtils.object2Json(list));
    }

    private String fetchGroupKey(PersonInfo personInfo) {
        return personInfo.getName() + "#" + personInfo.getAddr();
    }


    @Test
    public void test() {

        List<PersonInfo> list = init();
        System.out.println(JsonUtils.object2Json(list));


        //按房型名称聚合
        Map<String, List<PersonInfo>> nameRoomsMap = list.stream()
                .collect(Collectors.groupingBy(PersonInfo::getName));
        System.out.println(JsonUtils.object2Json(nameRoomsMap));


        //去重后的
        List<PersonInfo> distinctRoom = nameRoomsMap.values().stream()
                .map(sameNameList -> sameNameList.stream()
                        //同名房型会保留修改时间最近的
                        .max((o1, o2) -> {
                            if (o1.getBirth() == null) {
                                return -1;
                            }
                            if (o2.getBirth() == null) {
                                return 1;
                            }
                            return o1.getBirth().getTime() - o2.getBirth().getTime() > 0 ? 1 : -1;
                        })
                        .get())
                .collect(Collectors.toList());

        System.out.println(JsonUtils.object2Json(distinctRoom));
    }

    private List<PersonInfo> init() {
        List<PersonInfo> list = Lists.newArrayList();
        list.add(new PersonInfo("zhangsan", "bj", 11, new Date()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(new PersonInfo("zhangsan", "hb", 12, new Date()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(new PersonInfo("zhangsan", "sd", 13, new Date()));

        list.add(new PersonInfo("lisi", "bj", 11, new Date()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(new PersonInfo("lisi", "hb", 12, new Date()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(new PersonInfo("lisi", "sd", 13, new Date()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(new PersonInfo("lisi", "sd", 14, new Date()));
        return list;
    }

    class PersonInfo {
        private String name;
        private String addr;
        private Integer age;
        private Date birth;

        public PersonInfo(String name, String addr, Integer age, Date birth) {
            this.name = name;
            this.addr = addr;
            this.age = age;
            this.birth = birth;
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

        public Date getBirth() {
            return birth;
        }

        public void setBirth(Date birth) {
            this.birth = birth;
        }


    }

}