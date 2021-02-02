package cn.com.sky.basics.test_create_object;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * <pre>
 * 通过unsafe创建User对象
 *
 * 不会调用构造方法
 *
 * </pre>
 */
public class TestUnsafe {

    private static final Unsafe unsafe;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) throws InstantiationException {
        User user = (User) unsafe.allocateInstance(User.class);
        System.out.println(user);

    }

}
