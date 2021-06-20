package cn.com.todo.test_netty;

import static org.jboss.netty.channel.Channels.pipeline;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * �ڱ���8080�˿�����netty����
 * 
 * @author Ransom
 * 
 */
public class Server {
	public static void main(String[] args) {
		/*
		 * server��ע�ͺ�client���ƣ�������Ͳ��ظ��� ������Ҫע�����server��ʼ������ServerBootstrap��ʵ��
		 * client��ʼ������ClientBootstrap�������ǲ�һ���ġ�
		 * �����channelfactoryҲ��NioServerSocketChannelFactory��
		 */

		ServerBootstrap bootstrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(Executors
						.newCachedThreadPool(), Executors.newCachedThreadPool()));

		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

			@Override
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline pipleline = pipeline();
				pipleline.addLast("encode", new StringEncoder());
				pipleline.addLast("decode", new StringDecoder());
				pipleline.addLast("handler", new Handler());
				return pipleline;
			}

		});

		bootstrap.bind(new InetSocketAddress(8080));
	}
}
