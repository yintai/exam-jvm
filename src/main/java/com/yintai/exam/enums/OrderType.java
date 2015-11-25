package com.yintai.exam.enums;

/**
 * 订单交易类型
 */
public enum OrderType {

	REFUND(0, "退款"), PAYMENT(1, "支付");

	private int value;
	private String stateName;

	private OrderType(int value, String stateName) {
		this.value = value;
		this.stateName = stateName;
	}

	// 普通方法拿到value值
	public static OrderType getOrderState(int value) {
		for (OrderType orderState : OrderType.values()) {
			if (orderState.getValue() == value) {
				return orderState;
			}
		}
		return null;
	}

	// 普通方法拿到字符串值
	public static String getStateName(int value) {
		for (OrderType c : OrderType.values()) {
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
