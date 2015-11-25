package com.yintai.exam.enums;

/**
 * 订单交易币种
 */
public enum OrderCurrency {

	RMB(1, "人民币"), US(2, "美元");

	private int value;
	private String stateName;

	private OrderCurrency(int value, String stateName) {
		this.value = value;
		this.stateName = stateName;
	}

	// 普通方法拿到value值
	public static OrderCurrency getOrderState(int value) {
		for (OrderCurrency orderState : OrderCurrency.values()) {
			if (orderState.getValue() == value) {
				return orderState;
			}
		}
		return null;
	}

	// 普通方法拿到字符串值
	public static String getStateName(int value) {
		for (OrderCurrency c : OrderCurrency.values()) {
			if (c.getValue() == value) {
				return c.stateName;
			}
		}
		return null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return String.valueOf(this.getValue());
	}
}
