//package cn.com.sky.alpha_work;
//
//import java.math.BigDecimal;
//import java.util.Map;
//
//import cn.com.sky.alpha_work.MoneyScaleUtil.Operator;
//
//import com.google.common.collect.Maps;
//import com.taobao.diamond.utils.JSONUtils;
//
//public class MapUtils {
//
//	public static void main(String[] args) {
//
//		// {1={1=100}, 2={1=50, 2=50}, 3={1=33, 3=34, 2=33}, 4={1=25, 3=25, 2=25, 4=25}}
//
//		// {1={1=20, 2=80}, 2={1=20, 2=45, 3=35}, 3={1=20, 2=35, 3=30, 4=15}, 4={1=20, 2=25, 3=25,
//		// 4=15, 5=15}, 5={1=20, 2=25, 3=25, 4=10, 5=10, 6=10}}
//
//		Map<Integer, Map<Integer, Integer>> soureMaps = Maps.newHashMap();
//
//		Map<Integer, Integer> m1 = Maps.newHashMap();
//		m1.put(1, 100);
//		soureMaps.put(1, m1);
//
//		Map<Integer, Integer> m2 = Maps.newHashMap();
//		m2.put(1, 50);
//		m2.put(2, 50);
//		soureMaps.put(2, m2);
//
//		Map<Integer, Integer> m3 = Maps.newHashMap();
//		m3.put(1, 33);
//		m3.put(2, 33);
//		m3.put(3, 34);
//		soureMaps.put(3, m3);
//
//		Map<Integer, Integer> m4 = Maps.newHashMap();
//		m4.put(1, 25);
//		m4.put(2, 25);
//		m4.put(3, 25);
//		m4.put(4, 25);
//		soureMaps.put(4, m4);
//
//		try {
//			System.out.println(JSONUtils.serializeObject(soureMaps));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		Map<Integer, Map<Integer, Double>> targetMaps = new MapUtils().changeRatioMaps(1234, soureMaps);
//		try {
//			System.out.println(JSONUtils.serializeObject(targetMaps));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public Map<Integer, Map<Integer, Double>> changeRatioMaps(Integer platRatio, Map<Integer, Map<Integer, Integer>> soureMaps) {
//
//		Integer shopRatio = 10000 - platRatio;// 商家比例
//
//		Map<Integer, Map<Integer, Double>> targetMaps = Maps.newHashMap();
//
//		for (Map.Entry<Integer, Map<Integer, Integer>> entry : soureMaps.entrySet()) {
//			Integer key = entry.getKey();
//			Map<Integer, Integer> innerMap = entry.getValue();
//
//			Map<Integer, Double> targetInnerMap = Maps.newHashMap();
//			for (Map.Entry<Integer, Integer> innerEntry : innerMap.entrySet()) {
//				Integer inKey = innerEntry.getKey();
//				Integer inVal = innerEntry.getValue();
//				BigDecimal targetValue = MoneyScaleUtil.getCalcResult2(new BigDecimal(inVal),
//						MoneyScaleUtil.getCalcResult(new BigDecimal(shopRatio), new BigDecimal("0.0001"), Operator.multiply,4), Operator.multiply);
//				targetInnerMap.put(inKey + 1, targetValue.doubleValue());
//			}
//			targetInnerMap.put(1, MoneyScaleUtil.getCalcResult2(new BigDecimal(platRatio), new BigDecimal("0.01"), Operator.multiply).doubleValue());
//
//			targetMaps.put(key, targetInnerMap);
//
//		}
//
//		return targetMaps;
//	}
//
//}