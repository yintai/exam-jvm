package com.yintai.crud.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yintai.crud.model.TradeInfo;

@Controller
public class CustomerHandler {

	@Autowired
	private TradeInfoDao tradeInfoDao;
	
	@RequestMapping(value="/updatetTradeInfo", method=RequestMethod.PUT)
	public String update(TradeInfo tradeInfo,Map<String, Object> map) throws Exception{
		tradeInfoDao.update(tradeInfo);
		map.put("tradeInfo",tradeInfoDao.getDetail(tradeInfo.getId()));
		return "detail";
	}
	
	@RequestMapping(value="/deleteTradeInfo/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) throws Exception{
		tradeInfoDao.delete(id);
		
		return "redirect:/listTradeInfo";
	}
	
	@RequestMapping(value="/createTradeInfo", method=RequestMethod.POST)
	public String save(TradeInfo tradeInfo) throws Exception {
		tradeInfoDao.save(tradeInfo);
		return "redirect:/listTradeInfo";
	}
	
	@RequestMapping("/listTradeInfo")
	public String list(Map<String, Object> map){
		map.put("tradeInfos", tradeInfoDao.lists());
		
		return "list";
	}
	
}
