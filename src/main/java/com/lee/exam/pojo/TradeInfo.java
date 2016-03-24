package com.lee.exam.pojo;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 交易信息
 * 
 * @author lilong
 *
 */
public class TradeInfo {

	/*主键 ID 采用时间戳的方式生成*/
	private String ID = new Date().getTime()+""+((int)(1000+Math.random()*(1000-1+1)));
	
	/*
	 * 交易ID
	 */
	private String tradeID ;
			
	
	/*创建时间*/
	private Date crateTime = new Date();
	
	/*交易状态 0：待付货款 1：成功 2：失败*/
	private Byte tradeStatus;
	
	/*交易类型 1:支付 2退款*/
	private Byte tradeType;
	
	/*交易金额*/
	private BigDecimal tradeMoney;
	
	/*交易币种 1：人民币 2：美元 */
	private Byte moneyType;

	/*用户对象ID
	 */
	private UserInfo userInfo;
	
	//getters setters
	public String getTradeID() {
		return tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public Date getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}

	public Byte getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(Byte tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public Byte getTradeType() {
		return tradeType;
	}

	public void setTradeType(Byte tradeType) {
		this.tradeType = tradeType;
	}

	
	public BigDecimal getTradeMoney() {
		return tradeMoney;
	}

	public void setTradeMoney(BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public Byte getMoneyType() {
		return moneyType;
	}

	public void setMoneyType(Byte moneyType) {
		this.moneyType = moneyType;
	}

 
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	
	
	
	
}
