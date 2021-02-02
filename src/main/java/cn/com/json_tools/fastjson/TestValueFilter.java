package cn.com.json_tools.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * ValueFilter 用于替换json的value。
 * 使用 ValueFilter 过滤输出的结果。
 * 使用场景：日志脱敏。
 */
public class TestValueFilter {

    public static void main(String[] args) {
        MyObject obj = new MyObject();
        obj.setName("YR");
        obj.setMobile("15977198020");
        obj.setAdminCard("adfasdicadfdf");
        System.out.println(JSON.toJSONString(obj, new SimpleValueFilter()));
        System.out.println(JSON.toJSONString(obj));

    }
}

class MyObject {
    private String name;
    private String mobile;
    private String adminCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAdminCard() {
        return adminCard;
    }

    public void setAdminCard(String adminCard) {
        this.adminCard = adminCard;
    }
}


class SimpleValueFilter implements ValueFilter {
    @Override
    public Object process(Object object, String name, Object value) {
        // 只要字段名中包含mobile，则值输出为一串星号
        if (name.toLowerCase().contains("mobile")) {
            return "****";
        }
        return value;
    }
}
