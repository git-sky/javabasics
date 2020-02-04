package cn.com.sky.rpc.simple_rpc_complex.support;

import cn.com.sky.rpc.simple_rpc_complex.protocal.Invocation;

/**
 * 服务器管理
 */
public interface Server {
    /**
     * 停止服务器
     */
    public void stop();

    /**
     * 启动服务器
     */
    public void start();

    /**
     * 注册服务
     *
     * @param interfaceDefiner
     * @param impl
     */
    public void register(Class<?> interfaceDefiner, Class<?> impl);

    /**
     * 远程调用
     *
     * @param invo
     */
    public void call(Invocation invo);

    /**
     * 验证服务运行状态
     *
     * @return
     */
    public boolean isRunning();

    /**
     * 获取端口
     *
     * @return
     */
    public Integer getPort();

    /**
     * 获取主机IP
     *
     * @return
     */
    public String getHost();
}