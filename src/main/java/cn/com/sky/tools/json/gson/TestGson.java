package cn.com.sky.tools.json.gson;

import com.google.gson.Gson;

public class TestGson {

	public static void main(String[] args) {
		Gson gson = new Gson();
		int[] ints = {1, 2, 3, 4, 5};
		String[] strings = {"abc", "def", "ghi"};

		System.out.println(gson.toJson(ints));     // prints [1,2,3,4,5]
		System.out.println(gson.toJson(strings));  //prints ["abc", "def", "ghi"]
	}

}
