package hgz.api.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hgz.api.TranRestApi;
import hgz.domain.TranRecord;

public class TranRestApiImpl extends BaseImpl implements TranRestApi{
	
	@Override
	public void creatTranRecord(String method, String url, String version, TranRecord record) {
		
		tranRecordMap.put(record.getTranRecordId(), record);
		
	}

	@Override
	public List<TranRecord> findTranRecordsByTranStatus(String method, String url, String version, String tranStatus) {
		List<TranRecord> list = new ArrayList<TranRecord>();
		
		

		if(tranStatus!= null && !"".equals(tranStatus))
		{		
			   for (TranRecord tranRecord : tranRecordMap.values()) 
			    {
				     String  status =	tranRecord.getTranStatus();
					if(tranStatus.equals(status))
					{	
						list.add(tranRecord);
					
					}
		        } 
	    }else 
	    {
	    	 for (TranRecord tranRecord : tranRecordMap.values()) 
			    {
				     String  status =	tranRecord.getTranStatus();
					 	
						list.add(tranRecord);
					 
		        } 
	    }
		
		return list;
	    }
 

}
