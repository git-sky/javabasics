package cn.com.java8lambdasexercises.chapter4.default_method;

public interface Child extends Parent {

    @Override
    public default void welcome() {
        message("Child: Hi!");
    }

}
