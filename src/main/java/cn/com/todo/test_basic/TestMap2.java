package cn.com.todo.test_basic;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class TestMap2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<String, ArrayList<TagWeight>> map_list = new HashMap<String, ArrayList<TagWeight>>();

		Map<String, Float> m = new HashMap<String, Float>();

		m.put("ss1,��2", 5.2f);
		m.put("ss1,��4", 3f);
		m.put("ss1,����2", 8f);
		m.put("ss1,�Ǻ�", 2f);

		m.put("ss2,��", 54f);
		m.put("ss2,��", 13f);
		m.put("ss2,��", 228f);
		m.put("ss2,�õ�", 32f);

		
		for (Entry<String, Float> e : m.entrySet()) {
			String keys[];
			keys = e.getKey().split(",");
			if (keys.length != 2) {
				continue;
			}
			getArray(map_list, keys[0], keys[1], e.getValue());
		}
		
		
		  Comparator comp = new Comparator(){
	           public int compare(Object o1,Object o2) {
	        	   TagWeight p1=(TagWeight)o1;
	               TagWeight p2=(TagWeight)o2;  
	             if(p1.getWeight()<p2.getWeight())
	                  return 1;
	              else
	                  return 0;
	              }
	         };
	       
		for (Entry<String, ArrayList<TagWeight>> entry : map_list.entrySet()) {
			
			System.out.println(entry.getKey());
			
			Collections.sort(entry.getValue(),comp);

			
			for(int i=0;i<entry.getValue().size()&&i<3;i++){
				
				System.out.println(entry.getKey()+":"+entry.getValue().get(i).getTag()+":"+entry.getValue().get(i).getWeight());
			}
		}
	}

	private static void getArray(Map<String, ArrayList<TagWeight>> m, String channel,
			String tag, Float weight) {
		
		if (m.containsKey(channel)) {
			ArrayList<TagWeight> list = m.get(channel);
			list.add(new TagWeight(tag,weight));
			m.put(channel, list);
		} else {
			ArrayList<TagWeight> list = new ArrayList<TagWeight>();
			list.add(new TagWeight(tag,weight));
			m.put(channel, list);
		}

	}
	
	public static class TagWeight {
		private String tag = "";
		private Float weight = 0.0f;

		TagWeight(String tag, Float weight) {
			this.setTag(tag);
			this.setWeight(weight);
		}

		public void setTag(String tag) {
			this.tag = tag;
		}

		public String getTag() {
			return tag;
		}

		public void setWeight(Float weight) {
			this.weight = weight;
		}

		public Float getWeight() {
			return weight;
		}
	}

}