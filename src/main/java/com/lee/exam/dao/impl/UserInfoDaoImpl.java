package com.lee.exam.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lee.exam.dao.UserInfoDao;
import com.lee.exam.db.DBMap;
import com.lee.exam.pojo.UserInfo;
@Service
public class UserInfoDaoImpl implements UserInfoDao{

	@Resource
	private DBMap dbMap;
	
	public void insetUserInfo(UserInfo userInfo) throws RuntimeException {
		dbMap.getUserInfoMap().put(userInfo.getUserID(), userInfo);
		
	}

	public UserInfo getUserInfoByID(String userInfoID) throws RuntimeException {
		
		return dbMap.getUserInfoMap().get(userInfoID);
	}

}
