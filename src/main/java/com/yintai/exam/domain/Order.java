package com.yintai.exam.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	private Long id;
	private Long customerno;
	private String orderno;
	private Date createdate;
	private Integer status;// 交易状态 0失败 1成功
	private Integer type;// 交易类型 0退款 1支付
	private BigDecimal money;
	private Integer currency;// 交易币种 1人民币 2美元

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerno() {
		return customerno;
	}

	public void setCustomerno(Long customerno) {
		this.customerno = customerno;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerno=" + customerno + ", orderno=" + orderno + ", createdate=" + createdate
				+ ", status=" + status + ", type=" + type + ", money=" + money + ", currency=" + currency + "]";
	}
}
