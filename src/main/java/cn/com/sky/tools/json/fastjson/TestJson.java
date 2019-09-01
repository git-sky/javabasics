package cn.com.sky.tools.json.fastjson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJson {

	public static void main(String[] args) {

		String metaData = "{\"recommendName\":\"达人推荐\",\"size\":5,\"fields\":[{\"name\":\"userId\",\"label\":\"达人id\",\"fieldType\":\"id\",\"inputType\":\"text\",\"dataType\":\"integer\",\"from\":\"user.handInput\",\"rule\":{\"isNumeric\":true,\"notNull\":true},\"isEditable\":true},{\"name\":\"fansNum\",\"label\":\"粉丝数\",\"inputType\":\"text\",\"dataType\":\"integer\",\"from\":\"sys.count\",\"keyPattern\":\"social:fans:{userId}:num\",\"rule\":{\"isNumeric\":true,\"notNull\":true},\"isEditable\":false},{\"name\":\"showPic\",\"label\":\"个人秀\",\"inputType\":\"img\",\"dataType\":\"String\",\"from\":\"jsonApi.post\",\"fetch\":\"pics\",\"rule\":{\"minLength\":1,\"maxLength\":500,\"notNull\":true},\"isEditable\":true},{\"name\":\"talentIcon\",\"label\":\"达人头像\",\"inputType\":\"img\",\"dataType\":\"string\",\"from\":\"jsonApi.expert\",\"fetch\":\"userPic\",\"rule\":{\"minLength\":1,\"maxLength\":500,\"notNull\":true},\"isEditable\":true},{\"name\":\"showPic\",\"label\":\"个人秀\",\"inputType\":\"img\",\"dataType\":\"String\",\"from\":\"jsonApi.post\",\"rule\":{\"notNull\":true},\"isEditable\":true},{\"name\":\"shareProducts\",\"label\":\"分享商品\",\"inputType\":\"img\",\"dataType\":\"array\",\"from\":\"jsonApi.post\",\"rule\":{\"minItems\":1,\"maxItems\":2,\"notNull\":true},\"isEditable\":true}],\"dataSources\":[{\"id\":\"expert\",\"type\":\"jsonApi\",\"urlPattern\":\"http://gome/expert.json?id={userId}\"},{\"id\":\"post\",\"type\":\"jsonApi\",\"urlPattern\":\"http://gome/post.json?postId={postId}&userId={userId}\"},{\"id\":\"count\",\"type\":\"sys\",\"urlPattern\":\"http://gome.redis/getData?userId={userId}\"}]}";
		
		JSONObject jsonObject = JSON.parseObject(metaData);
		JSONArray jsonArray = jsonObject.getJSONArray("fields");

		Map<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject json = jsonArray.getJSONObject(i);
			if (json.containsKey("keyPattern")) {
				map.put(String.valueOf(json.get("name")), String.valueOf(json.get("keyPattern")));
			}
		}

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}

	}
}
