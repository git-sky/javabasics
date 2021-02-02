package cn.com.json_tools.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.NameFilter;

import static org.junit.Assert.assertEquals;

/**
 * NameFilter 用于替换json的key。
 */
public class TestNameFilter {
    public static void main(String[] args) {

        User user = new User();
        user.setId(1);
        user.setName("name");

        NameFilter filter = new NameFilter() {
            @Override
            public String process(Object object, String name, Object value) {
                System.out.println("name=" + name + ",value=" + value);
                if (name.equals("name")) {
                    return "nt";
                }
                return name;
            }
        };

        // test for  JSON.toJSONString(user,filter);
        String jsonString = JSON.toJSONString(user, filter);
        System.out.println(jsonString);
        assertEquals("{\"id\":1,\"nt\":\"name\"}", jsonString);

        // test for jsonSerializer.getNameFilters().add(filter);
        JSONSerializer jsonSerializer = new JSONSerializer();
        jsonSerializer.getNameFilters().add(filter);
        jsonSerializer.write(user);
        jsonString = jsonSerializer.toString();
        System.out.println(jsonString);
        assertEquals("{\"id\":1,\"nt\":\"name\"}", jsonString);

    }
}


class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
