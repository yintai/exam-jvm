package com.yintai.exam.enums;

/**
 * 订单交易状态
 */
public enum OrderState {

	WAIT_PAYMENT(0, "等待付款"), SUCCESS(1, "交易成功");

	private int value;
	private String stateName;

	private OrderState(int value, String stateName) {
		this.value = value;
		this.stateName = stateName;
	}

	// 普通方法拿到value值
	public static OrderState getOrderState(int value) {
		for (OrderState orderState : OrderState.values()) {
			if (orderState.getValue() == value) {
				return orderState;
			}
		}
		return null;
	}

	// 普通方法拿到字符串值
	public static String getStateName(int value) {
		for (OrderState c : OrderState.values()) {
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

	public static void main(String[] args) {
		System.out.println(OrderState.getStateName(1));
		System.out.println(SUCCESS.getValue());
		System.out.println(WAIT_PAYMENT.getStateName());
	}
}
