package cn.com.sky.rpc.simple_rpc.service;

public class HelloServiceImpl implements HelloService {

	public String hello(String name) {
		return "Hello " + name;
	}
}