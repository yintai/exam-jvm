package hgz.api;

import java.util.List;

import hgz.domain.TranRecord;

public interface TranRestApi {
	
public void	creatTranRecord(String method, String url ,String version ,TranRecord record);
	
public List  findTranRecordsByTranStatus(String method, String url ,String version ,String tranStatus);
}
