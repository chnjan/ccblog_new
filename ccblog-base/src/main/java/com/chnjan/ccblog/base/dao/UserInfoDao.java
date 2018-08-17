/**
 * 
 */
package com.chnjan.ccblog.base.dao;

import com.chnjan.ccblog.base.domain.UserInfo;

/**
 * @author chenjian
 * @date 2018年6月11日
 */
public interface UserInfoDao {

	/**
	 * 通过用户id查询用户信息
	 * */
	UserInfo queryUserInfoById(String userId);
	
	/**
	 * 通过用户账号查询用户信息
	 * */
	UserInfo queryUserInfoByAccount(String loginaccount);
	
	/**
	 * 通过用户id查询用户登录密码
	 * */
	String queryUserPwdById(String userId);
}
