package com.yintai.exam.util;

import java.math.BigDecimal;

/**
 * 金额的加减乘除,金额的数据类型可以为String，也可以为BigDecimal，传入之后自动识别
 * 
 * @author 刘腾飞
 */
public class MathMoney {

	// 这个类不能实例化
	private MathMoney(){
		throw new RuntimeException("哥们这个类是不能从外部实例化的");
	}

	/**
	 * 提供精确的乘法运算. 如果传入参数有一个为null返回结果为零
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal multiply(Object v1, Object v2) {
		if (v1 == null || v2 == null || v1 == "" || v2 == "") {
			return new BigDecimal("0");
		}
		BigDecimal b1 = null;
		BigDecimal b2 = null;
		if (v1 instanceof String) {
			b1 = new BigDecimal(String.valueOf(v1));
		}
		if (v2 instanceof String) {
			b2 = new BigDecimal(String.valueOf(v2));
		}
		if (v1 instanceof BigDecimal) {
			b1 = (BigDecimal) v1;
		}
		if (v2 instanceof BigDecimal) {
			b2 = (BigDecimal) v2;
		}
		return b1.multiply(b2);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。 如果传入参数有一个为null返回结果为零
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static BigDecimal divide(Object v1, Object v2, int scale) {
		if (v1 == null || v2 == null) {
			return new BigDecimal("0");
		}
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = null;
		BigDecimal b2 = null;
		if (v1 instanceof String) {
			b1 = new BigDecimal(String.valueOf(v1));
		}
		if (v2 instanceof String) {
			b2 = new BigDecimal(String.valueOf(v2));
		}
		if (v1 instanceof BigDecimal) {
			b1 = (BigDecimal) v1;
		}
		if (v2 instanceof BigDecimal) {
			b2 = (BigDecimal) v2;
		}
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 比较两个金额的大小
	 * 
	 * @author 刘腾飞
	 * @param v1
	 * @param v2
	 * @return -1:v2>v1 <br/>
	 *         0：v1=v2 <br/>
	 *         1：v1>v2
	 */
	public static int compare_moneyObj(Object v1, Object v2) {
		BigDecimal b1 = null;
		BigDecimal b2 = null;
		if (v1 instanceof String) {
			if (Util.isNull(v1)) {
				v1 = "0";
			}
			b1 = new BigDecimal(String.valueOf(v1));
		}
		if (v1 instanceof BigDecimal) {
			b1 = (BigDecimal) v1;
		}
		if (v2 instanceof String) {
			if (Util.isNull(v2)) {
				v2 = "0";
			}
			b2 = new BigDecimal(String.valueOf(v2));
		}
		if (v2 instanceof BigDecimal) {
			b2 = (BigDecimal) v2;
		}
		return b1.compareTo(b2);
	}

	/**
	 * 金额验证
	 * 
	 * @param money
	 *            要验证的金额，参数可以是BigDecimal或者String类型
	 * @return
	 */
	public static boolean isNumber(Object money) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
		java.util.regex.Matcher match = pattern.matcher(money.toString());
		return match.matches();
	}
}
