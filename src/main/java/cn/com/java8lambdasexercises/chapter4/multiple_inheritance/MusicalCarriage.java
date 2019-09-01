package cn.com.java8lambdasexercises.chapter4.multiple_inheritance;


/**
 * 多重继承
 */
public class MusicalCarriage implements Carriage, Jukebox {


    //如果不实习rock方法，javac 并不明确应该继承哪个接口中的方法，因此编译器会报错。
    //在类中实现 rock 方法就能解决这个问题。
    @Override
    public String rock() {
        //用来指明使用接口 Carriage 中定义的默认方法。
        return Carriage.super.rock();
    }

}
