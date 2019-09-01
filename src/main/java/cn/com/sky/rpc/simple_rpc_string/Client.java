package cn.com.sky.rpc.simple_rpc_string;

import cn.com.sky.rpc.simple_rpc_string.service.GoodByeService;
import cn.com.sky.rpc.simple_rpc_string.service.HelloService;

/**
 * 客户端
 * 
 */
public class Client {

	public static void main(String[] args) throws Exception {
		HelloService service = RpcFramework.refer(HelloService.class, Util.SERVER_IP, Util.SERVER_PORT);
		for (int i = 0; i < 5; i++) {
			String hello = service.hello("World" + i);
			System.out.println(hello);
			Thread.sleep(2000);
		}
		GoodByeService goodbyeService = RpcFramework.refer(GoodByeService.class, Util.SERVER_IP, Util.SERVER_PORT);
		for (int i = 0; i < 5; i++) {
			String goodbye = goodbyeService.sayGoodBye("ljf" + i);
			System.out.println(goodbye);
			Thread.sleep(2000);
		}
	}

}