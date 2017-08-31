package cn.com.sky.basics.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestComparator2 {

	public static void main(String args[]) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> m1 = new HashMap<String, Object>();

		m1.put("user_id", "1005");
		m1.put("nick_name", "aba");
		m1.put("avatar", "aaaaaaaaaaaaaaaaaa");
		m1.put("total_score", 100);

		list.add(m1);

		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("user_id", "1003");
		m2.put("nick_name", "abb");
		m2.put("avatar", "sdfasdfasd");
		m2.put("total_score", 100);

		list.add(m2);

		Map<String, Object> m3 = new HashMap<String, Object>();
		m3.put("user_id", "1006");
		m3.put("nick_name", "abd");
		m3.put("avatar", "sdfasdfasd");
		m3.put("total_score", 120);
		
		list.add(m3);
		
		Map<String, Object> m4 = new HashMap<String, Object>();
		m4.put("user_id", "1001");
		m4.put("nick_name", "aaa");
		m4.put("avatar", "sdfasdfasd");
		m4.put("total_score", 110);

		list.add(m4);
		

		new TestComparator2().sortByScoreAndName(list);
		
		int rank=0;
		for(Map m:list){
			rank++;
			m.put("rank", rank);
		}

		for (Map m : list) {
			
			System.out.println(m.get("rank"));
			System.out.println(m.get("user_id"));
			System.out.println(m.get("nick_name"));
			System.out.println(m.get("avatar"));
			System.out.println(m.get("total_score"));
			System.out.println("-----------------------------------");
		}

	}

	private void sortByScoreAndName(List<Map<String, Object>> list) {

		Collections.sort(list, new Comparator<Map>() {

			public int compare(Map o1, Map o2) {

				Integer a = (Integer) o1.get("total_score");
				Integer b = (Integer) o2.get("total_score");

				int rank = b.compareTo(a);

				if (rank == 0) {
					String na = (String) o1.get("nick_name");
					String nb = (String) o2.get("nick_name");
					rank = na.compareTo(nb);
				}
				return rank;
			}
		});
	}
}
