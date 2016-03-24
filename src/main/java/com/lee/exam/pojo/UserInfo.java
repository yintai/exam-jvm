package com.lee.exam.pojo;

import java.util.Date;

/**
 * 用户信息
 * @author lilong
 *
 */
public class UserInfo {
	/*客户 ID 时间+四位随机数*/
	private String userID = 
			new Date().getTime()+""+((int)(1000+Math.random()*(1000-1+1)));
	/*客户姓名*/
	private String userName;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
