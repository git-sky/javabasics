package cn.com.sky.rpc.simple_rpc_string;

import cn.com.sky.rpc.simple_rpc_string.service.GoodByeService;
import cn.com.sky.rpc.simple_rpc_string.service.GoodByeServiceImpl;
import cn.com.sky.rpc.simple_rpc_string.service.HelloService;
import cn.com.sky.rpc.simple_rpc_string.service.HelloServiceImpl;

/**
 * <pre>
 *
 * 服务器
 *
 * 导出服务
 *
 * </pre>
 */
public class Server {

    public static void main(String[] args) throws Exception {

        HelloService helloService = new HelloServiceImpl();
        GoodByeService goodbyeService = new GoodByeServiceImpl();

        RpcFramework.export(helloService, Utils.SERVER_PORT);
        RpcFramework.export(goodbyeService, Utils.SERVER_PORT);

    }
}