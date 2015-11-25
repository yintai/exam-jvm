package com.yintai.exam.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yintai.exam.dao.CustomerMapper;
import com.yintai.exam.dao.OrderMapper;
import com.yintai.exam.domain.Order;
import com.yintai.exam.enums.OrderState;
import com.yintai.exam.enums.OrderType;
import com.yintai.exam.service.OrderService;
import com.yintai.exam.util.OrderUtils;
import com.yintai.exam.util.Util;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	private final CustomerMapper customerMapper;
	private final OrderMapper orderMapper;

	@Autowired
	private OrderServiceImpl(CustomerMapper customerMapper, OrderMapper orderMapper) {
		this.customerMapper = customerMapper;
		this.orderMapper = orderMapper;
	}

	@Override
	public int createTrade(Order order) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		order.setOrderno(OrderUtils.getOrderNum(sdf.format(new Date())));
		order.setCreatedate(new Date());
		order.setStatus(OrderState.SUCCESS.getValue());
		return orderMapper.insert(order);
	}

	@Override
	public List<Order> queryOrderByStatus(Integer status) {
		return orderMapper.selectByStatus(status);
	}
}
