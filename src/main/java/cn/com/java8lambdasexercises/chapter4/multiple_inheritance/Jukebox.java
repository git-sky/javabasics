package cn.com.java8lambdasexercises.chapter4.multiple_inheritance;

public interface Jukebox {

    public default String rock() {
        return "... all over the world!";
    }

}