package cn.com.sky.basics.generics.two_generic_clazz;

/**
 * 两个泛型类型
 */
public class TestTwoGeneric {

    public static void main(String args[]) {

        //---- demo1 ----//
        // 定义两个泛型类型的对象
        Notepad<String, Integer> pad = null;
        // key为String，value为Integer
        pad = new Notepad<String, Integer>();
        pad.setKey("汤姆");
        pad.setValue(20);
        System.out.println("姓名: " + pad.getKey());
        System.out.println("年龄: " + pad.getValue());

        System.out.println("----------------");


        //---- demo2 ----//
        // 定义两个泛型类型的对象
        Notepad<String, String> pad2 = null;
        // key为String，value为String
        pad2 = new Notepad<String, String>();
        pad2.setKey("汤姆");
        pad2.setValue("xyz");
        System.out.println("姓名: " + pad2.getKey());
        System.out.println("年龄: " + pad2.getValue());


        System.out.println("----------------");


        //---- demo3 ----//
        // 定义两个泛型类型的对象
        Notepad<Integer, Integer> pad3 = null;
        // key为String，value为String
        pad3 = new Notepad<Integer, Integer>();
        pad3.setKey(123);
        pad3.setValue(456);
        System.out.println("姓名: " + pad3.getKey());
        System.out.println("年龄: " + pad3.getValue());


    }

}

class Notepad<K, V> { // 此处指定了两个泛型类型
    private K key; // 此变量的类型由外部决定
    private V value; // 此变量的类型由外部决定

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
