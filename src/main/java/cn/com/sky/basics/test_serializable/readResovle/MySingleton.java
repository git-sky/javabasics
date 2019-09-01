package cn.com.sky.basics.test_serializable.readResovle;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 *
 * 防止反序列化导致的多例。
 *
 * 原理： 当从I/O流中读取对象时，readResolve()方法会被调用,用readResolve()中返回的对象直接替换在反序列化过程中创建的对象，而被创建的对象则会被垃圾回收掉。
 */
public final class MySingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    private MySingleton() {
    }

    private static final MySingleton INSTANCE = new MySingleton();

    public static MySingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 这样当JVM从内存中反序列化地"组装"一个新对象时,就会自动调用这个 readResolve方法来返回我们指定好的对象了, 单例规则也就得到了保证.
     */
    private Object readResolve() throws ObjectStreamException {
        // instead of the object we're on,
        // return the class variable INSTANCE
        return INSTANCE;
    }
}