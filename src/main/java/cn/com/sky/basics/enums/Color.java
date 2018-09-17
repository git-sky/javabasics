package cn.com.sky.basics.enums;

/**
 * 所有的枚举都继承自java.lang.Enum类。由于Java不支持多继承，所以枚举对象不能再继承其他类。
 */
public enum Color {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    private String name;
    private int index;

    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
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
        for (Color c : Color.values()) {
            System.out.println(c.getIndex() + ":" + c.getName());

            /**
             * Enum类中equals方法实现： public final boolean equals(Object other) { return this==other; }
             */
            if (c == Color.BLANK) {
                System.out.println("c == Color.BLANK");
            }
            if (c.equals(Color.BLANK)) {
                System.out.println("c.equals(Color.BLANK)");
            }
        }

    }
}