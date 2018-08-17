package com.chnjan.ccblog.base.service;

import com.chnjan.ccblog.base.domain.UserInfo;

public interface UserInfoService {
	
	/**
	 * 通过登录账号查询用户信息登录账号可以是登录名，邮箱，电话
	 * */
	
	/**
	 * 通过账号和密码验证是否通过
	 * @param loginaccount登录账号
	 * @param passWord 登录密码
	 * @return UserInfo 如果账号和密码匹配，返回该用户信息实体，否则返回null
	 * */
	UserInfo validPwd(String loginaccount,String passWord);

	/**
	 * 通过用户id查询用户信息
	 * */
	UserInfo queryUserInfoById(String userId);
}
