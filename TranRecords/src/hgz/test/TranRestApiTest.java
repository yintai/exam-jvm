package hgz.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hgz.api.TranRestApi;
import hgz.api.impl.BaseImpl;
import hgz.api.impl.TranRestApiImpl;
import hgz.domain.TranRecord;
import hgz.domain.UserInfo;
import hgz.util.TranConstant;

public class TranRestApiTest {
	  TranRestApi  tranRestApi = new TranRestApiImpl() ;
	 
	     
	    public   void before()  
	    
	    {
	    	new BaseImpl().tranRecordMap.clear();
	    	tranRestApi = new TranRestApiImpl();
	     	UserInfo user  = new UserInfo();
	     	initWaitPayData(user);  
	     	intPaySuccessData(user);  
	    }
		private void intPaySuccessData(UserInfo user) {
			for(int i =100;i<102 ; i++ )
	     	{ 
	    	user.setUserId("user_id:"+i);
	    	user.setUserName("张三");
	    	TranRecord tranRecord = new TranRecord();
	    	tranRecord.setUser(user);
	    	tranRecord.setTranRecordId("tran_id:"+i);
	    	tranRecord.setTranAmount(86*100+5*10);//86元5角人民币 转换为分
	    	tranRecord.setTranStatus(TranConstant.TRAN_STATUS_PLAY_SUCESS); 
	    	tranRecord.setTranType(TranConstant.TRAN_TYPE_PLAY);
	    	tranRecord.setTranCurrency(TranConstant.TRAN_CURRENCY_RMB);
	    	tranRecord.setCreateDate(new Date());
	    	String method = "";
	    	String url= "";
	    	String version= "";
	    	tranRestApi.creatTranRecord(method, url, version, tranRecord);
	       }
		}
		private void initWaitPayData(UserInfo user) {
			for(int i =10;i<13 ; i++ )
	     	{ 
	    	user.setUserId("user_id:"+i);
	    	user.setUserName("张三");
	    	TranRecord tranRecord = new TranRecord();
	    	tranRecord.setUser(user);
	    	tranRecord.setTranRecordId("tran_id:"+i);
	    	tranRecord.setTranAmount(86*100+5*10);//86元5角人民币 转换为分
	    	tranRecord.setTranStatus(TranConstant.TRAN_STATUS_WAITPLAY); 
	    	tranRecord.setTranType(TranConstant.TRAN_TYPE_PLAY);
	    	tranRecord.setTranCurrency(TranConstant.TRAN_CURRENCY_RMB);
	    	tranRecord.setCreateDate(new Date());
	    	String method = "";
	    	String url= "";
	    	String version= "";
	    	tranRestApi.creatTranRecord(method, url, version, tranRecord);
	       }
		}  	
//	    @Test  
//	   
//	    public void testCreateTran() {
//	    	
//	    	UserInfo user  = new UserInfo();
//	    	user.setUserId("1");
//	    	user.setUserName("张三");
//	    	TranRecord tranRecord = new TranRecord();
//	    	tranRecord.setUser(user);
//	    	tranRecord.setTranRecordId("1");
//	    	tranRecord.setTranAmount(86*100+5*10);//86元5角人民币 转换为分
//	    	tranRecord.setTranStatus(TranConstant.TRAN_STATUS_WAITPLAY); 
//	    	tranRecord.setTranType(TranConstant.TRAN_TYPE_PLAY);
//	    	tranRecord.setTranCurrency(TranConstant.TRAN_CURRENCY_RMB);
//	    	tranRecord.setCreateDate(new Date());
//	    	String method = "";
//	    	String url= "";
//	    	String version = "";
//	    	tranRestApi.creatTranRecord(method, url, version, tranRecord);
//	    	
//	    	
//	    	Assert.assertEquals(8650, new BaseImpl().tranRecordMap.get("1").getTranAmount());
//	    	
//
//	    	Assert.assertEquals(TranConstant.TRAN_STATUS_WAITPLAY, new BaseImpl().tranRecordMap.get("1").getTranStatus());
//	    	
	    	
	    	
	  //  }  
	    
	    @Test  
		   
	    public void testQueryTranRecord() {
	    	
	    	before();
	    	String method = "";
	    	String url= "";
	    	String version = "";
	    	
	    	String tranStatus = "";
	    	
	    	tranRestApi.findTranRecordsByTranStatus(method, url, version, tranStatus);
	    	
	    	List<TranRecord>  tranRecords5 =   tranRestApi.findTranRecordsByTranStatus(method, url, version, tranStatus);
	    	Assert.assertEquals(5, tranRecords5.size());
	    	
	    	
	    	
	    	tranStatus =  TranConstant.TRAN_STATUS_PLAY_SUCESS;
	    	List<TranRecord>  tranRecords3 =   tranRestApi.findTranRecordsByTranStatus(method, url, version, tranStatus);
	    	Assert.assertEquals(3, tranRecords3.size());
	    	
	    	
	    	tranStatus =  TranConstant.TRAN_STATUS_WAITPLAY;
	    	List<TranRecord>  tranRecords2 =   tranRestApi.findTranRecordsByTranStatus(method, url, version, tranStatus);
	    	Assert.assertEquals(2, tranRecords2.size());
	    	
	    	 
	    	
	    	
	     
	    	
	    }  
	    
}
