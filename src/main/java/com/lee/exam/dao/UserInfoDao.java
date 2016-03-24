package com.lee.exam.dao;

import com.lee.exam.pojo.UserInfo;

public interface UserInfoDao {
	
	public void insetUserInfo(UserInfo userInfo) throws RuntimeException;
	
	public UserInfo getUserInfoByID(String userInfoID) throws RuntimeException; 

}
