package yintai.test.zsw;



import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yintai.test.zsw.common.ResponseDTO;
import yintai.test.zsw.model.Order;
import yintai.test.zsw.model.User;
import yintai.test.zsw.util.MemUtil;


@Controller
public class OneController{
	private static Log log = LogFactory.getLog(OneController.class);
	
	
	@RequestMapping(value="/putOrder", method=RequestMethod.GET)
	@ResponseBody
	public ResponseDTO putOrder(HttpServletRequest req,HttpServletResponse resp,HttpSession httpSession){
		resp.setHeader("Access-Control-Allow-Origin", "*");
		
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			Order order = processOrderParam(req);
			
			MemUtil.putOrder(order);
			return responseDTO;
		} catch (Exception e) {
			log.error("", e);
		}
		return responseDTO;
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
	@RequestMapping(value="/getOrders", method=RequestMethod.GET)
	@ResponseBody
	public ResponseDTO getOrders(HttpServletRequest req,HttpServletResponse resp,HttpSession httpSession){
		resp.setHeader("Access-Control-Allow-Origin", "*");
		ResponseDTO responseDTO = new ResponseDTO();
		/*Map<String,String> paramap = new HashMap<String, String>();
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
		MemUtil.putOrder(processOrderParam(paramap));*/
		try {
			Order order = processOrderParam(req);
			
			List<Order> orders = MemUtil.getOrderList(order);
			responseDTO.putData("list", orders);
			
			return responseDTO;
		} catch (Exception e) {
			log.error("", e);
		}
		return responseDTO;
	}

	private Order processOrderParam(HttpServletRequest req) {
		String payStatus = req.getParameter("payStatus");
		String payType = req.getParameter("payType");
		String money = req.getParameter("money");
		String moneyType = req.getParameter("moneyType");
		String userName = req.getParameter("userName");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
