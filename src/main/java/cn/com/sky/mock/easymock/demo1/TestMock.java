package cn.com.sky.mock.easymock.demo1;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 * 
 *   Mock
 *   方法是单元测试中常见的一种技术，它的主要作用是模拟一些在应用中不容易构造或者比较复杂的对象，从而把测试与测试边界以外的对象隔离开。
 *   同时也可以当调用别人的模块，而该模块又没有实现时（只提供接口 ），我们可以在独立的环境中测试自己的模块逻辑。
 *   
 *   
 * 主要有以下步骤：
 *  1. 使用 EasyMock 生成 Mock 对象；
 *  2. 设定 Mock 对象的预期行为和输出；
 *  3. 将 Mock 对象切换到 Replay 状态；
 *  4. 调用 Mock 对象方法进行单元测试；
 *  5. 对 Mock 对象的行为进行验证。
 *  
 *  
 *  
 *  1. 创建mock对象 
 *     UserDao userDao  = Easymock.createMock(UserDao.class);
 *  2. 记录mock对象期望的行为
 *     Easymock.expect(userDao.getById("1001")).andReturn(expectedUser);
 *     这里记录了mock对象的行为：getById()方法被调用，调用次数为1(如果没有明确指出调用次数，默认为1),参数为"1001"，expectedUser将作为返回值。
 *  3. 进入replay阶段
 *     Easymock.replay(userDao);
 *  4. 对mock对象执行验证
 *     Easymock.verify(userDao);
 *  
 *  常见用法：
 * 
 * 1. 指定期望的调用次数
 *   Easymock.expect(userDao.getById("1001")).andReturn(expectedUser).times(3);
 * 
 * 2. 指定抛出期望的异常
 *   Easymock.expect(userDao.getById("1001")).andThrow(new RuntimeException("no user exist"));
 * 
 * 3. 记录void 方法的行为
 *   Easymock.expectLastCall().times(3);
 *   Easymock.expectLastCall().andThrow(new RuntimeException("some error"));
 *   
 * 4. 灵活的参数匹配
 *   Easymock.expect(userDao.getById(Easymock.isA(String.class))).andReturn(expectedUser);
 *   类似的还有anyInt()，anyObject()， isNull() ， same(), startsWith()等诸多实现。
 * 
 * 
 * </pre>
 * 
 */
public class TestMock {

	IService service;
	Application application;

	@Test
	public void testdoMethod() {

		// 1.使用 EasyMock 生成 Mock 对象；
		service = EasyMock.createMock(IService.class);

		// 2.设定 Mock 对象的预期行为和输出
		EasyMock.expect(service.doMethod1()).andReturn("a").times(3);
		EasyMock.expect(service.doMethod2()).andReturn("b").times(1);
		EasyMock.expect(service.doMethod3()).andReturn("c").times(1);

		// 3.将 Mock 对象切换到 Replay 状态
		EasyMock.replay(service);

		// 4.调用 Mock 对象方法进行单元测试
		application = new Application();
		application.setService(service);
		String getStr = application.doMethod();
		System.out.println(getStr);

		// 5.对 Mock 对象的行为进行验证
		EasyMock.verify(service);
		String cstr = "abc";// 正确的字符串
		Assert.assertEquals(getStr, cstr);

	}

}