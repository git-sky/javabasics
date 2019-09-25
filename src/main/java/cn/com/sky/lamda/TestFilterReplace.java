package cn.com.sky.lamda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class TestFilterReplace {

    @Test
    public void test() {
        List<Map<String, Object>> listMap = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            if (i % 2 == 0) {
                map.put("key", 0);
            } else {
                map.put("key", i);
            }
            listMap.add(map);
        }

        for (Map<String, Object> map : listMap) {
            System.out.println("old key:" + map.get("key"));
        }

        System.out.println("------------------------------");

        //使用filter替换值
        listMap.stream().filter(e -> {
            // 将value为0全部替换为true
            if (Integer.parseInt(e.get("key").toString()) == 0) {
                e.put("key", true);
            }
            return true;
        }).collect(Collectors.toList());


        System.out.println(listMap);

        System.out.println("------------------------------");

        Iterator<Map<String, Object>> it = listMap.iterator();
        while (it.hasNext()) {
            Map<String, Object> map = it.next();
            System.out.println("filter key:" + map.get("key"));
        }
    }

}
