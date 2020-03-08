package cn.com.sky.encrypt.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class InetUtils {
    private InetUtils() {
    }

    /**
     * <p>getLocalIp.</p>
     *
     * @return a {@link String} object.
     */
    public static String getLocalIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new IllegalStateException("cat not get localhost", e);
        }
    }
}
