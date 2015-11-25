package com.yintai.exam.dao;

import java.util.List;

import com.yintai.exam.domain.Order;

public interface OrderMapper {
    int insert(Order record);
    int insertSelective(Order record);
    
    int deleteByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(Order record);
    int updateByPrimaryKey(Order record);
    
    Order selectByPrimaryKey(Integer id);
    List<Order> selectByStatus(Integer status);
}
