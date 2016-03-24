package com.lee.exam.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.lee.exam.MyContextUnitilsJUnit;
import com.lee.exam.dao.TradeInfoDao;
import com.lee.exam.dao.UserInfoDao;
import com.lee.exam.pojo.TradeInfo;
import com.lee.exam.pojo.UserInfo;
import com.lee.exam.service.impl.GetInfoByTradeStatusServiceImpl;

public class TestGetInfoByTradeStatusServiceImpl extends MyContextUnitilsJUnit{

	GetInfoByTradeStatusServiceImpl getInfoByTradeStatusServiceImpl;
	TradeInfoDao tradeInfoDao  ;
	UserInfoDao userInfoDao  ;
	
	
 
	
	//装载数据
	@Before
	public void init() throws Exception{
		//注入service 
		getInfoByTradeStatusServiceImpl = applicationContext.getBean("getInfoByTradeStatusServiceImpl",GetInfoByTradeStatusServiceImpl.class);
		tradeInfoDao = applicationContext.getBean("tradeInfoDaoImpl",TradeInfoDao.class);
		userInfoDao = applicationContext.getBean("userInfoDaoImpl",UserInfoDao.class);
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("张三");
		userInfoDao.insetUserInfo(userInfo);
		List<TradeInfo> list = new ArrayList<TradeInfo>();
		for(int i=0;i<5;i++){
			TradeInfo tradeInfo = new TradeInfo();
			tradeInfo.setMoneyType(Byte.parseByte("1"));
			if(i%2==0){//成功后的三条 失败的2条
				tradeInfo.setTradeStatus(Byte.parseByte("1"));
			}else{
				tradeInfo.setTradeStatus(Byte.parseByte("2"));
			}
			
			tradeInfo.setTradeType(Byte.parseByte("1"));
			tradeInfo.setTradeMoney(new BigDecimal(100*(i+1)));
			tradeInfo.setUserInfo(userInfo);
			tradeInfo.setTradeID((i+1)+"");
			list.add(tradeInfo);
		}
		
		tradeInfoDao.inserTradeInfoList(list);
	}
	
	/**
	 * 支付失败的
	 * @throws Exception
	 */
	@Test
	public void testDoControllerFail() throws Exception{
		Map<String, Object> reqBody = new HashMap<String, Object>();
		Map<String, Object> reqHead = new HashMap<String, Object>();
		reqBody.put("tradeStatus", 1);
		reqHead.put("transactionType", "getInfoByTradeStatus");
		Map<String, Object> map= getInfoByTradeStatusServiceImpl.doController(reqHead, reqBody, null);
		System.out.println(JSON.toJSONString(map));
		//断言。。。。
	}
	
	/**
	 * 支付成功的
	 * @throws Exception
	 */
	@Test
	public void testDoControllerSuccess() throws Exception{
		Map<String, Object> reqBody = new HashMap<String, Object>();
		Map<String, Object> reqHead = new HashMap<String, Object>();
		reqBody.put("tradeStatus", 2);
		reqHead.put("transactionType", "getInfoByTradeStatus");
		Map<String, Object> map= getInfoByTradeStatusServiceImpl.doController(reqHead, reqBody, null);
		System.out.println(JSON.toJSONString(map));
		//断言。。。
	}
	
	
	/**
	 * 所有的
	 * @throws Exception
	 */
	@Test
	public void testDoControllerAll() throws Exception{
		Map<String, Object> reqBody = new HashMap<String, Object>();
		Map<String, Object> reqHead = new HashMap<String, Object>();
		reqHead.put("transactionType", "getInfoByTradeStatus");
		Map<String, Object> map= getInfoByTradeStatusServiceImpl.doController(reqHead, reqBody, null);
		System.out.println(JSON.toJSONString(map));
		//断言....
	}
}
