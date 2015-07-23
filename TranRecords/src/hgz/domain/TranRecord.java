package hgz.domain;

import java.util.Date;

public class TranRecord {
	
	
	private String tranRecordId;//交易 ID
	private Date  createDate;
	private String tranStatus;//交易状态（例如是否交易成功）
	private String tranType;//交易类型（例如支付还是退款）
	private int tranAmount;//交易金额  单位是分
	private String tranCurrency;//交易币种（例如美元还是人民币）
	private UserInfo user;//客户信息
    
	public String getTranRecordId() {
		return tranRecordId;
	}
	public void setTranRecordId(String tranRecordId) {
		this.tranRecordId = tranRecordId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getTranStatus() {
		return tranStatus;
	}
	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public int getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(int tranAmount) {
		this.tranAmount = tranAmount;
	}
	public String getTranCurrency() {
		return tranCurrency;
	}
	public void setTranCurrency(String tranCurrency) {
		this.tranCurrency = tranCurrency;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
    
    
    
}
