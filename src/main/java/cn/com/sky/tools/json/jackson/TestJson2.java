package cn.com.sky.tools.json.jackson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class TestJson2 {


    @Test
    public void test() {
        List<Long> list = Lists.newArrayList();

        list.add(123L);
        list.add(456L);
        list.add(789L);
        String json = JsonUtils.object2Json(list);

        System.out.println(json);


        String fs = JSON.toJSONString(list);
        System.out.println(fs);
    }
}