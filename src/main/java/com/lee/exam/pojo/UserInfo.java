package com.lee.exam.pojo;

import java.util.Date;

/**
 * �û���Ϣ
 * @author lilong
 *
 */
public class UserInfo {
	/*�ͻ� ID ʱ��+��λ�����*/
	private String userID = 
			new Date().getTime()+""+((int)(1000+Math.random()*(1000-1+1)));
	/*�ͻ�����*/
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
