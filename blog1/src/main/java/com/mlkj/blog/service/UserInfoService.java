package com.mlkj.blog.service;

import com.mlkj.blog.bean.UserInfo;
import com.mlkj.blog.utils.PageBean;

public interface UserInfoService {
	
	public PageBean<UserInfo> getUserList(UserInfo user,Integer page);
	
	public Long getUserCount(UserInfo user);
	
	public UserInfo getUserInfo(UserInfo userInfo);

}
