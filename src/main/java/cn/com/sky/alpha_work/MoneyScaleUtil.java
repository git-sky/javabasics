package cn.com.sky.alpha_work;

import java.math.BigDecimal;

/**
 * 格式化货币
 *
 * @author zhangyinhu
 * @date 2015-3-23 上午11:51:28
 */
public class MoneyScaleUtil {

	/**
	 * 设置价格精确位数
	 *
	 * @param money
	 *            钱
	 */
	public static BigDecimal setMoneyScale(BigDecimal money) {
		if (money != null) {
			Integer priceScale = 0;// 精确位数
			RoundType priceRoundType = RoundType.roundHalfUp;// 精确方式
			return round(money, priceScale, priceRoundType);
		}
		return null;
	}

	private static BigDecimal round(BigDecimal money, Integer priceScale, RoundType priceRoundType) {
		if (priceRoundType == RoundType.roundHalfUp) {
			return money.setScale(priceScale, BigDecimal.ROUND_HALF_UP);
		} else if (priceRoundType == RoundType.roundUp) {
			return money.setScale(priceScale, BigDecimal.ROUND_UP);
		} else {
			return money.setScale(priceScale, BigDecimal.ROUND_DOWN);
		}
	}

	/**
	 * 设置价格精确位数
	 *
	 * @param money
	 *            钱
	 */
	public static BigDecimal setMoneyScale2(BigDecimal money) {
		if (money != null) {
			Integer priceScale = 2;// 精确位数
			RoundType priceRoundType = RoundType.roundHalfUp;// 精确方式
			return round(money, priceScale, priceRoundType);
		}
		return null;
	}

	/****
	 * 加减乘除
	 *
	 * @param param1
	 *            分子
	 * @param param2
	 *            分母
	 * @param perator
	 *            操作类型
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal getCalcResult2(BigDecimal param1, BigDecimal param2, Operator perator) {
		BigDecimal bd = operate(param1, param2, perator);
		// 调取格式化 保留两位小数
		return setMoneyScale2(bd);
	}

	/****
	 * 加减乘除
	 *
	 * @param param1
	 *            分子
	 * @param param2
	 *            分母
	 * @param perator
	 *            操作类型
	 * @return {@link BigDecimal}
	 */
	public static BigDecimal getCalcResult(BigDecimal param1, BigDecimal param2, Operator perator) {
		BigDecimal bd = operate(param1, param2, perator);
		// 调取格式化 保留两位小数
		return setMoneyScale(bd);
	}

	public static BigDecimal getCalcResult(BigDecimal param1, BigDecimal param2, Operator perator, int scale) {
		BigDecimal bd = operate(param1, param2, perator);
		return setMoneyScale(bd, scale);
	}

	public static BigDecimal getCalcResultMaxScale(BigDecimal param1, BigDecimal param2, Operator perator) {
		return operate(param1, param2, perator);
	}

	private static BigDecimal operate(BigDecimal param1, BigDecimal param2, Operator perator) {
		BigDecimal bd = null;
		if (perator == Operator.add) {
			bd = param1.add(param2);
		} else if (perator == Operator.subtract) {
			bd = param1.subtract(param2);
		} else if (perator == Operator.multiply) {
			bd = param1.multiply(param2);
		} else if (perator == Operator.divide) {
			bd = param1.divide(param2, 0, BigDecimal.ROUND_HALF_UP);
		}
		return bd;
	}

	public static BigDecimal setMoneyScale(BigDecimal money, int scale) {
		if (money != null) {
			Integer priceScale = scale;// 精确位数
			RoundType priceRoundType = RoundType.roundHalfUp;// 精确方式
			return round(money, priceScale, priceRoundType);
		}
		return null;
	}

	public static void main(String[] args) {
		// BigDecimal price2 = new BigDecimal("2");
		// BigDecimal price = new BigDecimal("0.25");
		// System.out.println(getCalcResult(price, price2, Operator.multiply));
		//
		// float f = getCalcResult2(new BigDecimal(1200), new BigDecimal(80 * 0.01),
		// MoneyScaleUtil.Operator.multiply).floatValue();
		//
		// System.out.println(f);
		// System.out.println(f/10000);

		float rat = MoneyScaleUtil.getCalcResult(new BigDecimal(0.12), new BigDecimal(80 * 0.01), MoneyScaleUtil.Operator.multiply, 4).floatValue();
		System.out.println(rat);

	}

	// 小数位精确方式(四舍五入、向上取整、向下取整)
	public enum RoundType {
		roundHalfUp, roundUp, roundDown
	}

	// 运算符(加、减、乘、除)
	public enum Operator {
		add, subtract, multiply, divide
	}

}
