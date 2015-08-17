package com.yintai.crud.handler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yintai.crud.model.CustomerInfo;
import com.yintai.crud.model.TradeInfo;

@Component
public class Hsqldb {
	 
	//加载驱动
	static{
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
		
	//获取连接
   public  Connection getConnetion() throws Exception{
	   return DriverManager.getConnection("jdbc:hsqldb:mem:db_01", "sa", "");
   }
   
		
	

	//创建元数据信息
	public void createTables() throws Exception{
		Connection conn =this.getConnetion();
		Statement stat = conn.createStatement();
		//创建表数据
		stat.executeUpdate("CREATE TABLE IF NOT EXISTS customer_info(id integer,name VARCHAR(20))");
		stat.executeUpdate("CREATE TABLE IF NOT EXISTS trade_info(id integer,time Date,status VARCHAR(20),tradeType VARCHAR(20),amount Decimal(5,2),cashType VARCHAR(20),customerId interger)");
		stat.executeUpdate("INSERT INTO customer_info VALUES(1,'张三')");
		stat.executeUpdate("INSERT INTO customer_info VALUES(2,'李四')");
		stat.executeUpdate("INSERT INTO customer_info VALUES(3,'王五')");
	}
	
	//查询所有交易信息
	public List<TradeInfo> lists() throws Exception{
		Connection conn = this.getConnetion();
		List<TradeInfo> list = new ArrayList<TradeInfo>();
		PreparedStatement pstmt = conn
                .prepareStatement("SELECT * FROM customer_info LEFT JOIN trade_info ON customer_info.id = trade_info.customerId");
		 ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	TradeInfo tradeInfo = new TradeInfo();
	        	tradeInfo.setId(Integer.parseInt(rs.getString(1)));
	        	tradeInfo.setTime(rs.getString(2));
	        	tradeInfo.setStatus(rs.getString(3));
	        	tradeInfo.setType(rs.getString(4));
	        	tradeInfo.setAmount(rs.getString(5));
	        	tradeInfo.setCashType(rs.getString(6));
	        	CustomerInfo customerInfo =new CustomerInfo();
	        	customerInfo.setId(Integer.parseInt(rs.getString(7)));
	        	customerInfo.setName(rs.getString(8));
	        	tradeInfo.setCustomerInfo(customerInfo);
	        	list.add(tradeInfo);
	        }
		return list;
	}
	
  //添加交易信息
	public void insertTradeInfo(TradeInfo tradeInfo) throws Exception{
		this.createTables();
		Connection conn = this.getConnetion();
		Statement stat = conn.createStatement();
		BigDecimal d =new BigDecimal(tradeInfo.getAmount().trim());
		
		stat.executeUpdate("INSERT INTO trade_info VALUES("+tradeInfo.getId()+","+tradeInfo.getTime()+","+tradeInfo.getStatus()+","+tradeInfo.getType()+","+d+","+tradeInfo.getCashType()+","+tradeInfo.getCustomerInfo().getId()+")");
	}
	
  //修改交易状态
	public void updateTradeInfo(TradeInfo tradeInfo) throws Exception{
		Connection conn = this.getConnetion();
		Statement stat = conn.createStatement();
		stat.executeUpdate("UPDATE trade_info SET status = "+tradeInfo.getStatus()+"WHERE id ="+tradeInfo.getId());
	}
	
  //删除交易信息
	public void deleteTradeInfo(int id) throws Exception{
		Connection conn = this.getConnetion();
		Statement stat = conn.createStatement();
		stat.executeUpdate("DELETE FROM trade_info WHERE id ="+id);
	}

  //获取交易详情
	public TradeInfo getDetail(int id) throws Exception {
		Connection conn = this.getConnetion();
		PreparedStatement pstmt = conn
                .prepareStatement("SELECT * FROM trade_info LEFT JOIN customer_info ON trade_info.customerId = customer_info.id WHERE trade_info.id ="+id);
		 ResultSet rs = pstmt.executeQuery();
		 TradeInfo tradeInfo = new TradeInfo();
		 
		 while (rs.next()) {
	        	tradeInfo.setId(Integer.parseInt(rs.getString(1)));
	        	tradeInfo.setTime(rs.getString(2));
	        	tradeInfo.setStatus(rs.getString(3));
	        	tradeInfo.setType(rs.getString(4));
	        	tradeInfo.setAmount(rs.getString(5));
	        	tradeInfo.setCashType(rs.getString(6));
	        	CustomerInfo customerInfo =new CustomerInfo();
	        	customerInfo.setId(Integer.parseInt(rs.getString(7)));
	        	customerInfo.setName(rs.getString(8));
	        	tradeInfo.setCustomerInfo(customerInfo);
	        }
		return tradeInfo;
	}
}
