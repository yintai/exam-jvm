package test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import model.TradeDetail;
import service.trade.TradeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class TradeTest {
	
	@Autowired
	private TradeService tradeService;
		
	@Test
	public void testGet(){
		//交易成功
		tradeService.addTrade(new TradeDetail(null,null,1L,1,1,BigDecimal.valueOf(86.5d),1,null));
		tradeService.addTrade(new TradeDetail(null,null,1L,1,1,BigDecimal.valueOf(86.5d),1,null));
		tradeService.addTrade(new TradeDetail(null,null,1L,1,1,BigDecimal.valueOf(86.5d),1,null));
		//交易失败
		tradeService.addTrade(new TradeDetail(null,null,1L,0,1,BigDecimal.valueOf(86.5d),1,null)); 
		tradeService.addTrade(new TradeDetail(null,null,1L,0,1,BigDecimal.valueOf(86.5d),1,null));
		
		List<TradeDetail> result = tradeService.getTrade(1);
		Assert.assertTrue(result.size()==3);
		System.out.println(JSON.toJSONString(result));
		List<TradeDetail> result1 = tradeService.getTrade(0);
		Assert.assertTrue(result1.size()==2);
		System.out.println(JSON.toJSONString(result1));
	}
}

