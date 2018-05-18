package com.mlkj.blog.bean;

import com.mlkj.blog.utils.BaseBean;
import com.mlkj.blog.utils.PageBean;

public class UserInfo extends BaseBean{
	
	
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userAccount;
	private String userPhone;
	//标识 1表示有效 0 表示无效
	private String userMark;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserMark() {
		return userMark;
	}
	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userAccount=" + userAccount + ", userPhone=" + userPhone + ", userMark=" + userMark + "]";
	}
	
	
	
	
	
	

}
