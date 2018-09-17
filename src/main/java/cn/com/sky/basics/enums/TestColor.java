package cn.com.sky.basics.enums;

public class TestColor {

    public enum Color {
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

        private String name;
        private int index;

        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }

        @Override
        public String toString() {
            return this.index + "_" + this.name;
        }
    }

    public static void main(String[] args) {
        System.out.println(Color.RED.toString());
        System.out.println(Color.RED == Color.RED);
    }
}