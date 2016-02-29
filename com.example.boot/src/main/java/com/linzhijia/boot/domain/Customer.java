package com.linzhijia.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	/**
	 * 客户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	/**
	 * 客户姓名
	 */
	@Column
	private String customerName;
	
	/*@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
	private List<TradeInfo> trades;*/
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}

	public Customer() {
		super();
	}

	/*public List<TradeInfo> getTrades() {
		return trades;
	}

	public void setTrades(List<TradeInfo> trades) {
		this.trades = trades;
	}*/

	
	
}
