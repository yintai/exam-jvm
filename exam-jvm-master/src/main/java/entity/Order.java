package entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Order")
public class Order {

    private long id;
	private Date createTime;
	/**
	 *订单状态
	 *0：表示交易(等待付款)
	 *1：表示交易成功
	 */
	private int state;
	/**
	 *订单类型
	 *0：支付
	 *1：退款
	 */
	private int type;

	private double money;

	/**
	 *币种
	 *0：美元
	 *1：人民币
	 */
	private int moneyType;

	/**
	 *客户信息
	 */
	private String info;

    public Order() {  
        super();  
    } 
    public Order(Date createTime,int state,int type,long money,int moneyType,String info) {
		this.createTime = createTime;
		this.state = state;
		this.type = type;
		this.money = money;
		this.moneyType = moneyType;
        this.info = info;
    }


	public long getId() {
		return id;
	}

	@XmlElement
	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}
	  @XmlElement
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getState() {
		return state;
	}
	  @XmlElement
	public void setState(int state) {
		this.state = state;
	}

	public int getType() {
		return type;
	}
	  @XmlElement
	public void setType(int type) {
		this.type = type;
	}

	public double getMoney() {
		return money;
	}
	  @XmlElement
	public void setMoney(double money) {
		this.money = money;
	}

	public int getMoneyType() {
		return moneyType;
	}

	@XmlElement
	public void setMoneyType(int moneyType) {
		this.moneyType = moneyType;
	}

	public String getInfo() {
		return info;
	}
	  @XmlElement
	public void setInfo(String info) {
		this.info = info;
	}

}
