package com.lee.exam.service;

import java.util.Map;


public interface BaseService {
	
	
 
	/**
	 * ������֤
	 * ���ش�����
	 */
	public Integer baseValidateMsgBody(Map<String, Object> body,String userId);

	/**
	 *  ���д���󷵻�MSG����
	 */
	public Map<String, Object> doController(Map<String,Object> reqHead,Map<String,Object> reqBody,String userId) ;
}
