package cn.com.sky.rpc.simple_rpc_complex;

/**
 * 提供服务的实现类，不继承Calculate，也可以实现。【通过map对应的关系】
 */
public class RemoteCalculate {

    public int add(int a, int b) {
        return a + b;
    }

    public int multi(int a, int b) {
        return a * b;
    }

}
