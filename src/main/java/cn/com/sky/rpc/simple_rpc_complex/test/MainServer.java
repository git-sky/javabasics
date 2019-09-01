package cn.com.sky.rpc.simple_rpc_complex.test;

import cn.com.sky.rpc.simple_rpc_complex.Calculate;
import cn.com.sky.rpc.simple_rpc_complex.RemoteCalculate;
import cn.com.sky.rpc.simple_rpc_complex.local.ServerManager;
import cn.com.sky.rpc.simple_rpc_complex.local.impl.ServerManagerImpl;

/**
 * 服务端
 */
public class MainServer {

    public static void main(String[] args) {

        ServerManager server = new ServerManagerImpl();
        server.register(Calculate.class, RemoteCalculate.class);
        server.start();

        // 添加jvm退出钩子
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("服务器已停止...");
            }
        });

    }
}