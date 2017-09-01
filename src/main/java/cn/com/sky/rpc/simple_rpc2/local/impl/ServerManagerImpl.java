package cn.com.sky.rpc.simple_rpc2.local.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import cn.com.sky.rpc.simple_rpc2.EncryXOR;
import cn.com.sky.rpc.simple_rpc2.RPC;
import cn.com.sky.rpc.simple_rpc2.local.ServerManager;
import cn.com.sky.rpc.simple_rpc2.protocal.Result;
import cn.com.sky.rpc.simple_rpc2.support.Server;

public final class ServerManagerImpl implements ServerManager {

	private Map<Class<?>, Class<?>> serviceEngine = new HashMap<Class<?>, Class<?>>();

	public void start() {
		this.start(null, null);
	}

	public void start(Integer port) {
		this.start(null, port);
	}

	public void start(String host, Integer port) {
		Server server = new RPC.RPCServer(host, port);
		server.register(ServerManager.class, ServerManagerImpl.class);// 注册本地服务

		Iterator<Entry<Class<?>, Class<?>>> it = serviceEngine.entrySet().iterator();
		while (it.hasNext()) {// 注册远程服务列表
			Entry<Class<?>, Class<?>> entry = it.next();
			server.register(entry.getKey(), entry.getValue());
		}
		server.start();// 启动服务器
	}

	public Result stop(String name, String pawd) {
		Result result = new Result();
		boolean isStop = true;
		String msg = "服务器正常停止";
		
		if (StringUtils.isEmpty(name)) {
			isStop = false;
			msg = "用户名不能为空";
		}
		if (StringUtils.isEmpty(pawd)) {
			isStop = false;
			msg = "密码不能为空";
		}
		String tname = EncryXOR.Decryptor(name);
		String tpawd = EncryXOR.Decryptor(pawd);
		if (!tname.equals("abc") || !tpawd.equals("123")) {
			isStop = false;
			msg = "用户或密码错误";
		}
		result.setStop(isStop);
		result.setMsg(msg);
		return result;
	}

	/**
	 * 注册服务
	 * 
	 * @param interfaceDefiner
	 * @param impl
	 */
	public void register(Class<?> interfaceDefiner, Class<?> impl) {
		serviceEngine.put(interfaceDefiner, impl);
	}

}