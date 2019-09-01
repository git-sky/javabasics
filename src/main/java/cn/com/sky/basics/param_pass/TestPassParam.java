package cn.com.sky.basics.param_pass;

/**
 * 值传递
 * <p>
 * String不会修改原始值，数组会修改原始值。
 */
public class TestPassParam {

    String s = "good";
    char[] ch = {'a', 'b', 'c'};

    public static void main(String args[]) {
        TestPassParam ex = new TestPassParam();
        change(ex.s, ex.ch);
        System.out.println(ex.s + " " + ex.ch[0] + " " + ex.ch[1] + " " + ex.ch[2]);
    }

    public static void change(String s, char[] ch) {
        s = "test ok";
        ch[0] = 'g';
    }
}
