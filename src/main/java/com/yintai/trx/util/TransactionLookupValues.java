package com.yintai.trx.util;
public class TransactionLookupValues {
    
	//交易状态  成功:1 失败:2 等待付款3
	public static final int TRANSACTION_STATUS_SUCCESS = 1;
    public static final int TRANSACTION_STATUS_FAILED = 2;
    public static final int TRANSACTION_STATUS_PENDING = 3;
    
    //交易类型  任何类型:-1 支付:1 退款:2
    public static final int TRANSACTION_TYPE_ALL = -1;
    public static final int TRANSACTION_TYPE_PAYMENT = 1;
    public static final int TRANSACTION_TYPE_REFUND = 2;
    
    //货币类型  美元:1 人民币:2
    public static final int CURRENCY_TYPE_DOLLAR = 1;
    public static final int CURRENCY_TYPE_RMB = 2;
}
