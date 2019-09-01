package cn.com.sky.basics.testfactory;

public class Test {
    public static void main(String args[]) {
        Bird bird = BirdFactory.getBird();
        System.out.print(bird);
    }
}
