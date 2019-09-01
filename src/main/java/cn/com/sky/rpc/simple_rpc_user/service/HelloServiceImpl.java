package cn.com.sky.rpc.simple_rpc_user.service;

public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(User user) {
        return "Hello " + user.getName();
    }
}