package com.yintai.exam.service;

import java.util.List;

import com.yintai.exam.domain.Order;

public interface OrderService {
	int createTrade(Order order);

	List<Order> queryOrderByStatus(Integer status);
}
