package com.sample.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: liuwang
 * Date: 15-6-25
 * Time: 上午1:00
 * To change this template use File | Settings | File Templates.
 */
public class Business {
    /**
     * 交易记录，交易信息包含「交易 ID」、「创建时间」、「交易状态（例如是否交易成功）」、「交易类型（例如支付还是退款）」、「交易金额」、
     * 「交易币种（例如美元还是人民币）」、「客户信息」
     */

    private  Integer id;
    private Date  createTime;//创建时间
    private String status; //交易状态
    private String type; //交易类型
    private Double money; //交易金额
    private String currency;  //交易币种
    private Integer customerId; //客户ID
    private String customerName;//客户姓名

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String toStr(){
        StringBuffer sb=new StringBuffer() ;
        sb.append("id:").append(this.id) ;
        sb.append(" createTime:").append(this.createTime.toString()) ;
        sb.append(" status:").append(this.status) ;
        sb.append(" type:").append(this.type) ;
        sb.append(" money:").append(this.money) ;
        sb.append(" currency:").append(this.currency) ;
        sb.append(" customerId:").append(this.customerId) ;
        sb.append(" customerName:").append(this.customerName) ;
         return sb.toString();
    }
}
