package cn.com.sky.rpc.rmi.rmi2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * <pre>
 * 4、调用RMI服务
 * 
 * 同样，我们也利用一个main()方法来调用RMI服务。
 * 调用服务我们只需要知道两个信息：1.RMI请求地址、2.RMI接口（一定不要使用RMI的实现类，否则就是本地调用）。
 * 少量代码就能调用刚才发布的RMI服务了，就像下面这样:
 */
public class RMIClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		String url = "rmi://localhost:1099/calculate";

		CalculateService calculate = (CalculateService) Naming.lookup(url);

		int sum = calculate.add(100, 400);

		System.out.println(sum);
	}

}