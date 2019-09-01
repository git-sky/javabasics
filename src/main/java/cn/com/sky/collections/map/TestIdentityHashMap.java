package cn.com.sky.collections.map;

import java.util.HashMap;
import java.util.IdentityHashMap;

import org.junit.Test;

/**
 * <pre>
 *
 * IdentityHashMap有其特殊用途，比如序列化或者深度复制。或者记录对象代理。
 *
 * 对象比较时，使用==，而不是equals。
 */
public class TestIdentityHashMap {

    @Test
    public void get() {
        IdentityHashMap<String, Integer> ihm = new IdentityHashMap<String, Integer>();

        // 下面代码向IdentityHashMap对象添加多个key-value对
        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 78);
        ihm.put(new String("语文"), 33);
        ihm.put(new String("语文"), 33);
        ihm.put(new String("语文"), 33);

        // 下面代码只会向IdentityHashMap对象添加一个key-value对
        ihm.put("java", 93);
        ihm.put("java", 98);
        ihm.put("java", 66);

        System.out.println(ihm);

    }

    @Test
    public void get2() {

        HashMap<String, Integer> ihm = new HashMap<String, Integer>();

        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 78);
        ihm.put(new String("语文"), 33);
        ihm.put(new String("语文"), 33);
        ihm.put(new String("语文"), 33);

        ihm.put("java", 93);
        ihm.put("java", 98);
        ihm.put("java", 66);
        System.out.println(ihm);
    }

    @Test
    public void get3() {

        // identityHashCode是根据对象的地址计算得到的，所以任何两个不同的对象的
        // identityHashCode值总是不相等

        String a = new String("abc");
        String b = new String("abc");
        String c = new String("abc");

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));


        System.out.println(System.identityHashCode("java"));
        System.out.println(System.identityHashCode("java"));


        System.out.println(System.identityHashCode("x"));
        System.out.println(System.identityHashCode("x"));


    }

    @Test
    public void get4() {

        // System 的 identityHashCode 与  Object 的 hashCode() 方法一样

        HashCodeClazz a = new HashCodeClazz();
        HashCodeClazz b = new HashCodeClazz();
        HashCodeClazz c = new HashCodeClazz();

        System.out.println("hashCode:" + a.hashCode() + ",identityHashCode:" + System.identityHashCode(a));
        System.out.println("hashCode:" + b.hashCode() + ",identityHashCode:" + System.identityHashCode(b));
        System.out.println("hashCode:" + c.hashCode() + ",identityHashCode:" + System.identityHashCode(c));

    }

    class HashCodeClazz {

    }
}


