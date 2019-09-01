package cn.com.java8lambdasexercises.chapter4.default_method;

public interface Parent {

    public void message(String body);

    public default void welcome() {
        message("Parent: Hi!");
    }

    public String getLastMessage();

}
