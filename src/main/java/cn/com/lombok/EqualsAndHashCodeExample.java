package cn.com.lombok;

import lombok.EqualsAndHashCode;

/**
 * <pre>
 *
 *     @EqualsAndHashCode
 * 默认情况下，会使用所有非静态（non-static）和非瞬态（non-transient）属性来生成equals和hasCode，也能通过exclude注解来排除一些属性。
 *
 *
 * </pre>
 */

@EqualsAndHashCode(exclude = {"id", "shape"})
public class EqualsAndHashCodeExample {
    private transient int transientVar = 10;
    private String name;
    private double score;
    private Shape shape = new Square(5, 10);
    private String[] tags;
    private int id;

    public String getName() {
        return this.name;
    }

    @EqualsAndHashCode(callSuper = true)
    public static class Square extends Shape {
        private final int width, height;

        public Square(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        System.out.println(new EqualsAndHashCodeExample());
    }
}