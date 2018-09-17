package cn.com.sky.basics;

/*
 * 参数问题
 */
public class TestParam {

    String s = "good";
    char ch[] = {'a', 'b', 'c'};

    public static void main(String args[]) {
        TestParam ex = new TestParam();
        change(ex.s, ex.ch);
        System.out.println(ex.s + " " + ex.ch[0]+ " " + ex.ch[1]+ " " + ex.ch[2]);
    }

    public static void change(String s, char[] ch) {
        s = "test ok";
        ch[0] = 'g';
    }
}
