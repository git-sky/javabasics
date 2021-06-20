package cn.com.todo.test_netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

/**
 * client��server������Ϣ���õ�handler �����������Ǽ̳���SimpleChannelUpstreamHandler,���Ծ�д��һ���ˡ�
 * 
 * @author Ransom
 * 
 */
public class Handler extends SimpleChannelUpstreamHandler {
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		System.out.println("recive message,message content:" + e.getMessage());

	}

	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		System.err.println("Client has a error,Error cause:" + e.getCause());
		e.getChannel().close();
	}
}
