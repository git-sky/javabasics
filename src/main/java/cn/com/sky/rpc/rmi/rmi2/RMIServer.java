package cn.com.sky.rpc.rmi.rmi2;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * <pre>
 *
 * 3.通过JNDI发布RMI服务
 *
 * 发布RMI服务，我们需要告诉JNDI三个基本信息：1.域名或IP地址(host)、2.端口号(port)、3、服务名(service)，
 * 它们构成了RMI协议的URL: rmi://<host>:<port>/<service>
 *
 * </pre>
 */
public class RMIServer {

    /**
     * 运行这个main()方法，RMI服务就会自动发布，剩下的事情就是写一个RMI客户端来调用刚发布的RMI服务。
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        int port = 1099;
        // 通过LocateRegistry.createRegistry()方法在JNDI中创建一个注册表，只需提供一个RMI端口即可。
        LocateRegistry.createRegistry(port);

        String url = "rmi://localhost:" + port + "/calculate";

        // 通过Naming.bind()方法绑定RMI地址与服务的实现类。
        Naming.bind(url, new CalculateServiceImpl());
    }

}