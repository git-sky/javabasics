package cn.com.aviator;


import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import org.junit.Test;

import java.util.Map;

public class AviatorEvaluatorTest {

    @Test
    public void test() {
        Map<String, Object> mapParam = Maps.newHashMap();
        mapParam.put("pre_3_1000007", "abcde");
        boolean flag = (Boolean) AviatorEvaluator.execute("pre_3_1000007!=nil&&string.length(pre_3_1000007)>4", mapParam, true);
        System.out.println(flag);

        Map<String, Object> param2 = Maps.newHashMap();
        boolean flag2 = (Boolean) AviatorEvaluator.execute("pre_3_1000007!=nil", param2, true);
        System.out.println(flag2);
    }

    @Test
    public void test2(){

        Map<String, Object> mapParam = Maps.newHashMap();
        mapParam.put("pre_0_1000087", 0);
        mapParam.put("pre_0_1000008",209);
        boolean flag = (Boolean) AviatorEvaluator.execute("stringToNumber(pre_0_1000008)==209&&stringToNumber(pre_0_1000087)==0", mapParam, true);
        System.out.println(flag);


    }

}