package com.yintai.exam.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yintai.exam.domain.Order;
import com.yintai.exam.enums.OrderState;
import com.yintai.exam.service.CustomerService;
import com.yintai.exam.service.OrderService;
import com.yintai.exam.util.MathMoney;
import com.yintai.exam.vo.CommResp;

@RestController
@RequestMapping("/order")
public class OrderController {
	private final CustomerService customerService;
	private final OrderService orderService;

	@Autowired
	private OrderController(CustomerService customerService, OrderService orderService) {
		this.customerService = customerService;
		this.orderService = orderService;
	}

	@RequestMapping("/helloWorld")
	public String helloWorld() {
		return "helloWorld";
	}

	@RequestMapping(value = "/createTrade", method = { RequestMethod.POST }, produces = {
			"application/json" }, consumes = { "application/json" })
	public CommResp createTrade(@RequestBody Order order) {
		if (OrderState.WAIT_PAYMENT.getValue() != order.getStatus()) {
			return new CommResp("-1", "交易状态必须是等待付款");
		}
		if (!MathMoney.isNumber(order.getMoney())) {
			return new CommResp("-1", "金额格式不正确");
		}
		if (MathMoney.compare_moneyObj("0", order.getMoney()) >= 0) {
			return new CommResp("-1", "金额必须大于登录0");
		}
		int flag = orderService.createTrade(order);
		if (flag == 1) {
			return new CommResp("0", "创建成功");
		} else {
			return new CommResp("-1", "创建失败");
		}
	}

	/***
	 * 根据订单状态查询订单信息
	 * 
	 * @param status
	 *            -1查询全部 <br/>
	 *            1查询成功 <br/>
	 *            0查询失败
	 * @return
	 */
	@RequestMapping(value = "/queryOrderByStatus/{status}")
	public CommResp queryOrderByStatus(@PathVariable Integer status) {
		List<Order> list = orderService.queryOrderByStatus(status);
		return new CommResp("0", "查询成功", list);
	}
}
