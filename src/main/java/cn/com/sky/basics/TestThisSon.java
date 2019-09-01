package cn.com.sky.basics;


/**
 * <pre>
 *
 * cn.com.sky.basics.TestThisSon@7cc355be
 * cn.com.sky.basics.TestThisSon@7cc355be
 * cn.com.sky.basics.TestThisSon@7cc355be
 * cn.com.sky.basics.TestThisSon@7cc355be
 *
 * </pre>
 */
public class TestThisSon extends TestThis {

    public static void main(String[] args) {
        TestThisSon obj = new TestThisSon();
        System.out.println(obj.toString());
        obj.print();
    }

    public TestThisSon() {
//        super(); 默认会调用super();
        System.out.println(this.toString());
    }

}
