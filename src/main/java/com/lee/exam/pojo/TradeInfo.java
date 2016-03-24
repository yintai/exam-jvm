package com.lee.exam.pojo;

import java.math.BigDecimal;
import java.util.Date;
/**
 * ������Ϣ
 * 
 * @author lilong
 *
 */
public class TradeInfo {

	/*���� ID ����ʱ����ķ�ʽ����*/
	private String ID = new Date().getTime()+""+((int)(1000+Math.random()*(1000-1+1)));
	
	/*
	 * ����ID
	 */
	private String tradeID ;
			
	
	/*����ʱ��*/
	private Date crateTime = new Date();
	
	/*����״̬ 0���������� 1���ɹ� 2��ʧ��*/
	private Byte tradeStatus;
	
	/*�������� 1:֧�� 2�˿�*/
	private Byte tradeType;
	
	/*���׽��*/
	private BigDecimal tradeMoney;
	
	/*���ױ��� 1������� 2����Ԫ */
	private Byte moneyType;

	/*�û�����ID
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
