package cn.com.sky.alpha_work;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 业务辅助类
 */
public class BusinessUtil {

    private static final Logger logger = LoggerFactory.getLogger(BusinessUtil.class);

    /**
     * @param x map字符串 比如：{1={1=20},4={1=3}} { level有多少级={第几个人=返多少}} get 4
     * @return
     * @Description : 2级字符串转Map 用于使用 返利几级计算规则返回规则Map
     */
    public static Map<Integer, Map<Integer, Integer>> calcString2Map(String x) {
        Map<Integer, Map<Integer, Integer>> map = Maps.newHashMap();
        if (StringUtils.isBlank(x)) {
            return map;
        }
        String context = x.substring(1, x.length() - 1);
        System.out.println("context:" + context);
        calcMaps(map, context);
        return map;
    }

    /**
     * 平台分成支持小数
     *
     * @param x
     * @return
     */
    public static Map<Integer, Map<Integer, Double>> calcString2DMap(String x) {
        Map<Integer, Map<Integer, Double>> map = Maps.newHashMap();
        if (StringUtils.isBlank(x)) {
            return map;
        }
        String context = x.substring(1, x.length() - 1);
        calcDMaps(map, context);
        return map;
    }

    private static void calcMaps(Map<Integer, Map<Integer, Integer>> map, String context) {
        int i = context.indexOf("={");
        int i2 = context.indexOf("}");
        Map<Integer, Integer> subMap = Maps.newHashMap();
        String substring = context.substring(0, i);
        String substring1 = context.substring(i + 2, i + i2 - 1);
        String[] split = substring1.split(",\\s|,");
        for (String c2 : split) {
            int indexOf2 = c2.indexOf("=");
            String key2 = c2.substring(0, indexOf2);
            String value2 = c2.substring(indexOf2 + 1);
            subMap.put(Integer.valueOf(StringUtils.trim(key2)), Integer.valueOf(StringUtils.trim(value2)));
        }
        map.put(Integer.valueOf(substring), subMap);
        int i1 = context.indexOf("}, ");
        if (i1 == -1)
            return;
        String newStr = context.substring(i1 + 3, context.length());
        calcMaps(map, newStr);
    }

    /**
     * 平台分成支持小数
     *
     * @param map
     * @param context
     */
    private static void calcDMaps(Map<Integer, Map<Integer, Double>> map, String context) {
        int i = context.indexOf("={");
        int i2 = context.indexOf("}");
        Map<Integer, Double> subMap = Maps.newHashMap();
        String substring = context.substring(0, i);
        String substring1 = context.substring(i + 2, i + i2 - 1);
        String[] split = substring1.split(",\\s|,");
        for (String c2 : split) {
            int indexOf2 = c2.indexOf("=");
            String key2 = c2.substring(0, indexOf2);
            String value2 = c2.substring(indexOf2 + 1);
            subMap.put(Integer.valueOf(key2), Double.valueOf(value2));
        }
        map.put(Integer.valueOf(substring), subMap);
        int i1 = context.indexOf("}, ");
        if (i1 == -1)
            return;
        String newStr = context.substring(i1 + 3, context.length());
        calcDMaps(map, newStr);
    }

    /**
     * <pre>
     *
     * @param x map字符串 比如：{1={1=20},4={1=3}} { level有多少级={第几个人=返多少}}  {分享链的层级={返利的层级=分成比例}}
     * @param level 通过level找出对应的分享信息
     *
     * <p/>
     *
     *          examples:
     *          x: {1={1=20, 2=80}, 2={1=20, 2=45, 3=35}, 3={1=20, 2=35, 3=30, 4=15}, 4={1=20, 2=25, 3=25, 4=15, 5=15}, 5={1=20, 2=25, 3=25, 4=10, 5=10, 6=10}}
     *          level: 4
     *          return: {1=20, 2=25, 3=25, 4=15, 5=15}
     *
     * <p/>
     * </pre>
     */
    public static Map<Integer, Integer> calcString2Map(String x, Integer level) {
        Map<Integer, Map<Integer, Integer>> map = calcString2Map(x);
        int size = map.size();
        if (level > size) {
            level = size;
        }
        Map<Integer, Integer> map2 = map.get(level);
        return map2;
    }

