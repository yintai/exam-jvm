package com.linzhijia.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linzhijia.boot.domain.TradeInfo;

@Repository
public class TradeServiceImpl implements TradeService{

	@Autowired 
	private TradeRepository tradeRepository;
	
	
	@Override
	public boolean addTrade(TradeInfo tradeInfo) {
		boolean boo = false;
		try{
			tradeRepository.save(tradeInfo);
			boo = true;
		}catch(Exception e){
			boo = false;
			e.printStackTrace();
		}	
		return boo;
	}

	@Override
	public Iterable<TradeInfo> findByTradeStateAllIgnoringCase(Integer State) {
		return tradeRepository.findByTradeStateAllIgnoringCase(State);
	}

	@Override
	public Iterable<TradeInfo> getTradeList() {
		// TODO Auto-generated method stub
		return tradeRepository.findAll();
	}

	
}
