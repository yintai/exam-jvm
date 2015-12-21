package controller.trade;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BaseModel;
import model.TradeDetail;
import model.TradeList;
import service.trade.TradeService;

@Controller
@RequestMapping("/trade")
public class TradeController {
	
	@Autowired
	private TradeService tradeService;
	
	@RequestMapping(value="/{userid}/add",method=RequestMethod.POST)
	@ResponseBody
	//创建交易
	public BaseModel addTrade(@PathVariable long userid,@RequestBody Map<String,String> map){
		Integer tradestatus = Integer.parseInt(map.get("status"));
		Integer tradetype = Integer.parseInt(map.get("type"));
		BigDecimal trademoney = BigDecimal.valueOf(Float.parseFloat(map.get("money")));
		Integer trademoneytype = Integer.parseInt(map.get("moneytype"));
		TradeDetail trade = new TradeDetail(null,null,userid,tradestatus,tradetype,trademoney,trademoneytype,null);
		Boolean result = tradeService.addTrade(trade);
		return new BaseModel(0,"添加成功",result);
	}
	
	@RequestMapping(value="/{status}/search",method=RequestMethod.GET)
	@ResponseBody
	//按交易状态查询交易
	public BaseModel getTrade(@PathVariable int status){
		List<TradeDetail> result = tradeService.getTrade(status);
		return new BaseModel(0,"获取成功",new TradeList(result.size(),result));
	}
}