    public static void main(String[] args) {
        //
        // Long estimateAmount = -1l;
        // String str =
        // "{1={1=100}, 2={1=50, 2=50}, 3={1=33, 2=33, 3=34}, 4={1=25, 2=25, 3=25, 4=25}}";
        // Map<Integer, Map<Integer, Integer>> integerMapMap = calcString2Map(str);
        // System.out.println(integerMapMap);
        // System.out.println(calcString2Map(integerMapMap.toString()));
        // BusinessUtil.checkParam(-1l != estimateAmount,
        // String.format("调用会员系统出错 orderId:%s,message:%s", 111, "abc"),
        // CheckParamType.GreaterThanFlase);

        /*
         * Map all=new HashMap(); BusinessUtil.checkParam(new Object[] {all}, "订单数据参数");
         */
        /*
         * String str = "{1={1=20},2={1=3}}"; Map map = calcString2Map(str,1); Set<Integer> key =
         * map.keySet(); for (Iterator<Integer> it = key.iterator(); it.hasNext();) { Integer s =
         * it.next(); System.out.println(s + ":" + map.get(s)); }
         */

        // String str = "{0={0=100}, 1={0=40, 1=60}}";
        // String str = "{0={0=100}}";
//		String str = "{0={0=100}, 1={0=40, 1=60}, 2={0=30, 1=20, 2=50}, 3={0=25, 1=10, 2=15, 3=50}, 4={0=20, 1=10, 2=10, 3=10, 4=50}}";
        String str =
                "{1={1=100}, 2={1=50, 2=50}, 3={1=33, 2=33, 3=34}, 4={1=25, 2=25, 3=25, 4=25}}";
        Map<Integer, Map<Integer, Integer>> map = Maps.newHashMap();
        if (!StringUtils.isEmpty(str)) {
            map = BusinessUtil.calcString2Map(str);
        }

        System.out.println(map);

        Map<Integer, Integer> map2 = Maps.newHashMap();

        map2 = BusinessUtil.calcString2Map(str, 2);

        System.out.println(map2);// 2={0=30, 1=20, 2=50}

        // Map<Integer, Integer> rebateOne = map.get(Integer.valueOf(1)); // 获取返利层级的第2级
        // System.out.println(rebateOne);
        // Integer remainRatio = MapUtils.getInteger(rebateOne, Integer.valueOf(1), 0);
        // //减去平台比例后的剩余比例
        // System.out.println(remainRatio);
        // // Integer remainRatio2 = MapUtils.getInteger(rebateOne, Integer.valueOf(2), 0);
        // //减去平台比例后的剩余比例
        // // System.out.println(remainRatio2);
        //
        // float rat = MoneyScaleUtil.getCalcResult(new BigDecimal(5200), new BigDecimal(remainRatio
        // * 0.01),
        // MoneyScaleUtil.Operator.multiply, 4).floatValue();
        // System.out.println(rat);
        //
//		String s = "{1={100=10}, 2={200=20}}";
//		Map<String, Map<String, Integer>> transLevelMap = transLevelMap(s);
//		int amount = getLevelValue(transLevelMap, 200);
//		System.out.println(amount);
//
//		String activityLevel = getActivityLevel(transLevelMap, 10, 100);
//		System.out.println("当前层级：" + activityLevel);

    }


    /***
     * 传入levelrulemap 和 当前待入账值 得到阶梯返利总额
     *
     * @param levelmap
     * @param estimationCount
     * @return
     */
    public static int getLevelValue(Map<String, Map<String, Integer>> levelmap, long estimationCount) {
        int retValue = 0;
        for (int i = 1; i <= levelmap.size(); i++) {
            Map<String, Integer> map = levelmap.get(i + "");
            Set<String> keySet = map.keySet();
            for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext(); ) {
                String integer = iterator.next();
                if (estimationCount == Integer.parseInt(integer)) {
                    retValue += map.get(integer);
                }
            }
        }
        return retValue;
    }

    public static String getActivityLevel(Map<String, Map<String, Integer>> levelmap, Integer amount, Integer quantity) {
        Map<String, Integer> value = new HashMap<String, Integer>();
        value.put(quantity.toString(), amount);
        for (String level : levelmap.keySet()) {
            if (levelmap.get(level).equals(value)) {
                return level;
            }
        }
        return null;
    }

    /***
     * 传入levelrule 字符串转换成 map
     *
     * @param levelRule
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Map<String, Integer>> transLevelMap(String levelRule) {
        if (null == levelRule || "".equals(levelRule)) {
            return null;
        }
        levelRule = levelRule.replace("=", ":");
        Map<String, Map<String, Integer>> parse = (Map<String, Map<String, Integer>>) JSONObject.parse(levelRule);
        return parse;
    }


}
