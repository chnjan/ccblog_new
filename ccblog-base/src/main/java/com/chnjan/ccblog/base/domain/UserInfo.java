package com.chnjan.ccblog.base.domain;

import java.util.Date;

/**
 * @author chenjian
 * @date 2018年6月11日
 */
public class UserInfo {

	/**
	 * 用户id
	 * */
	private String userId;
	
	/**
	 * 登录账号
	 * */
	private String loginAccount;
	
	/**
	 * 用户姓名
	 * */
	private String userName;
	
	/**
	 * 注册时间
	 * */
	private Date rigisttime;
	
	/**
	 * 最近一次登录时间
	 * */
	private Date lastlogintime;
	
	/**
	 * 邮箱
	 * */
	private String email;
	
	/**
	 * 电话
	 * */
	private String phone;
	
	/**
	 * qq
	 * */
	private String qq;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the loginAccount
	 */
	public String getLoginAccount() {
		return loginAccount;
	}

	/**
	 * @param loginAccount the loginAccount to set
	 */
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the rigisttime
	 */
	public Date getRigisttime() {
		return rigisttime;
	}

	/**
	 * @param rigisttime the rigisttime to set
	 */
	public void setRigisttime(Date rigisttime) {
		this.rigisttime = rigisttime;
	}

	/**
	 * @return the lastlogintime
	 */
	public Date getLastlogintime() {
		return lastlogintime;
	}

	/**
	 * @param lastlogintime the lastlogintime to set
	 */
	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", loginAccount=" + loginAccount + ", userName=" + userName
				+ ", rigisttime=" + rigisttime + ", lastlogintime=" + lastlogintime + ", email=" + email + ", phone="
				+ phone + ", qq=" + qq + "]";
	}
	
}
