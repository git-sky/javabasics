package cn.com.json_tools.jackson;


import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


/**
 * <pre>
 *
 * JsonNode 字符串类型：textValue 有效, asText 有效，toString 获取的结果带引号;
 *
 * JsonNode 数值类型：textValue 获得的是 null， asText 有效, toString 有效，各输出方式比较如下，附代码：
 *
 *   原始信息       toString()  asText()    textValue()     numberType()
 *    123           123         123         null	        INT
 *    123.456	    123.456	    123.456	    null	        DOUBLE
 *    "123.45600"	"123.45600"	123.456	    123.456	        null
 *    ""	            ""	 	                         	null
 *    "0"	        "0"     	0	        0	            null
 *    "null"	    "null"	    null	    null	        null
 *    null	         null	    null	    null	        null
 *
 *
 * </pre>
 */

public class TestJackson1 {

    public static void main(String[] args) {

        String str = "{\"data\":{\"number1\":123,\"number2\":123.45600,\"number3\":\"123.45600\""
                + ",\"number4\":\"\",\"number5\":\"0\",\"number6\":\"null\",\"number7\":null}}";

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(str);

            JsonNode data = root.path("data");

            for (int i = 1; i <= 7; i++) {
                String strNodeName = "number" + String.valueOf(i);

                if (data.has(strNodeName) == true) {
                    System.out.println(String.format("原始节点信息 %s", data.get(strNodeName)));

                    String str1 = data.get(strNodeName).toString();
                    System.out.println(String.format("toString() 输出: %s", str1));

                    String str2 = data.get(strNodeName).asText();
                    System.out.println(String.format("asText() 输出: %s", str2));

                    String str3 = data.get(strNodeName).textValue();
                    System.out.println(String.format("textValue() 输出: %s", str3));

                    NumberType str4 = data.get(strNodeName).numberType();
                    System.out.println(String.format("numberType() 显示: %s", str4));

                    System.out.println("-----------------------------------------------");
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}