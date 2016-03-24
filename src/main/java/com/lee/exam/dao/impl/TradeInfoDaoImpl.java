package com.lee.exam.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lee.exam.dao.TradeInfoDao;
import com.lee.exam.db.DBMap;
import com.lee.exam.pojo.TradeInfo;

@Service
public class TradeInfoDaoImpl implements TradeInfoDao{
	
	@Resource
	private DBMap dbMap;

	/**
	 * 批量插入交易记录
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public int inserTradeInfoList(List<TradeInfo> tradeInfos)
			throws RuntimeException {
		/*
		 * 批量插入
		 */
		Map<String,TradeInfo> insertMap = new TreeMap<String,TradeInfo>();
		int i = 0;
		for(TradeInfo tradeInfo:tradeInfos){
			try{
				insertMap.put(tradeInfo.getID(),tradeInfo);
				i++;
			}catch(RuntimeException e){
				System.out.println(tradeInfo.getTradeID()+"交易记录插入失败");
			}
		}
		
		//插入数据
		dbMap.getTradeInfoMap().putAll(insertMap);
		return i;
	}

	/**
	 * 插入一条交易记录
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public int inserTradeInfo(TradeInfo tradeInfo) throws RuntimeException {
		try{
			//插入数据
			dbMap.getTradeInfoMap().put(tradeInfo.getID(),tradeInfo);
			return 1;
		}catch(RuntimeException e){
			System.out.println(tradeInfo.getTradeID()+"交易记录插入失败");
			return 0;
		}
	}

	/**
	 * 根据用户ID回去交易记录
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public List<TradeInfo> getTradeInfoListByUserId(String userId)
			throws RuntimeException {
		if(userId == null){
			throw new RuntimeException("用户ID为空");
		}
		//数据库中数据的集合
		List<TradeInfo> list = dbMap.getAllTradeInfo();
		//返回的集合
		List<TradeInfo> returnList = new LinkedList<TradeInfo>();
		for(TradeInfo tradeInfo : list){
			if(tradeInfo.getUserInfo().getUserID().equals(userId)){
				returnList.add(tradeInfo);
			}
		}
		return returnList;
	}

	public List<TradeInfo> getTradeInfoListByTradeStatus(Byte tradeStatus)
			throws RuntimeException {
		 
		//数据库中数据的集合
		List<TradeInfo> list = dbMap.getAllTradeInfo();
		
		if(tradeStatus == null){
			return list;
		}
		//返回的集合
		List<TradeInfo> returnList = new LinkedList<TradeInfo>();
		for(TradeInfo tradeInfo : list){
			if(tradeInfo.getTradeStatus().equals(tradeStatus)){
				returnList.add(tradeInfo);
			}
		}
		return returnList;
	}

}
