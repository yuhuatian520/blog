package com.mlkj.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mlkj.blog.bean.UserInfo;

@Mapper
public interface UserInfoMapper {
	/**
	 * 查询所有的用户信息
	 * @param userInfo
	 * @return
	 */
	public List<UserInfo> getUserList(UserInfo user);
	/**
	 * 根据条件查询用户的数量
	 * @param user
	 * @return
	 */
	public Long getUserCount(UserInfo user);
	
	public UserInfo getByUserInfoId(UserInfo userInfo);

}
