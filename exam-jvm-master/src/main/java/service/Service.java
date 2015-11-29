package service;

import java.util.ArrayList;
import java.util.List;

import entity.Custom;
import entity.CustomList;
import entity.Order;
import entity.OrderList;
import util.ExchangeXMLandBean;

public class Service {

	private ExchangeXMLandBean exchange=new ExchangeXMLandBean();
	public boolean createCustom(Custom custom){
		
		CustomList customList=new CustomList();
		customList=exchange.xMLToCustomBean();
		customList.getCustomList().add(custom);
		exchange.customBeanToXML(customList);
		return true;
		
	}
	
	public Custom checkCustom(String name){
		
		CustomList customList=new CustomList();
		customList=exchange.xMLToCustomBean();
		for(Custom custom:customList.getCustomList()){
			if(custom.getName().equals(name)){
				return custom;
			}
		}
		return null;
		
	}
	
	
	public boolean saveOrder(Order order){
		OrderList orderList=new OrderList();
		orderList=exchange.xMLStringToOrderBean();
		
		ArrayList<Order> orderl=new ArrayList<Order>();
		orderl=orderList.getOrderL();
		orderl.add(order);
		orderList.setOrderL(orderl);
		exchange.orderBeanToXMLString(orderList);;
		return true;
		
	}
	
	public List<Order> checkOrder(String name,int type){
		OrderList orderList=new OrderList();
		orderList=exchange.xMLStringToOrderBean();
		if(type==0){
			List<Order> orderL=new ArrayList<Order>();
			for(Order order:orderList.getOrderL()){
				if(order.getState()==0){
					orderL.add(order);
				}
			}
			return orderL;
		}else if(type==1){
			List<Order> orderL=new ArrayList<Order>();
			for(Order order:orderList.getOrderL()){
				if(order.getState()==1){
					orderL.add(order);
				}
			}
			return orderL;
		}
		return null;
		
	}
	
}
