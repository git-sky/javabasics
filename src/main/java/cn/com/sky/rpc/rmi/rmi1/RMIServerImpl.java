package cn.com.sky.rpc.rmi.rmi1;

import java.rmi.AccessException;
import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现RMI服务器相关功能的实现类
 */
public class RMIServerImpl extends UnicastRemoteObject implements RMIServer {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private boolean isRuning;
    private Listener listener;

    /**
     * 本地主机RMI注册表
     */
    private Registry localRegistry = null;
    /**
     * 远程主机RMI注册表
     */
    private Registry remoteRegistry = null;
    /**
     * 远程服务器
     */
    private RMIServer remoteServer = null;
    /**
     * 缓存本地对象实例
     */
    private Map<String, Object> registeredLocalObjectMap = new HashMap<String, Object>();
    /**
     * 缓存远程对象实例
     */
    private Map<String, Remote> registeredRemoteObjectMap = new HashMap<String, Remote>();

    public RMIServerImpl() throws RemoteException {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public RMIServerImpl(int port) throws RemoteException {
        this(DEFAULT_HOST, port);
    }

    public RMIServerImpl(String cip, int cport) throws RemoteException {
        registerLocalServer(cip, cport);
    }

    public RMIServerImpl(String cip, int cport, String sip, int sport) throws RemoteException {
        getRemoteServer(sip, sport);
        registerLocalServer(cip, cport);
    }

    private void registerLocalServer(String cip, int cport) throws AccessException, RemoteException {
        System.setProperty("java.rmi.server.hostname", cip);
        if (localRegistry == null) {
            try {
                localRegistry = LocateRegistry.getRegistry(cip, cport);
                localRegistry.list();
            } catch (Exception e) {
                try {
                    localRegistry = LocateRegistry.createRegistry(cport);// 在本地主机创建并导出RMI注册表
                } catch (RemoteException e1) {
                    throw new RuntimeException(e1);
                }
            }
        }
        localRegistry.rebind(getKey(cip, cport), this);
    }

    private void getRemoteServer(String sip, int sport) throws AccessException, RemoteException {
        if (null == sip || "".equals(sip.trim())) {
            return;
        }
        remoteRegistry = LocateRegistry.getRegistry(sip, sport);
        try {
            remoteServer = (RMIServer) remoteRegistry.lookup(getKey(sip, sport));
        } catch (ConnectException e) {
            remoteRegistry = null;
            throw new RemoteException("无法获取远程服务:" + getKey(sip, sport));
        } catch (NotBoundException e) {
            remoteRegistry = null;
            throw new RemoteException("无法获取远程服务:" + getKey(sip, sport));
        }
    }

    public void registerLocalObject(Class<?> interfaceDefiner, Class<?> impl) throws InstantiationException, IllegalAccessException {
        Object instance = impl.newInstance();
        registeredLocalObjectMap.put(interfaceDefiner.getName(), instance);
        System.out.println("注册本地对象:" + interfaceDefiner.getName());
    }

    public void registerRemoteObject(Class<?> interfaceDefiner, Class<?> impl) throws RemoteException, InstantiationException, IllegalAccessException {
        Object object = impl.newInstance();// 反射实例化
        if (!(object instanceof Remote)) {
            throw new ClassCastException("cannot be cast to java.rmi.Remote");
        }
        System.out.println("注册远程对象:" + interfaceDefiner.getName());
        Remote instance = (Remote) object;
        registeredRemoteObjectMap.put(interfaceDefiner.getName(), instance);

        if (instance instanceof UnicastRemoteObject) {
            localRegistry.rebind(interfaceDefiner.getName(), instance);// 更新对此注册表中指定name的远程引用。
            if (remoteServer != null) {
                remoteServer.registerLocalObject(interfaceDefiner, impl);// 对象实例直接推送到远程服务器端
            }
        } else {
            Remote stub = UnicastRemoteObject.exportObject(instance, 0);
            localRegistry.rebind(interfaceDefiner.getName(), stub);// 更新对此注册表中指定name的远程引用。
            if (remoteServer != null) {
                remoteServer.registerLocalObject(interfaceDefiner, stub.getClass());// 对象实例直接推送到远程服务器端
            }
        }
    }

    public void unregisterObject(Class<?> interfaceDefiner) throws AccessException, RemoteException, NotBoundException, ClassNotFoundException {
        unregisterObject(interfaceDefiner.getName());
    }

    private void unregisterObject(String key) throws AccessException, RemoteException, NotBoundException, ClassNotFoundException {
        if (registeredLocalObjectMap.containsKey(key)) {
            registeredLocalObjectMap.remove(key);
            System.out.println("注销本地对象:" + key);
        } else if (registeredRemoteObjectMap.containsKey(key)) {
            localRegistry.unbind(key);// 移除RMI注册表中的绑定
            Remote remote = registeredRemoteObjectMap.get(key);
            if (remote != null) {
                UnicastRemoteObject.unexportObject(remote, true);// 从RMI中移除远程对象
                remote = null;
            }
            registeredRemoteObjectMap.remove(key);
            if (remoteServer != null) {
                remoteServer.unregisterObject(Class.forName(key));// 将推送到远程服务器上对象实例注销
            }
            System.out.println("注销远程对象:" + key);
        }
    }

    public void unregisterAllObjects() throws AccessException, RemoteException, NotBoundException, ClassNotFoundException {
        registeredLocalObjectMap.clear();// 注销本地对象

        List<String> keys = new ArrayList<String>();
        for (String key : registeredRemoteObjectMap.keySet()) {
            keys.add(key);
        }
        for (String key : keys) {
            unregisterObject(key);
        }
    }

    public <T> T getObject(Class<T> interfaceDefiner) throws RemoteException {
        String key = interfaceDefiner.getName();
        if (registeredLocalObjectMap.containsKey(key)) {
            System.out.println("调用本地对象:" + interfaceDefiner.getName());
            return (T) registeredLocalObjectMap.get(key);
        }
        if (registeredRemoteObjectMap.containsKey(key)) {
            System.out.println("调用远程对象:" + interfaceDefiner.getName());
            return (T) registeredRemoteObjectMap.get(key);
        }
        if (remoteServer != null) {
            return remoteServer.getObject(interfaceDefiner);
        }
        return null;
    }

    public void start() throws RemoteException {
        listener = new Listener(this);
        this.isRuning = true;
        listener.start();
    }

    public void stop(boolean remote) throws AccessException, RemoteException, NotBoundException, ClassNotFoundException {
        unregisterAllObjects();
        String[] names = localRegistry.list();
        for (String name : names) {
            localRegistry.unbind(name);
        }
        UnicastRemoteObject.unexportObject(localRegistry, true);
        localRegistry = null;
        if (remote && remoteServer != null) {
            remoteServer.remoteStop();
        }
        System.out.println("本地RMI服务器停止...");
        System.exit(0);
    }

    public void remoteStop() throws RemoteException {
        this.isRuning = false;
    }

    private String getKey(String name, int port) {
        return name + "|" + port;
    }

    public boolean isRunning() {
        return isRuning;
    }
}