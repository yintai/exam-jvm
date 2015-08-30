import java.util.Date;


public class TransRecord {

	private String tranId;//交易id
	private Date tranTime;//交易时间
	private int tranState;//交易状态 0：未完成  1：完成
	private String tranType;//交易类型 支付/退款
	private double tranAmount;//交易金额
	private String tranBZ;//交易币种
	private User user;//交易客户
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	public Date getTranTime() {
		return tranTime;
	}
	public void setTranTime(Date tranTime) {
		this.tranTime = tranTime;
	}
	public int getTranState() {
		return tranState;
	}
	public void setTranState(int tranState) {
		this.tranState = tranState;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public double getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(double tranAmount) {
		this.tranAmount = tranAmount;
	}
	public String getTranBZ() {
		return tranBZ;
	}
	public void setTranBZ(String tranBZ) {
		this.tranBZ = tranBZ;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
