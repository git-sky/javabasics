package cn.com.sky.collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

/**
 * <pre>
 * 
 * Set的比较 :
 *  
 * HashSet：哈希表是通过使用称为散列法的机制来存储信息的，元素并没有以某种特定顺序来存放；哈希表实现。底层是HashMap 
 *  
 * LinkedHashSet：以元素插入的顺序来维护集合的链接表，允许以插入的顺序在集合中迭代；底层是LinkedHashMap
 *              
 * TreeSet：提供一个使用树结构存储Set接口的实现，对象以升序顺序存储，访问和遍历的时间很快。红黑树实现。底层是TreeMap
 * 
 * 
 * </pre>
 * 
 */
public class TestSetEffect {

	@Test
	public void addHashSet() {
		System.out.println("HashSet:");
		HashSet<String> hashSet = new HashSet<>();
		put(hashSet);
	}

	@Test
	public void addLinkedHashSet() {
		System.out.println("LinkedHashSet:");
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		put(linkedHashSet);
	}

	@Test
	public void addTreeSet() {
		System.out.println("TreeSet:");
		TreeSet<String> treeSet = new TreeSet<>();
		put(treeSet);
	}

	private void put(Set set) {
		StopWatch sw = new StopWatch();
		sw.start();
		for (int i = 0; i < 30 * 1000000; i++) {
			set.add(i);
		}
		sw.stop();
		System.out.println("使用时间:" + sw.getTime());
	}
}