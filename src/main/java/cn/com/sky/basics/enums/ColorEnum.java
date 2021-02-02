package cn.com.sky.basics.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有的枚举都继承自java.lang.Enum类。由于Java不支持多继承，所以枚举对象不能再继承其他类。
 */
public enum ColorEnum {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    private String name;
    private int index;

    ColorEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    private static final Map<Integer, ColorEnum> map = new HashMap<>();

    static {
        for (ColorEnum value : ColorEnum.values()) {
            map.put(value.getIndex(), value);
        }
    }

    public static ColorEnum getByIndex(int index) {
        return map.get(index);
    }

    public static String getName(int index) {
        for (ColorEnum c : ColorEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public static ColorEnum get(String name) {
        for (ColorEnum color : values()) {
            if (StringUtils.equals(color.getName(), name)) {
                return color;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        // System.out.println(getName(1));
        for (ColorEnum c : ColorEnum.values()) {
            System.out.println(c.getIndex() + ":" + c.getName());

            /**
             * Enum类中equals方法实现： public final boolean equals(Object other) { return this==other; }
             *
             * 判断枚举相等使用"=="号。
             */
            if (c == ColorEnum.BLANK) {
                System.out.println("c == Color.BLANK");
            }
            if (c.equals(ColorEnum.BLANK)) {
                System.out.println("c.equals(Color.BLANK)");
            }


            System.out.println(c.toString());
        }

        System.out.println("==================================");
        for (ColorEnum color : ColorEnum.values()) {
            System.out.println("color=" + color);
            System.out.println("color.getName=" + color.getName());
            ColorEnum color1 = ColorEnum.get(color.getName());
            System.out.println("color1=" + color1);
        }

    }
}