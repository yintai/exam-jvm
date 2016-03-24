package com.lee.exam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lee.exam.pojo.TradeInfo;

/**
 * 交易信息持久化层操作
 * @author lilong
 *
 */
public interface TradeInfoDao  {
	/**
	 * 批量插入交易记录
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public int inserTradeInfoList(List<TradeInfo> tradeInfos) throws RuntimeException;

	/**
	 * 插入一条交易记录
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public int inserTradeInfo(TradeInfo tradeInfos) throws RuntimeException;
	
	/**
	 * 根据用户ID回去交易记录
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public List<TradeInfo> getTradeInfoListByUserId(String userId) throws RuntimeException;
	
	/**
	 * 根据交易状态回去交易记录
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public List<TradeInfo> getTradeInfoListByTradeStatus(Byte tradeStatus) throws RuntimeException;
}
