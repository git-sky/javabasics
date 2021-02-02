package cn.com.sky.collections.list;

import cn.com.json_tools.jackson.JsonUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class TestReplace {

    @Test
    public void test() {
        List<AttrInfo> attrInfos = Lists.newArrayList();
        for (Integer i = 101128; i < 101138; i++) {
            attrInfos.add(new AttrInfo(Integer.valueOf(i), "name" + i));
        }

        change(attrInfos);

        System.out.println("-------------");

        System.out.println(attrInfos);

    }

    private List<AttrInfo> change(List<AttrInfo> attrInfos) {


        Map<Integer, String> serviceAttrMap = Maps.newHashMap();
        serviceAttrMap.put(Integer.valueOf(101128), "comcom");

        for (AttrInfo attrInfo : attrInfos) {
            String showName = serviceAttrMap.getOrDefault(attrInfo.getAttrId(), attrInfo.getAttrName());
            attrInfo.setAttrName(showName);
        }

        for (AttrInfo attrInfo : attrInfos) {
            System.out.println(JsonUtils.object2Json(attrInfo));
        }

        return attrInfos;
    }

}