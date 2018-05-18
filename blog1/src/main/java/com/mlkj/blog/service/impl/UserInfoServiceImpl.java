package com.mlkj.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlkj.blog.bean.UserInfo;
import com.mlkj.blog.dao.UserInfoMapper;
import com.mlkj.blog.service.UserInfoService;
import com.mlkj.blog.utils.Const;
import com.mlkj.blog.utils.PageBean;
import com.mlkj.blog.utils.PageUtil;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public PageBean<UserInfo> getUserList(UserInfo user, Integer page) {
		//获取记录数
		int allRow=getUserCount(user).intValue();
		//获取总页数
		int totalPage=PageUtil.countTotalPage(allRow, Const.PAGE_SIZE);
		//获取当前页
		int currentPage=PageUtil.countCurrentPage(page);
		//获取启始记录数
		int start=PageUtil.countStart(Const.PAGE_SIZE, currentPage);
		System.out.println("page:"+page);
	if(page>=0) {
		user.setStart(start);
		user.setLength(Const.PAGE_SIZE);
	}else {
		user.setStart(-1);
		user.setLength(-1);
	}
	List<UserInfo> userlist = userInfoMapper.getUserList(user);
	PageBean<UserInfo> userBean = new PageBean<UserInfo>();
		userBean.setAllRow(allRow);
		userBean.setCurrentPage(currentPage);
		userBean.setList(userlist);
		userBean.setPageSize(Const.PAGE_SIZE);
		userBean.setTotalPage(totalPage);
		return userBean;
	}

	@Override
	public Long getUserCount(UserInfo user) {
		return userInfoMapper.getUserCount(user);
	}

	@Override
	public UserInfo getUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.getByUserInfoId(userInfo);
	}

	
	
	
	
}
