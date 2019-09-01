package cn.com.sky.lamda;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class TestMapLamda {

    @Test
    public void removeIf() {

        Map<String, Integer> map = new HashMap<>();
        map.put("vic", 25);
        map.put("abc", 28);
        map.put("older", 35);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("--------------------------");
            System.out.println("Key:" + entry.getKey());
            System.out.println("Value:" + entry.getValue());
        }

        map.entrySet().removeIf(m -> m.getValue() > 30 || m.getKey() == "abc");

        System.out.println("############################");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key:" + entry.getKey());
            System.out.println("Value:" + entry.getValue());
        }

    }

}
