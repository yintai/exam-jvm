package com.lee.exam.db;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lee.exam.pojo.TradeInfo;
import com.lee.exam.pojo.UserInfo;

/**
 * DB
 * @author lilong
 *
 */
@Service
public class DBMap {
	
	private static DBMap dBMap;

	//交易记录 MAP的数据结构
	private Map<String,TradeInfo> tradeInfoMap = new LinkedHashMap<String, TradeInfo>();
	//用户信息 MAP的数据结构
	private Map<String,UserInfo> userInfoMap = new LinkedHashMap<String, UserInfo>();

	private DBMap(){
		
	}
	public static  synchronized DBMap getDBMap(){
		if(dBMap == null ){
			dBMap = new DBMap();
		}
		return dBMap;
	}
	
	public Map<String, TradeInfo> getTradeInfoMap() {
		return tradeInfoMap;
	}
	public void setTradeInfoMap(Map<String, TradeInfo> tradeInfoMap) {
		this.tradeInfoMap = tradeInfoMap;
	}
	public Map<String, UserInfo> getUserInfoMap() {
		return userInfoMap;
	}
	public void setUserInfoMap(Map<String, UserInfo> userInfoMap) {
		this.userInfoMap = userInfoMap;
	}
	
	public List<TradeInfo> getAllTradeInfo(){
		List<TradeInfo> list = new ArrayList<TradeInfo>();
		for(String key:tradeInfoMap.keySet()){
			list.add(tradeInfoMap.get(key));
		}
		return list;
	}
	
}
