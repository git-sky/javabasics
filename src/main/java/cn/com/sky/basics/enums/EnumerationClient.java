package cn.com.sky.basics.enums;

// 客户端程序，将一个枚举值通过网络传递给服务器端

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Enum默认实现了 Comparable 和 Serializable 接口
 */
public class EnumerationClient {

    public static void main(String... args) throws UnknownHostException, IOException {
        Socket socket = new Socket();
        // 建立到服务器端的连接
        socket.connect(new InetSocketAddress("127.0.0.1", 8999));
        // 从连接中得到输出流
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        // 将星期五这个枚举值传递给服务器端
        // oos.writeObject(WeekDayEnum.Fri);
        Student s = new Student();
        oos.writeObject(s);
        oos.close();
        os.close();
        socket.close();
    }
}
