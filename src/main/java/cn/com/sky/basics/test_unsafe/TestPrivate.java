package cn.com.sky.basics.test_unsafe;


import java.io.Serializable;
import java.lang.reflect.Field;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class TestPrivate implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public static void main(String[] args) throws NoSuchFieldException, SecurityException {

        Guard guard = new Guard();
        guard.giveAccess();   // false, no access
        System.out.println(guard.giveAccess());

        // bypass
        Field f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard, unsafe.objectFieldOffset(f), 42); // memory corruption

        guard.giveAccess(); // true, access granted
        System.out.println(guard.giveAccess());

    }

}


class Guard {
    private int ACCESS_ALLOWED = 1;

    public boolean giveAccess() {
        return 42 == ACCESS_ALLOWED;
    }
}