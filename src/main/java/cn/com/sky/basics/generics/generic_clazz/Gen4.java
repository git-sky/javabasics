package cn.com.sky.basics.generics.generic_clazz;

/**
 * 泛型类
 */
public class Gen4<T, K> {

    private T t;
    private K k;

    public Gen4(T t) {
        this.t = t;
    }

    public Gen4(T t, K k) {
        this.t = t;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }
}