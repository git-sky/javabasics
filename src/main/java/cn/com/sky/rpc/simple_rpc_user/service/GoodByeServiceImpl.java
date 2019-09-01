package cn.com.sky.rpc.simple_rpc_user.service;

public class GoodByeServiceImpl implements GoodByeService {

    @Override
    public String sayGoodBye(User user) {
        return "Good Bye " + user.getName();
    }
}