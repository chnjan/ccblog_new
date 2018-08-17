/**
 * 
 */
package com.chnjan.ccblog.base.service;

import com.chnjan.ccblog.base.domain.UserSession;

/**
 * @author chenjian
 * @date 2018年6月16日
 */
public interface UserSessionService {

	/**
	 * 新增会话
	 * */
	void newSession(UserSession userSession);
	
	/**
	 * 根据token查询有效的会话记录
	 * */
	UserSession getUsrSession(String token);
	
	/**
	 * 更新会话时间
	 * */
	void updateSession(String token);
	
	/**
	 * 验证token是否有效，有效会更新usersession时间
	 * @param token
	 * @return token有效返回UserSession ,否则返回null
	 * */
	UserSession getEffectUserSin(String token);
}
