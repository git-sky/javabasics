package cn.com.sky.collections.map;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Map;

public class TsMap {

	@Test
	public void test() {

	    Map<String,String> map= Maps.newHashMap();
	    map.put(null,null);

        System.out.println(map.get("qwe"));

        System.out.println(StringUtils.isEmpty(map.get("aa")));
    }
}
