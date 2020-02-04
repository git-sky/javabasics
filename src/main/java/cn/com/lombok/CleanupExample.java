package cn.com.lombok;

import lombok.Cleanup;

import java.io.*;

/**
 * <pre>
 *
 *     @Cleanup
 * 该注解能帮助我们自动调用close()方法，很大的简化了代码。
 *
 * </pre>
 */
public class CleanupExample {

    public static void main(String[] args) throws IOException {
        @Cleanup
        InputStream in = new FileInputStream(args[0]);
        @Cleanup
        OutputStream out = new FileOutputStream(args[1]);
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) {
                break;
            }
            out.write(b, 0, r);
        }
    }
}