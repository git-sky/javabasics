package cn.com.sky.collections.map;

public class TestLruCache {

	public static void main(String[] args) {
		lruCache1();
	}

	static void lruCache1() {
		System.out.println();
		System.out.println("===========================LRU 链表实现===========================");
		LRUCache<Integer, String> lru = new LRUCache(5);
		lru.put(1, "11");
		lru.put(2, "11");
		lru.put(3, "11");
		lru.put(4, "11");
		lru.put(5, "11");
		System.out.println(lru.toString());
		lru.put(6, "66");
		System.out.println(lru.toString());
		lru.get(2);
		System.out.println(lru.toString());
		lru.put(7, "77");
		System.out.println(lru.toString());
		lru.get(4);
		System.out.println(lru.toString());
		System.out.println();
	}
}