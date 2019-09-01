package cn.com.sky.basics.generics;


public class TestTwoGeneric {

    public static void main(String args[]) {
        Notepad<String, Integer> pad = null; // 定义两个泛型类型的对象
        pad = new Notepad<String, Integer>(); // key为String，value为Integer
        pad.setKey("汤姆");
        pad.setValue(20);
        System.out.print("姓名；" + pad.getKey());
        System.out.print("，年龄；" + pad.getValue());

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
