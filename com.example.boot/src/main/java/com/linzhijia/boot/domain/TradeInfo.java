package com.linzhijia.boot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TradeInfo {


	/**
	 * 交易 ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tradeId;
	
	/**
	 * 交易状态(0未支付(即待付款)，1支付中，2支付完成)
	 */
	@Column
	private Integer tradeState;
	
	/**
	 * 交易类型(0支付，1退款)
	 */
	@Column
	private Integer tradeType;
	
	/**
	 * 交易金额
	 */
	@Column
	private Double tradeAmount;
	
	/**
	 * 交易币种（0人民币 ，1美元）
	 */
	@Column
	private Integer tradeAmountType;
	
	/**
	 * 客户信息
	 */
	@ManyToOne
	private Customer customer;
	
	/**
	 * 创建时间
	 */
	@Column
	private Date tradeTime;
	
	
	public Integer getTradeId() {
		return tradeId;
	}
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}
	public Integer getTradeState() {
		return tradeState;
	}
	public void setTradeState(Integer tradeState) {
		this.tradeState = tradeState;
	}
	public Integer getTradeType() {
		return tradeType;
	}
	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}
	public Double getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(Double tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public Integer getTradeAmountType() {
		return tradeAmountType;
	}
	public void setTradeAmountType(Integer tradeAmountType) {
		this.tradeAmountType = tradeAmountType;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
}
