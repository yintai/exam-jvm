package com.yintai.crud.handler;

import java.util.List;

import com.yintai.crud.model.TradeInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TradeInfoDao {
	@Autowired
	Hsqldb hsqldb;

	public List<TradeInfo> lists(){
		List<TradeInfo> list=null;
		try {
			list = hsqldb.lists();
			
		} catch (Exception e) {
			return null;
		} 
		return list;
	}

	public void delete(Integer id) throws Exception {
		hsqldb.deleteTradeInfo(id);
	}

	public void update(TradeInfo tradeInfo) throws Exception {
		hsqldb.updateTradeInfo(tradeInfo);
	}
	
	public void save(TradeInfo tradeInfo) throws Exception {
		hsqldb.insertTradeInfo(tradeInfo);
	}

	public TradeInfo getDetail(int id) throws Exception {
		TradeInfo tradeInfo = hsqldb.getDetail(id);
		return tradeInfo;
	}
   
}
