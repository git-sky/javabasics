package cn.com.sky.basics;

/**
 * this是执行方法的对象。不一定是当前类的对象。
 */
public class TestThis {

    public TestThis() {
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        TestThis obj = new TestThis();
        System.out.println(obj.toString());
        obj.print();
    }

    void print() {
        System.out.println(this);
    }

}