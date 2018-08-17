/**
 * 
 */
package com.chnjan.ccblog.base.domain;

import java.util.Date;

/**
 * @author chenjian
 * @date 2018年6月16日
 * 用户会话实体，暂时使用数据库实现
 */
public class UserSession {

	/**
	 * 用户id
	 * */
	private String uid;
	
	/**
	 * 登录验证使用到的token
	 * */
	private String token;
	
	/**
	 * 登录时间，判断登录过期
	 * */
	private Date loginTime;

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserSession [uid=" + uid + ", token=" + token + ", loginTime=" + loginTime + "]";
	}
	
}
