/**
 * 
 */
package com.chnjan.ccblog.base.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.chnjan.ccblog.base.dao.UserSessionDao;
import com.chnjan.ccblog.base.domain.UserSession;
import com.chnjan.ccblog.base.service.UserSessionService;
import com.chnjan.ccblog.pub.sysparam.SystemParamUtil;

/**
 * @author chenjian
 * @date 2018年6月16日
 */

public class UserSessionServiceImpl implements UserSessionService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	
	@Autowired
	private UserSessionDao userSessionDao;

	/**
	 * @see com.chnjan.ccblog.base.service.UserSessionService#newSession(com.chnjan.ccblog.base.domain.UserSession)
	 */
	@Override
	public void newSession(UserSession userSession) {
		userSessionDao.addUserSession(userSession);
		LOGGER.info("新建会话成功:"+userSession.toString());
	}

	/**
	 * @see com.chnjan.ccblog.base.service.UserSessionService#getUsrSession(java.lang.String)
	 */
	@Override
	public UserSession getUsrSession(String token) {
		//会话有效时间
		String effecttime = SystemParamUtil.getSysValue("auth.login.effectminute");
		UserSession userSession = userSessionDao.queryUserSessionByToken(token,effecttime);
		System.out.println("服务层的session"+userSession+"effct"+effecttime);
		return userSession;
	}

	/**
	 * @see com.chnjan.ccblog.base.service.UserSessionService#updateSession(java.lang.String)
	 */
	@Override
	public void updateSession(String token) {
		userSessionDao.updateLoginTime(token);

	}

	/**
	 * @see com.chnjan.ccblog.base.service.UserSessionService#getEffectUserSin(String)
	 * */
	@Override
	public UserSession getEffectUserSin(String token) {
		if (!StringUtils.hasText(token)) {
			return null;
		}
		UserSession userSession = this.getUsrSession(token);
		if (userSession!=null) {
			//如果session有效，则更新时间
			this.updateSession(token);
		}
		return userSession;
	}

}
