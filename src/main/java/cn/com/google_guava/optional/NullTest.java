package cn.com.google_guava.optional;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

public class NullTest {

    @Test
    public void testNull() {
        int age = 0;
        System.out.println("user age:" + age);

        long money;
        money = 10L;
        System.out.println("user money" + money);

        String name = null;
        System.out.println("user name:" + name);
    }


    @Test
    public void testNullObject() {
        //　　null本身不是对象，也不是Objcet的实例：
        if (null instanceof java.lang.Object) {
            System.out.println("null属于java.lang.Object类型");
        } else {
            System.out.println("null不属于java.lang.Object类型");
        }

    }

    @Test
    public void testMapNull() {

        //null值是一种令人不满的模糊含义。有的时候会产生二义性，这时候我们就很难搞清楚具体的意思。
        // 如果程序返回一个null值，其代表的含义到底是什么，例如：Map.get(key)若返回value值为null，
        // 其代表的含义可能是该键指向的value值是null，亦或者该键在map中并不存在。null值可以表示失败，可以表示成功，几乎可以表示任何情况。
        // 用其它一些值(而不是null值)可以让你的代码表述的含义更清晰。
        Map<String, String> map = Maps.newHashMap();
        System.out.println(map.get("abc"));
        map.put("xyz", null);
        System.out.println(map.get("xyz"));
    }


}
