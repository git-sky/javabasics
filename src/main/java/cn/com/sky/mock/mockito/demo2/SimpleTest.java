package cn.com.sky.mock.mockito.demo2;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * 创建mock对象不能对final,Anonymous,primitive类进行mock。
 */
public class SimpleTest {

	@Test
	public void simpleTest() {

		// 创建mock对象，参数可以是类，也可以是接口
		List<String> list = mock(List.class);

		// 设置方法的预期返回值
		when(list.get(0)).thenReturn("helloworld");
		// doReturn("helloworld").when(list).get(0);//stubbing另一种语法(设置预期值的方法)，可读性不如前者.
		// when(list.get(0)).thenThrow(new RuntimeException("test excpetion")); //可对方法设定返回异常

		String result = list.get(0);

		// 验证方法调用(是否调用了get(0))
		verify(list).get(0);

		System.out.println(result);

		// junit测试
		Assert.assertEquals("helloworld", result);
	}

	@Test
	public void doThrow() {

		List<String> list = mock(List.class);
		doNothing().doThrow(new RuntimeException("void exception")).when(list).clear();
		list.clear();
		list.clear();
		verify(list, times(2)).clear();
	}

	/**
	 * Matchers类内有很多参数匹配器 anyInt、anyString、anyMap等 Mockito类继承于Matchers,Stubbing时使用内建参数匹配器.
	 */
	@Test
	public void argumentMatcherTest() {

		List<String> list = mock(List.class);

		when(list.get(anyInt())).thenReturn("hello", "world");

		String result = list.get(0) + list.get(1);
		System.out.println(result);

		verify(list, times(2)).get(anyInt());

		Assert.assertEquals("helloworld", result);

	}

	/**
	 * 需要注意的是：如果使用参数匹配器，那么所有的参数都要使用参数匹配器，不管是stubbing还是verify的时候都一样。
	 */
	@Test
	public void argumentMatcherTest2() {

		Map<Integer, String> map = mock(Map.class);
		when(map.put(anyInt(), anyString())).thenReturn("hello");// anyString()替换成"hello"就会报错
		System.out.println(map.put(1, "world"));
		verify(map).put(eq(1), eq("world")); // eq("world")替换成"world"也会报错

	}

	@Test
	public void verifyInvocate() {

		List<String> mockedList = mock(List.class);
		// using mock
		mockedList.add("once");
		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		/**
		 * 基本的验证方法 verify方法验证mock对象是否有没有调用mockedList.add("once")方法 不关心其是否有返回值，如果没有调用测试失败。
		 */
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");// 默认调用一次,times(1)可以省略

		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		// never()等同于time(0),一次也没有调用
		verify(mockedList, times(0)).add("never happened");

		// atLeastOnece/atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("twice");
		verify(mockedList, atMost(5)).add("three times");
	}
}