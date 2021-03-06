package cn.com.sky.basics.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * <pre>
 *
 * SPI 简介
 *
 * SPI 全称为 (Service Provider Interface) ,是JDK内置的一种服务提供发现机制。
 * 目前有不少框架用它来做服务的扩展发现， 简单来说，它就是一种动态替换发现的机制， 举个例子来说， 有个接口，想运行时动态的给它添加实现，你只需要添加一个实现，
 * 而后，把新加的实现，描述给JDK知道就行啦（通过改一个文本文件即可） 公司内部，目前Dubbo框架就基于SPI机制提供扩展功能。
 *
 * 参考：http://ivanzhangwb.github.io/blog/2012/06/01/java-spi/
 *
 * </pre>
 */
public class SPIMain {
    public static void main(String[] args) {

        ServiceLoader<HelloInterface> loaders = ServiceLoader.load(HelloInterface.class);

        Iterator<HelloInterface> iter = loaders.iterator();

        while (iter.hasNext()) {
            HelloInterface hello = iter.next();
            hello.sayHello();
        }

        for (HelloInterface in : loaders) {
            in.sayHello();
        }
    }
}