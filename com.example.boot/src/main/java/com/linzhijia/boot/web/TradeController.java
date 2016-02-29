package com.linzhijia.boot.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.linzhijia.boot.constants.TradeStateEnum;
import com.linzhijia.boot.domain.Customer;
import com.linzhijia.boot.domain.TradeInfo;
import com.linzhijia.boot.service.CustomerService;
import com.linzhijia.boot.service.TradeService;

@RestController
@RequestMapping(value = "/trade")
public class TradeController {
//注意事务
	
	@Autowired
	private TradeService tradeService;
	

	@Autowired
	private CustomerService customerService;
	
	//@Transactional/{tradeState}/{tradeAmount}/{customerName}  
	@RequestMapping(value="/createTradeInfo",method=RequestMethod.POST)
	@ResponseBody
    public String createTrade(@RequestParam String tradeState,@RequestParam String tradeAmount,@RequestParam String customerName) {
		Integer currentState = null;
		Double currentAmount = null;
		//验证信息
		if(tradeState==null ){
			return "交易状态非待付款，请重新确认信息";
		}else{
			currentState = Integer.parseInt(tradeState);
			if(!TradeStateEnum.getEnumByCode(currentState).equals(TradeStateEnum.UNPAY_STATE)){
				return "交易状态非待付款，请重新确认信息";
			}
			
		}
		if(tradeAmount==null){
			return "交易的金额不正确，请重新确认信息";
		}else{
			currentAmount = Double.parseDouble(tradeAmount);
			if(currentAmount<0){
				return "交易的金额不正确，请重新确认信息";
			}
		}
		
		TradeInfo tradeInfo = new TradeInfo();
    	tradeInfo.setTradeState(currentState);
    	tradeInfo.setTradeAmount(currentAmount);
    	tradeInfo.setTradeAmountType(0);//暂放默认值 0元 人民币  
    	tradeInfo.setTradeTime(new Date());
    	tradeInfo.setTradeType(0);//暂放默认值  
    	
    	
		Customer customer = customerService.getCustomerByName(customerName);
		tradeInfo.setCustomer(customer);
		boolean boo = tradeService.addTrade(tradeInfo);
		
		return boo?"success":"fail";
	}
	
	@RequestMapping(value="/queryTradeByState/{state}",method=RequestMethod.GET)
	@ResponseBody
    public Iterable<TradeInfo> getTradeByState(@PathVariable Integer state) {
		if(TradeStateEnum.getEnumByCode(state).equals(TradeStateEnum.ALL_STATE)){
			return tradeService.getTradeList();
		}else{
			return tradeService.findByTradeStateAllIgnoringCase(state);
		}
		 
	}

}
