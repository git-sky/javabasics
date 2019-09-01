package cn.com.sky.basics.inherits;

/**
 * <pre>
 * 结果：
 *
 * 父类的黄色
 * 子类小
 *
 * </pre>
 */
class Fruit {
    static String color = "父类的黄色";
    String size = "父类大";

    static String getFruitColor() {
        return color;
    }

    String getFruitSize() {
        return size;
    }
}

public class TestOverrideApple extends Fruit {
    static String appleColor = "子类的绿色";
    String appleSize = "子类小";

    static String getFruitColor() {
        return appleColor;
    }

    String getFruitSize() {
        return appleSize;
    }

    public static void main(String args[]) {
        Fruit f = new TestOverrideApple();
        //静态方法不被重写
        System.out.println(f.getFruitColor());
        //普通方法重写
        System.out.println(f.getFruitSize());
    }
}