package cn.com.sky.rpc.rmi.rmi3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * <pre>
 * 
 * RMI对服务器的IP地址和端口依赖很紧密，但是在开发的时候不知道将来的服务器IP和端口如何，但是客户端程序依赖这个IP和端口。
 * 这也是RMI的局限性之一。这个问题有两种解决途径：一是通过DNS来解决，二是通过封装将IP暴露到程序代码之外。
 * RMI的局限性之二是RMI是Java语言的远程调用，两端的程序语言必须是Java实现，对于不同语言间的通讯可以考虑用Web Service或者公用对象请求代理体系（CORBA）来实现。
 * 
 * 
 * 
 * 客户端测试，在客户端调用远程对象上的远程方法，并返回结果。
 */
public class HelloClient {
	public static void main(String args[]) {
		try {
			// 在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法
			IHello rhello = (IHello) Naming.lookup("rmi://localhost:8888/RHello");
			System.out.println(rhello.helloWorld());
			System.out.println(rhello.sayHelloToSomeBody("熔岩"));
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}