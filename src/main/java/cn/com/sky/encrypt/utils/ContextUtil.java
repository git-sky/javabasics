package cn.com.sky.encrypt.utils;

import java.util.HashMap;
import java.util.Map;


public class ContextUtil {
    private static final ThreadLocal<Map<String, String>> context = new ThreadLocal<>();

    /**
     * <p>getValue.</p>
     *
     * @param key a {@link String} object.
     * @return a {@link String} object.
     */
    public static String getValue(String key) {
        checkInit();
        return context.get().get(key);
    }

    /**
     * <p>setValue.</p>
     *
     * @param key   a {@link String} object.
     * @param value a {@link String} object.
     */
    public static void setValue(String key, String value) {
        checkInit();
        context.get().put(key, value);
    }


    private static void checkInit() {
        if (context.get() == null) {
            context.set(new HashMap<String, String>());
        }
    }
}
