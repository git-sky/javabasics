package cn.com.todo.test_netty;

import static org.jboss.netty.channel.Channels.pipeline;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * ����һ��client�̣߳�������Ъ�Եķ�����Ϣ
 * 
 * @author Ransom
 */
public class ClientThread implements Runnable {
	private ChannelFuture future;

	public ChannelFuture getFuture() {
		return future;
	}

	public void setFuture(ChannelFuture future) {
		this.future = future;
	}

	@Override
	public void run() {
		/*
		 * ʵ����һ���ͻ���Bootstrapʵ���� NioClientSocketChannelFactory��NettyĬ���ṩ�ġ�
		 * ����������һ����boss���̳߳أ�һ����workerִ�е��̳߳ء�
		 * �����̳߳ض�ʹ����java.util.concurrent.Executors�е��̳߳���������
		 */
		ClientBootstrap bootstrap = new ClientBootstrap(
				new NioClientSocketChannelFactory(Executors
						.newCachedThreadPool(), Executors.newCachedThreadPool()));

		/*
		 * ����piplineFactory, ����˼�壬���ǲ���Ĭ�ϵ�pipline��
		 * pipline��ʵ����DefaultChannelPipeline �ṩ����ʽ���¼�ͨѶ����
		 */
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
			 */
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				/*
				 * ��DefaultChannelPipeline�Ĺ����� ����ʵ���� encode ��decode��handler
				 * ����encodeʵ����ChannelDownstreamHandler�ӿ�
				 * decode��Handlerʵ����ChannelUpstreamHandler�ӿ�
				 * Ҳ��˵������client������Ϣ��ʱ��Ĭ�ϰ���˳����ȵ���decode
				 * ��client���յ���Ӧ��ʱ�򣬻ᰴ��˳�����encode��Handler��
				 * �����������ר�Ž�ChannelDownstreamHandler��ChannelUpstreamHandler�ĵ���˳��
				 * ��
				 */
				ChannelPipeline pipleline = pipeline();
				pipleline.addLast("encode", new StringEncoder());
				pipleline.addLast("decode", new StringDecoder());
				pipleline.addLast("handler", new Handler());
				return pipleline;
			}
		});

		/*
		 * ��127.0.0.1���������ӡ�
		 */
		future = bootstrap.connect(new InetSocketAddress("127.0.0.1", 8080));
	}

	/**
	 * ������Ϣ��server
	 */
	public void sendMsg() {
		if (future == null)
			return;
		String s = "Hello Word!";
		future.getChannel().write(s);
	}

}
