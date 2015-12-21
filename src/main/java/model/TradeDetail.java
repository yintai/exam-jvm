package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7627760211121700883L;
	// --交易信息包含「交易 ID」、「创建时间」、「交易状态（例如是否交易成功）」、「交易类型（例如支付还是退款）」、「交易金额」、
	// --「交易币种（例如美元还是人民币）」、「客户信息」
	private Long id;
	private String name;
	private Long userid;
	private Integer tradestatus;
	private Integer tradetype;
	private BigDecimal trademoney;
	private Integer trademoneytype;
	private Date createdat;

	public TradeDetail() {
		// TODO Auto-generated constructor stub
	}

	public TradeDetail(Long id, String name, Long customerid, Integer tradestatus, Integer tradetype,
			BigDecimal trademoney, Integer trademoneytype, Date createdat) {
		super();
		this.id = id;
		this.name = name;
		this.userid = customerid;
		this.tradestatus = tradestatus;
		this.tradetype = tradetype;
		this.trademoney = trademoney;
		this.trademoneytype = trademoneytype;
		this.createdat = createdat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCustomerid() {
		return userid;
	}

	public void setCustomerid(Long customerid) {
		this.userid = customerid;
	}

	public Integer getTradestatus() {
		return tradestatus;
	}

	public void setTradestatus(Integer tradestatus) {
		this.tradestatus = tradestatus;
	}

	public Integer getTradetype() {
		return tradetype;
	}

	public void setTradetype(Integer tradetype) {
		this.tradetype = tradetype;
	}

	public BigDecimal getTrademoney() {
		return trademoney;
	}

	public void setTrademoney(BigDecimal trademoney) {
		this.trademoney = trademoney;
	}

	public Integer getTrademoneytype() {
		return trademoneytype;
	}

	public void setTrademoneytype(Integer trademoneytype) {
		this.trademoneytype = trademoneytype;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}


}
