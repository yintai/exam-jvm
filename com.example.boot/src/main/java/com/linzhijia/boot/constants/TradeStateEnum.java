package com.linzhijia.boot.constants;


public enum TradeStateEnum {
	/**
	 * 交易状态(0未支付(即待付款)，1支付中，2支付完成)
	 */
	
	PAYING_STATE(1,"支付中"),
	UNPAY_STATE(0,"待付款"),
	PAID_STATE(2,"支付完成"),
	UNEXCEPTION_STATE(3,"其他异常状态"),
	ALL_STATE(-1,"其他异常状态");
	
	private Integer tradeStateCode;//交易状态值
	private String tradeStateMsg;//交易状态值描述
	
	
	private TradeStateEnum(Integer tradeStateCode,String tradeStateMsg){
		this.tradeStateCode = tradeStateCode;
		this.tradeStateMsg = tradeStateMsg;
	}
	
	public Integer getTradeStateCode(){
		return tradeStateCode;
	}
	
	public String getTradeStateMsg(){
		return tradeStateMsg;
	}
	public static TradeStateEnum getEnumByCode(Integer typeNum){
		for(TradeStateEnum curEnum:values()){
			if(curEnum.tradeStateCode.equals(typeNum)){
				return curEnum;
			}
		}
		return UNEXCEPTION_STATE;
	}
}
