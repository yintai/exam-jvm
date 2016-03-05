package yintai.test.zsw.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import yintai.test.zsw.model.*;

public class MemUtil {
	private static List<Order> orders = new ArrayList<Order>();
	
	public static void putOrder(Order o){
		Lock lock = new ReentrantLock();
		lock.lock();
		try{
			orders.add(o);
		}catch(Exception ex){
		     ex.printStackTrace();
		}finally{
		    lock.unlock();   //释放锁
		}
	}
	
	public static List<Order> getOrderList(Order o){
		List<Order> os = new ArrayList<Order>();
		if( o != null && o.getPayStatus() != null){
			for(Order so : orders){
				if( so.getPayStatus() == o.getPayStatus()){
					os.add(so);
				}
			}
		}
		else{
			return orders;
		}
		
		return os;
	}
	

}
