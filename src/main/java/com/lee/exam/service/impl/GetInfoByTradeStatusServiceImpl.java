package com.lee.exam.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lee.exam.dao.TradeInfoDao;
import com.lee.exam.pojo.TradeInfo;
import com.lee.exam.service.BaseService;

/**
 * 创建交易的接口
 * @author lilong
 *
 */
@Service("getInfoByTradeStatusServiceImpl")
public class GetInfoByTradeStatusServiceImpl implements BaseService{
	
	@Resource
	private TradeInfoDao tradeInfoDaoImpl;

 

	public Integer baseValidateMsgBody(Map<String, Object> body, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 创建交易的接口 
	 * @param reqHead
	 * @param reqBody
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doController(Map<String,Object> reqHead,
			Map<String,Object> reqBody, String userId){
		
		Map<String, Object> responseMsg = new HashMap<String, Object>();
		Map<String, Object> responseHead = new HashMap<String, Object>();
		Map<String, Object> responseBody = new HashMap<String, Object>();
		
		try{
			Byte tradeStatus = reqBody.get("tradeStatus") == null ?null:Byte.parseByte(reqBody.get("tradeStatus").toString());
			List<TradeInfo>  list = tradeInfoDaoImpl.getTradeInfoListByTradeStatus(tradeStatus);
			List<Map<String,Object>>  returnList = new ArrayList<Map<String,Object>>();
			Map<String,Object> map = null;
					
			for(TradeInfo tradeInfo : list){
				map = new HashMap<String,Object>();
				map.put("moneyType", tradeInfo.getMoneyType().intValue());
				map.put("tradeStatus", tradeInfo.getTradeStatus().intValue());
				map.put("tradeType", tradeInfo.getTradeType().intValue());
				map.put("tradeMoney",tradeInfo.getTradeMoney().doubleValue() );
				map.put("userInfoID",tradeInfo.getUserInfo().getUserID());
				map.put("tradeID", tradeInfo.getTradeID());
				
				returnList.add(map);
			}
			
			responseBody.put("tradeInfos", returnList);
			responseHead.put("resCode", 0);
			responseHead.put("message", "成功");
			responseHead.put("transactionType", reqHead.get("transactionType"));
			responseHead.put("timeStamp", new Date().getTime());
			responseHead.put("messageID", reqHead.get("messageID"));
			
			responseMsg.put("body", responseBody);
			
		}catch(Exception e){
			responseHead.put("resCode", 0);
			responseHead.put("message", "成功");
			responseHead.put("transactionType", reqHead.get("transactionType"));
			responseHead.put("timeStamp", new Date().getTime());
			responseHead.put("messageID", reqHead.get("messageID"));
			System.out.println("失败"+e.getMessage());
			e.printStackTrace();
			
		}
		responseMsg.put("head", responseHead);
		
		return responseMsg;
	}

}
