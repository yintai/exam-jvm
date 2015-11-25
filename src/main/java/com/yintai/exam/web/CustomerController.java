package com.yintai.exam.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.yintai.exam.domain.Customer;
import com.yintai.exam.service.CustomerService;
import com.yintai.exam.service.OrderService;
import com.yintai.exam.vo.CommResp;

@RestController // spring4新特性
@RequestMapping("/customer")
public class CustomerController {
	private final CustomerService customerService;
	private final OrderService orderService;

	@Autowired
	private CustomerController(CustomerService customerService, OrderService orderService) {
		this.customerService = customerService;
		this.orderService = orderService;
	}

	/**
	 * @name 根据用户id查询用户信息
	 * @describe 调用者传入json格式,返还结果同样为json格式json<br/>
	 *           使用了阿里巴巴的fastjson解析,fastjson默认值为空的不会解析到json里面
	 * @param c
	 * @return
	 */
	@RequestMapping(value = "/queryCustomerById", method = { RequestMethod.POST }, produces = {
			"application/json" }, consumes = { "application/json" })
	public String queryCustomerById(@RequestBody Customer c) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (c == null || c.getId() == null) {
			map.put("code", "-1");
			map.put("message", "用户id不能为空");
		}
		Customer customer = customerService.queryCustomerById(c.getId());
		if (customer != null) {
			map.put("code", "0");
			map.put("message", "查询成功");
			map.put("data", customer);
		} else {
			map.put("code", "-1");
			map.put("message", "查询失败");
		}
		return JSON.toJSONString(map);
	}

	/**
	 * @name 根据用户id查询用户信息2，和上个方法的区别在与使用springmvc默认的jackson
	 * @describe 调用者传入json格式,返还结果同样为json格式json
	 * @param c
	 * @return
	 */
	@RequestMapping(value = "/queryCustomerById2", method = { RequestMethod.POST }, produces = {
			"application/json" }, consumes = { "application/json" })
	public CommResp queryCustomerById2(@RequestBody Customer c) {
		if (c == null || c.getId() == null) {
			return new CommResp("-1", "用户id不能为空");
		}
		Customer customer = customerService.queryCustomerById(c.getId());
		if (customer != null) {
			return new CommResp("0", "查询成功", customer);
		} else {
			return new CommResp("-1", "查询失败");
		}
	}
}
