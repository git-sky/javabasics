package cn.com.sky.basics.enums;

import java.util.EnumMap;
import java.util.EnumSet;


/**
 *
 */
public class LightTest {

    // 1.定义枚举类型
    public enum Light {

        // 利用构造函数传参
        RED(1), GREEN(3), YELLOW(2);

        // 定义私有变量
        private int nCode;

        // 构造函数，枚举类型只能为私有
        private Light(int _nCode) {
            this.nCode = _nCode;

        }

        @Override
        public String toString() {
            return String.valueOf(this.nCode);
        }

    }


    public static void main(String[] args) {

        // 1.遍历枚举类型
        System.out.println("====枚举类型的遍历====");
        testTraversalEnum();

        // 2.EnumMap对象的使用
        System.out.println("====EnmuMap对象的使用和遍历====");
        testEnumMap();

        // 3.EnmuSet的使用
        System.out.println("====EnmuSet对象的使用和遍历====");
        testEnumSet();

    }

    /**
     * 枚举类型的遍历
     */
    private static void testTraversalEnum() {
        //values方法，遍历所有的枚举值
        Light[] allLight = Light.values();
        for (Light aLight : allLight) {
            System.out.println("当前灯name：" + aLight.name());
            System.out.println("当前灯ordinal：" + aLight.ordinal());
            System.out.println("当前灯：" + aLight);
        }
    }

    /**
     * 演示EnumMap的使用，EnumMap跟HashMap的使用差不多，只不过key要是枚举类型
     */
    private static void testEnumMap() {
        // 1.定义EnumMap对象，EnumMap对象的构造函数需要参数传入,默认是key的类的类型
        EnumMap<Light, String> enumMap = new EnumMap<>(Light.class);
        enumMap.put(Light.RED, "红灯");
        enumMap.put(Light.GREEN, "绿灯");
        enumMap.put(Light.YELLOW, "黄灯");

        // 2.遍历对象
        for (Light aLight : Light.values()) {
            System.out.println("[key=" + aLight.name() + ",value=" + enumMap.get(aLight) + "]");
        }
    }

    /**
     * 演示EnumSet如何使用，EnumSet是一个抽象类，获取一个类型的枚举类型内容
     * <p>
     * 可以使用allOf方法
     */
    private static void testEnumSet() {
        EnumSet<Light> enumSet = EnumSet.allOf(Light.class);
        for (Light aLight : enumSet) {
            System.out.println("当前EnumSet中数据为：" + aLight);
        }
    }

}