package cn.com.sky.mock.easymock.demo;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试
 */
public class ShoppingCartTest {
	public ShoppingCart cart = null;
	public Store storeMock = null;

	@Before
	public void initialize() {
		cart = new ShoppingCart();
		// 1.根据接口去模拟一个实现
		storeMock = EasyMock.createMock(Store.class);
		cart.setStore(storeMock);
	}

	@Test
	public void testShoppingCart() {
		// 2.
		EasyMock.expect(storeMock.getPrice("A")).andReturn(5.99);
		EasyMock.expect(storeMock.getPrice("B")).andReturn(499.99);

		// 3.开始使用mock
		EasyMock.replay(storeMock);

		// 4.
		Item item1 = new Item("A", 3);
		Item item2 = new Item("B", 1);

		cart.addItem(item1);
		cart.addItem(item2);

		double total = cart.calculateTotal();

		// 5.
		System.out.println("Total price: " + total);
		assertEquals("Result", 517.96, total, 0);

	}

	@After
	public void cleanup() {
		cart = null;
		storeMock = null;
	}

}
