package cn.com.sky.rpc.simple_rpc_string.service;

public class HelloServiceImpl implements HelloService {

	public String hello(String name) {
		return "Hello " + name;
	}
}