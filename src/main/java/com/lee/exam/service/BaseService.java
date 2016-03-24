package com.lee.exam.service;

import java.util.Map;


public interface BaseService {
	
	
 
	/**
	 * 基础验证
	 * 返回错误码
	 */
	public Integer baseValidateMsgBody(Map<String, Object> body,String userId);

	/**
	 *  进行处理后返回MSG对象
	 */
	public Map<String, Object> doController(Map<String,Object> reqHead,Map<String,Object> reqBody,String userId) ;
}
