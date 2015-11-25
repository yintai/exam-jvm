package com.yintai.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yintai.exam.dao.CustomerMapper;
import com.yintai.exam.dao.OrderMapper;
import com.yintai.exam.domain.Customer;
import com.yintai.exam.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final CustomerMapper customerMapper;
	private final OrderMapper orderMapper;

	@Autowired
	private CustomerServiceImpl(CustomerMapper customerMapper, OrderMapper orderMapper) {
		this.customerMapper = customerMapper;
		this.orderMapper = orderMapper;
	}

	@Override
	public Customer queryCustomerById(Long id) {
		return customerMapper.selectByPrimaryKey(id);
	}
}
