/**
 * 
 */
package com.chnjan.ccblog.base.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chnjan.ccblog.base.domain.UserSession;
import com.chnjan.ccblog.base.service.UserSessionService;
import com.chnjan.ccblog.pub.cache.CurrentUserCache;

/**
 * @author chenjian
 * @date 2018年7月24日
 * 用户登录信息service，使用缓存实现
 */
@Service("userSessionService")
public class UserSessionServiceCacheImpl implements UserSessionService {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserSessionServiceCacheImpl.class);
	
	@Autowired
	private CurrentUserCache currentUserCache;
	
	/**
	 * @see com.chnjan.ccblog.base.service.UserSessionService#newSession(com.chnjan.ccblog.base.domain.UserSession)
	 */
	@Override
	public void newSession(UserSession userSession) {
		//把userSession对象放入缓存中
		currentUserCache.putCurrentUser(userSession.getToken(), userSession);
		LOGGER.info("新建会话成功:"+userSession.toString());
	}

	/**
	 * @see com.chnjan.ccblog.base.service.UserSessionService#getUsrSession(java.lang.String)
	 */
	@Override
	public UserSession getUsrSession(String token) {
		return (UserSession) currentUserCache.getCurrentUser(token);
	}

	/**
	 * @see com.chnjan.ccblog.base.service.UserSessionService#updateSession(java.lang.String)
	 */
	@Override
	public void updateSession(String token) {
		//每次读取缓存时会自动刷新时间
		getUsrSession(token);
	}

	/**
	 * @see com.chnjan.ccblog.base.service.UserSessionService#getEffectUserSin(String)
	 * */
	@Override
	public UserSession getEffectUserSin(String token) {
		return this.getUsrSession(token);
	}

}
