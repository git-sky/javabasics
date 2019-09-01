package cn.com.sky.rpc.simple_rpc_complex.local;

import cn.com.sky.rpc.simple_rpc_complex.protocal.Result;

/**
 * 本地调用-管理服务器
 */
public interface ServerManager {

    /**
     * 注册服务
     *
     * @param interfaceDefiner
     * @param impl
     */
    void register(Class<?> interfaceDefiner, Class<?> impl);

    /**
     * 开启服务器
     */
    void start();

    /**
     * 根据端口开启服务器
     *
     * @param port
     */
    void start(Integer port);

    /**
     * 根据IP与端口开启服务器
     *
     * @param host
     * @param port
     */
    void start(String host, Integer port);

    /**
     * 停止服务器
     *
     * @param name 用户
     * @param pawd 密码
     * @return
     */
    Result stop(final String name, final String pawd);
}