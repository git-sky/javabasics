package cn.com.sky.collections.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Map的排序
 * 
 */
public class MapSort {

	public static void main(String[] args) {
		 MapSort.TreeMapSortByKey();
		 MapSort.TreeMapSortByValue();
		MapSort.MapSortByKey();
		MapSort.MapSortByValue();
	}

	/**
	 * TreeMap按照key进行排序
	 */
	public static void TreeMapSortByKey() {
		TreeMap<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 降序排列
				return o2.compareTo(o1);
			}
		});
		map.put("c", "1");
		map.put("a", "2");
		map.put("b", "3");
		map.put("d", "4");
		for (String key : map.keySet()) {
			System.err.println("key:" + key + "  value:" + map.get(key));
		}
	}

	/**
	 * TreeMap按照value排序
	 */
	public static void TreeMapSortByValue() {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("d", "ccccc");
		map.put("b", "bbbbb");
		map.put("a", "eeeee");
		map.put("c", "ddddd");
		// 将map.entrySet()转换成list
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		// 通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				// 升序排序
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		for (Map.Entry<String, String> mapping : list) {
			System.out.println(mapping.getKey() + ":" + mapping.getValue());
		}
	}

	/**
	 * Map按照Key排序
	 */
	public static void MapSortByKey() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("d", "ccccc");
		map.put("b", "bbbbb");
		map.put("a", "eeeee");
		map.put("c", "ddddd");
		// 将map.entrySet()转换成list
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		// 通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				// 升序排序
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		for (Map.Entry<String, String> mapping : list) {
			System.out.println(mapping.getKey() + ":" + mapping.getValue());
		}
	}

	/**
	 * Map按照Value排序
	 */
	public static void MapSortByValue() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("d", "ccccc");
		map.put("b", "bbbbb");
		map.put("a", "eeeee");
		map.put("c", "ddddd");
		// 将map.entrySet()转换成list
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		// 通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				// 降序排序
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for (Map.Entry<String, String> mapping : list) {
			System.out.println("key:" + mapping.getKey() + "  value:" + mapping.getValue());
		}
	}

}