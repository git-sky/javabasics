package cn.com.sky.rpc.simple_rpc_user;


import cn.com.sky.rpc.simple_rpc_user.service.GoodByeService;
import cn.com.sky.rpc.simple_rpc_user.service.HelloService;
import cn.com.sky.rpc.simple_rpc_user.service.User;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) throws Exception {

        HelloService service = RpcFramework.refer(HelloService.class, Util.SERVER_IP, Util.SERVER_PORT);


        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(123 + i);
            user.setName("zhangsan" + i);

            String hello = service.hello(user);
            System.out.println(hello);
            Thread.sleep(2000);
        }
        GoodByeService goodbyeService = RpcFramework.refer(GoodByeService.class, Util.SERVER_IP, Util.SERVER_PORT);
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(123 + i);
            user.setName("zhangsan" + i);

            String goodbye = goodbyeService.sayGoodBye(user);
            System.out.println(goodbye);
            Thread.sleep(2000);
        }
    }

}