package cn.com.sky.basics.inherits;

/**
 * <pre>
 * 结果：
 *
 * 子类的绿色
 * 子类小
 *
 * </pre>
 */
class Fruit2 {
    static String color = "父类的黄色";
    String size = "父类大";

    static String getFruitColor() {
        return color;
    }

    String getFruitSize() {
        return size;
    }
}

public class TestOverrideApple2 extends Fruit2 {
    static String appleColor = "子类的绿色";
    String appleSize = "子类小";

    static String getFruitColor() {
        return appleColor;
    }

    String getFruitSize() {
        return appleSize;
    }

    public static void main(String args[]) {
        TestOverrideApple2 f = new TestOverrideApple2();
        System.out.println(f.getFruitColor());
        System.out.println(f.getFruitSize());
    }
}
