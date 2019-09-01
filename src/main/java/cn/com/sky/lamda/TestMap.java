package cn.com.sky.lamda;


import cn.com.sky.tools.json.jackson.JsonUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestMap {

    @Test
    public void test() {

        Map<String, List<RealRoomMatchResult>> allRelationMap = Maps.newHashMap();

        for (int i = 0; i < 10; i++) {
            allRelationMap.put("a" + i, Lists.newArrayList(new RealRoomMatchResult(i), new RealRoomMatchResult(i + 1), new RealRoomMatchResult(i + 2)));
        }

        System.out.println(JsonUtils.object2Json(allRelationMap));


        List<Integer> realRoomIds = Lists.newArrayList();
        if (MapUtils.isNotEmpty(allRelationMap)) {
            allRelationMap.forEach((key, value) -> value.forEach(s -> realRoomIds.add(s.getRealRoomId())));
        }

        System.out.println(JsonUtils.object2Json(realRoomIds));

    }
}