package com.yintai.exam.util;

public class Util {

	private Util() {
	}

	/**
	 * 判断字符串是否为空（这里的空包括null和空字符串和null字符串）
	 * 
	 * @param str
	 *            要判断的字符串
	 * @return 空返回true非空返回false
	 */
	public static boolean isNull(Object o) {
		if (o == null) {
			return true;
		}
		if ("".equals(o)) {
			return true;
		}
		if ("null".equals(o)) {
			return true;
		}
		return false;
	}
}
