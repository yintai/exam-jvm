package com.lee.exam.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lee.exam.dao.TradeInfoDao;
import com.lee.exam.dao.UserInfoDao;
import com.lee.exam.pojo.TradeInfo;
import com.lee.exam.pojo.UserInfo;
import com.lee.exam.service.BaseService;

/**
 * �������׵Ľӿ�
 * @author lilong
 *
 */
@Service("createTradeInfoServiceImpl")
public class CreateTradeInfoServiceImpl implements BaseService{
	
	@Resource
	private TradeInfoDao tradeInfoDaoImpl;
	
	@Resource
	private UserInfoDao userInfoDao;

 

	public Integer baseValidateMsgBody(Map<String, Object> body, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * �������׵Ľӿ� 
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
		
		//װ�� pojo
		TradeInfo tradeInfo = new TradeInfo();
		tradeInfo.setMoneyType(Byte.parseByte(reqBody.get("moneyType").toString()));
		tradeInfo.setTradeStatus(Byte.parseByte(reqBody.get("tradeStatus").toString()));
		tradeInfo.setTradeType(Byte.parseByte(reqBody.get("tradeType").toString()));
		tradeInfo.setTradeID((String)reqBody.get("tradeID"));
		tradeInfo.setTradeMoney(new BigDecimal(reqBody.get("tradeMoney").toString()));
		UserInfo userInfo = userInfoDao.getUserInfoByID((String)reqBody.get("userInfoID"));
		//�ڴ������û��������UserInfo��������ݿ϶���û�����ݵ�
		if(userInfo ==null){
			userInfo = new UserInfo();
			userInfo.setUserID((String)reqBody.get("userInfoID"));
		}
		tradeInfo.setUserInfo(userInfo);
		try{
	
			tradeInfoDaoImpl.inserTradeInfo(tradeInfo);
			
			responseHead.put("resCode", 0);
			responseHead.put("message", "�ɹ�");
			responseHead.put("transactionType", reqHead.get("transactionType"));
			responseHead.put("timeStamp", new Date().getTime());
			responseHead.put("messageID", reqHead.get("messageID"));
			
		}catch(Exception e){
			responseHead.put("resCode", 0);
			responseHead.put("message", "�ɹ�");
			responseHead.put("transactionType", reqHead.get("transactionType"));
			responseHead.put("timeStamp", new Date().getTime());
			responseHead.put("messageID", reqHead.get("messageID"));
			System.out.println("ʧ��"+e.getMessage());
			e.printStackTrace();
			
		}
		responseMsg.put("head", responseHead);
		
		return responseMsg;
	}

}
