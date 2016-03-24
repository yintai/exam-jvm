package com.lee.exam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lee.exam.pojo.TradeInfo;

/**
 * ������Ϣ�־û������
 * @author lilong
 *
 */
public interface TradeInfoDao  {
	/**
	 * �������뽻�׼�¼
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public int inserTradeInfoList(List<TradeInfo> tradeInfos) throws RuntimeException;

	/**
	 * ����һ�����׼�¼
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public int inserTradeInfo(TradeInfo tradeInfos) throws RuntimeException;
	
	/**
	 * �����û�ID��ȥ���׼�¼
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public List<TradeInfo> getTradeInfoListByUserId(String userId) throws RuntimeException;
	
	/**
	 * ���ݽ���״̬��ȥ���׼�¼
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public List<TradeInfo> getTradeInfoListByTradeStatus(Byte tradeStatus) throws RuntimeException;
}
