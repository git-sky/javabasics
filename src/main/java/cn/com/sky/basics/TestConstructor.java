package cn.com.sky.basics;

/**
 * 构造方法没有返回值
 */
public class TestConstructor {

    private int x;

    public TestConstructor() { // 不带参数的构造方法
        this(1);
    }

    public TestConstructor(int x) { // 带参数的构造方法
        this.x = x;
    }

    public int TestConstructor(int x) { // 不是构造方法
        return x++;
    }

    public void TestConstructor() { // 不是构造方法
        System.out.println("a");
    }

    public static void main(String[] args) {
        TestConstructor tc = new TestConstructor();
        tc.TestConstructor();
    }
}