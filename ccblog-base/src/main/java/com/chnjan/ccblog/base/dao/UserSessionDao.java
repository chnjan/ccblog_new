/**
 * 
 */
package com.chnjan.ccblog.base.dao;

import org.apache.ibatis.annotations.Param;

import com.chnjan.ccblog.base.domain.UserSession;

/**
 * @author chenjian
 * @date 2018年6月16日
 */
public interface UserSessionDao {

	/**
	 * 通过token查询有效的会话
	 * */
	UserSession queryUserSessionByToken(@Param(value="token")String token,@Param(value="effectminute")String effecttime);
	
	/**
	 * 新增一个会话记录
	 * */
	void addUserSession(UserSession userSession);
	
	/**
	 * 通过token更新登录时间
	 * */
	void updateLoginTime(String token);
}
