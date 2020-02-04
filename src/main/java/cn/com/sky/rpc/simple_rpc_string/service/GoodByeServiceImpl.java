package cn.com.sky.rpc.simple_rpc_string.service;

public class GoodByeServiceImpl implements GoodByeService {

    public String sayGoodBye(String name) {
        return "Good Bye " + name;
    }
}