package yintai.test.zsw;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

import yintai.test.zsw.model.Order;
import yintai.test.zsw.model.User;
import yintai.test.zsw.util.MemUtil;


public class Springtest
{

	@Test
	public void testOne()
	{
		try
		{
			Map<String,String> paramap = new HashMap<String, String>();
			paramap.put("userName", "张三");
			paramap.put("payStatus", "1");
			paramap.put("payType", "1");
			paramap.put("money", "86.5");
			paramap.put("moneyType", "2");
			
			MemUtil.putOrder(processOrderParam(paramap));
		}
		catch (Exception e)
		{
			fail("Test failed!");
		}
	}
	@Test
	public void testTwo()
	{
		try
		{
			Map<String,String> paramap = new HashMap<String, String>();
			paramap.put("userName", "张三");
			paramap.put("payStatus", "2");
			paramap.put("payType", "1");
			paramap.put("money", "8633.5");
			paramap.put("moneyType", "2");
			
			MemUtil.putOrder(processOrderParam(paramap));
			paramap.put("userName", "张三");
			paramap.put("payStatus", "2");
			paramap.put("payType", "1");
			paramap.put("money", "8643.5");
			paramap.put("moneyType", "2");
			
			MemUtil.putOrder(processOrderParam(paramap));
			paramap.put("userName", "张三");
			paramap.put("payStatus", "2");
			paramap.put("payType", "1");
			paramap.put("money", "86443.5");
			paramap.put("moneyType", "2");
			
			MemUtil.putOrder(processOrderParam(paramap));
			
			
			
			paramap.put("userName", "张三");
			paramap.put("payStatus", "3");
			paramap.put("payType", "1");
			paramap.put("money", "11286.5");
			paramap.put("moneyType", "2");
			
			MemUtil.putOrder(processOrderParam(paramap));
			
			paramap.put("userName", "张三");
			paramap.put("payStatus", "3");
			paramap.put("payType", "1");
			paramap.put("money", "3121186.5");
			paramap.put("moneyType", "2");
			MemUtil.putOrder(processOrderParam(paramap));
			
			Order ro = new Order();
			ro.setPayStatus(2);
			System.out.println(JSONObject.toJSONString(MemUtil.getOrderList( ro )) ) ;
			ro.setPayStatus(3);
			System.out.println(JSONObject.toJSONString(MemUtil.getOrderList( ro )) ) ;
		}
		catch (Exception e)
		{
			fail("Test failed!");
		}
	}
	
	private Order processOrderParam(Map<String,String> paramap) {
		String payStatus = paramap.get("payStatus");
		String payType = paramap.get("payType");
		String money = paramap.get("money");
		String moneyType = paramap.get("moneyType");
		String userName = paramap.get("userName");
		Order order = new Order();
		User user = new User();
		order.setId(new Random().nextLong()+"");
		order.setCreateTime(new Date());
		if(!StringUtils.isEmpty(money)){
			order.setMoney(new BigDecimal(money));
		}
		if(!StringUtils.isEmpty(payStatus)){
			order.setPayStatus(Integer.parseInt(payStatus));
		}
		if(!StringUtils.isEmpty(payType)){
			order.setPayType(Integer.parseInt(payType));
		}
		if(!StringUtils.isEmpty(moneyType)){
			order.setMoneyType(Integer.parseInt(moneyType));
		}
		if(!StringUtils.isEmpty(userName)){
			user.setId(new Random().nextLong()+"");
			user.setUserName(userName);
		}
		order.setUser(user);
		return order;
	}
	@Ignore
	public void testOtherSpringObject()
	{
		fail("Not yet implemented");
	}
}