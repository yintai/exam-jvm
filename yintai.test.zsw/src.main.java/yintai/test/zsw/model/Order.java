package yintai.test.zsw.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order  {
	/**
	 * 「交易 ID」、「创建时间」、「交易状态（例如是否交易成功）」、「交易类型（例如支付还是退款）」、
	 * 「交易金额」、「交易币种（例如美元还是人民币）」、「客户信息」
		客户信息包含「客户 ID」、「客户姓名」即可
	 */
	private String id;
	private Date createTime;
	private Integer payStatus;//1：等待付款 2：交易成功  3:交易失败
	private Integer payType;//1:支付 2：退款
	private BigDecimal money;
	private Integer moneyType;//1：美元 2：
	private User user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Integer getMoneyType() {
		return moneyType;
	}
	public void setMoneyType(Integer moneyType) {
		this.moneyType = moneyType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
