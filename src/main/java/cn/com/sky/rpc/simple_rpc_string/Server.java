package cn.com.sky.rpc.simple_rpc_string;

import cn.com.sky.rpc.simple_rpc_string.service.GoodByeService;
import cn.com.sky.rpc.simple_rpc_string.service.GoodByeServiceImpl;
import cn.com.sky.rpc.simple_rpc_string.service.HelloService;
import cn.com.sky.rpc.simple_rpc_string.service.HelloServiceImpl;

/**
 * 服务器
 * <p>
 * 导出服务
 */
public class Server {

    public static void main(String[] args) throws Exception {

        HelloService helloService = new HelloServiceImpl();
        GoodByeService goodbyeService = new GoodByeServiceImpl();

        RpcFramework.export(helloService, Util.SERVER_PORT);
        RpcFramework.export(goodbyeService, Util.SERVER_PORT);

    }
}