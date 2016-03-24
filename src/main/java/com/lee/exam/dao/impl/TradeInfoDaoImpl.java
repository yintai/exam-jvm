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
	 * �������뽻�׼�¼
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public int inserTradeInfoList(List<TradeInfo> tradeInfos)
			throws RuntimeException {
		/*
		 * ��������
		 */
		Map<String,TradeInfo> insertMap = new TreeMap<String,TradeInfo>();
		int i = 0;
		for(TradeInfo tradeInfo:tradeInfos){
			try{
				insertMap.put(tradeInfo.getID(),tradeInfo);
				i++;
			}catch(RuntimeException e){
				System.out.println(tradeInfo.getTradeID()+"���׼�¼����ʧ��");
			}
		}
		
		//��������
		dbMap.getTradeInfoMap().putAll(insertMap);
		return i;
	}

	/**
	 * ����һ�����׼�¼
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public int inserTradeInfo(TradeInfo tradeInfo) throws RuntimeException {
		try{
			//��������
			dbMap.getTradeInfoMap().put(tradeInfo.getID(),tradeInfo);
			return 1;
		}catch(RuntimeException e){
			System.out.println(tradeInfo.getTradeID()+"���׼�¼����ʧ��");
			return 0;
		}
	}

	/**
	 * �����û�ID��ȥ���׼�¼
	 * @param tradeInfos
	 * @return
	 * @throws RuntimeException
	 */
	public List<TradeInfo> getTradeInfoListByUserId(String userId)
			throws RuntimeException {
		if(userId == null){
			throw new RuntimeException("�û�IDΪ��");
		}
		//���ݿ������ݵļ���
		List<TradeInfo> list = dbMap.getAllTradeInfo();
		//���صļ���
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
		 
		//���ݿ������ݵļ���
		List<TradeInfo> list = dbMap.getAllTradeInfo();
		
		if(tradeStatus == null){
			return list;
		}
		//���صļ���
		List<TradeInfo> returnList = new LinkedList<TradeInfo>();
		for(TradeInfo tradeInfo : list){
			if(tradeInfo.getTradeStatus().equals(tradeStatus)){
				returnList.add(tradeInfo);
			}
		}
		return returnList;
	}

}
