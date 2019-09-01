package cn.com.sky.tools.serializable.fastjson.demo;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

public class TestSerializeWriter {

	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<>();
		map.put("name", "zhangsan");
		map.put("age", 12);
		map.put("isBoy", true);

		ResponseModel<Object> responseModel = new ResponseModel<>(map);
		responseModel.setIsGoods(true);

		SerializeWriter out = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(out);
		serializer.getNameFilters().add(FastjsonNameFilter.nameFilter);// 添加过滤器
		serializer.write(responseModel);
		String retJson = out.toString();

		System.out.println(retJson);
	}
}
