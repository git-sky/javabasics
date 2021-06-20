package cn.com.todo.test_simple_json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// // 1 json����ת��Ϊ�ַ���
		// JSONObject subObject = new JSONObject();
		// subObject.put("ooo", "***");
		// subObject.put("ppp", "&&&");
		// // System.out.println(subObject.toJSONString());
		//
		// JSONObject object = new JSONObject();
		// object.put("aaa", "111");
		// object.put("bbb", "222");
		// object.put("ccc", subObject);
		//
		// // System.out.println(object.toJSONString());
		// // System.out.println(object.toString());
		//
		// // 2 json�������װ��Ϊ�ַ���
		// JSONArray array = new JSONArray();
		//
		// JSONObject object1 = new JSONObject();
		// object1.put("aaa", "111");
		// object1.put("bbb", "222");
		//
		// JSONObject object2 = new JSONObject();
		// object2.put("aaa", "111");
		// object2.put("bbb", "222");
		//
		// array.add(object1);
		// array.add(object2);
		//
		// // System.out.println(array.toJSONString());
		// // System.out.println(array.toString());
		//
		// // 3 �ַ���ת��Ϊjson����
		// String jsonStr =
		// "{\"aaa\":\"111\",\"ccc\":{\"ooo\":\"***\",\"ppp\":\"&&&\"},\"bbb\":\"222\"}";
		// JSONParser parser = new JSONParser();
		// try {
		// JSONObject parseObject = (JSONObject) parser.parse(jsonStr);
		// System.out.println("---->" + parseObject.toJSONString());
		// System.out.println("---->" + parseObject.get("aaa"));
		// System.out.println("---->" + parseObject.get("ccc"));
		// System.out.println("---->" + parseObject.get("bbb"));
		// System.out.println("---->"
		// + ((JSONObject) parseObject.get("ccc")).get("ooo"));
		// System.out.println("---->"
		// + ((JSONObject) parser.parse(parseObject.get("ccc")
		// .toString())).get("ooo"));
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		//
		// // 4 �ַ���ת��Ϊ����
		// String jsonStr2 =
		// "[{\"aaa\":\"111\",\"bbb\":\"222\"},{\"aaa\":\"111\",\"bbb\":\"222\"}]";
		// JSONParser parser2 = new JSONParser();
		// try {
		// JSONArray parseObject = (JSONArray) parser2.parse(jsonStr2);
		// System.out.println("---->" + parseObject.toJSONString());
		// System.out.println("---->" + parseObject.toString());
		// System.out.println("---->" + parseObject.get(0));
		// System.out.println("---->" + parseObject.get(1));
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }

		String jsonStr3 = "{\"list\":[{\"fs_id\":3528850315,\"path\":\"/apps/yunform/music/hello\",\"ctime\":1331184269,\"mtime\":1331184269,\"block_list\":[\"59ca0efa9f5633cb0371bbc0355478d8\"],\"size\":13,\"isdir\":0}],\"request_id\":4043312670}";

		JSONParser parser3 = new JSONParser();
		try {
			JSONObject parseObject = (JSONObject) parser3.parse(jsonStr3);
			System.out.println("---->" + parseObject.toJSONString());
			System.out.println("---->" + parseObject.toString());
			System.out.println("---->" + parseObject.get("list"));
			System.out.println("---->"
					+ ((JSONArray) parseObject.get("list")).get(0));
			System.out.println("---->"
					+ ((JSONObject) ((JSONArray) parseObject.get("list"))
							.get(0)).get("path"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}