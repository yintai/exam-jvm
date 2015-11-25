package com.yintai.exam.dao;

import com.yintai.exam.domain.Customer;

public interface CustomerMapper{
    int insert(Customer record);
    int insertSelective(Customer record);
    
    int deleteByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(Customer record);
    int updateByPrimaryKey(Customer record);
    
    Customer selectByPrimaryKey(Long id);
	Customer queryCustomerByName(String username);
}