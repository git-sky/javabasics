package cn.com.sky.basics.test_unsafe;

import static sun.misc.Unsafe.getUnsafe;

/**
 * Big Arrays
 * <p>
 * As you know Integer.MAX_VALUE constant is a max size of java array. Using direct memory
 * allocation we can create arrays with size limited by only heap size. In fact, this technique uses
 * off-heap memory and partially available in java.nio package.
 * <p>
 * Memory allocated this way not located in the heap and not under GC management, so take care of it
 * using Unsafe.freeMemory(). It also does not perform any boundary checks, so any illegal access
 * may cause JVM crash.
 */
public class TestBigArray {

    public static void main(String[] args) {

        long sum = 0;

        long SUPER_SIZE = (long) Integer.MAX_VALUE * 2;
        SuperArray array = new SuperArray(SUPER_SIZE);

        System.out.println("Array size:" + array.size()); // 4294967294

        for (int i = 0; i < 100; i++) {
            array.set((long) Integer.MAX_VALUE + i, (byte) 3);
            sum += array.get((long) Integer.MAX_VALUE + i);
        }

        System.out.println("Sum of 100 elements:" + sum); // 300

    }

}

@SuppressWarnings("restriction")
class SuperArray {
    private final static int BYTE = 1;

    private long size;
    private long address;

    public SuperArray(long size) {
        this.size = size;
        address = getUnsafe().allocateMemory(size * BYTE);
    }

    public void set(long i, byte value) {
        getUnsafe().putByte(address + i * BYTE, value);
    }

    public int get(long idx) {
        return getUnsafe().getByte(address + idx * BYTE);
    }

    public long size() {
        return size;
    }
}