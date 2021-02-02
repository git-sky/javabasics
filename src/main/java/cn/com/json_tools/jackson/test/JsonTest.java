package cn.com.json_tools.jackson.test;

import cn.com.json_tools.fastjson.domain.Men;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonTest {

    @Test
    public void test1() throws IOException {

        User user1 = new User("zhangsan", 18, new Date(), "110");
        User user2 = new User("zhangsan", 18, new Date(), "110");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        // 转换器
        ObjectMapper mapper = new ObjectMapper();

        // 将对象转换成json
        String json = mapper.writeValueAsString(user1);

        System.out.println(json);


        // 将json 字符串转成User类
        User user = mapper.readValue(json, User.class);

        System.out.println(user.getName());
        System.out.println(user.getBirthday());
    }


    @Test
    public void test2() throws IOException {
        Men men = new Men();
        men.set_name("哈哈");
        men.set_age(11);

        // 转换器
        ObjectMapper mapper = new ObjectMapper();

        // 将对象转换成json
        String json = mapper.writeValueAsString(men);

        System.out.println(json);


        // 将json 字符串转成User类
        Men men2 = mapper.readValue(json, Men.class);

        System.out.println(men2.get_name());
        System.out.println(men2.get_age());
    }


    @Test
    public void test() throws IOException, ParseException {


        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User("lisi", 18, dateformat.parse("1996-10-01"), "110");

        //转换器
        ObjectMapper mapper = new ObjectMapper();

        //User类转JSON 字符串
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        //Java集合转JSON 字符串
        List<User> users = new ArrayList<>();
        users.add(user);
        String jsonlist = mapper.writeValueAsString(users);
        System.out.println(jsonlist);
    }
}