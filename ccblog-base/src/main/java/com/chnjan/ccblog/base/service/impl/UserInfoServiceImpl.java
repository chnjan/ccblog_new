/**
 * 
 */
package com.chnjan.ccblog.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chnjan.ccblog.base.dao.UserInfoDao;
import com.chnjan.ccblog.base.domain.UserInfo;
import com.chnjan.ccblog.base.service.UserInfoService;

/**
 * @author chenjian
 * @date 2018年6月11日
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	/**
	 * @see com.chnjan.ccblog.base.service.UserInfoService#queryUserInfoById(java.lang.String)
	 * */
	@Override
	public UserInfo queryUserInfoById(String userId) {
		return userInfoDao.queryUserInfoById(userId);
	}

	/**
	 * @see com.chnjan.ccblog.base.service.UserInfoService#validPwd(java.lang.String,java.lang.String)
	 * */
	@Override
	public UserInfo validPwd(String loginaccount, String passWord) {
		//通过账号查用户
		UserInfo userInfo = userInfoDao.queryUserInfoByAccount(loginaccount);
		if (userInfo != null) {
			//查询密码
			String pwdInTable = userInfoDao.queryUserPwdById(userInfo.getUserId());
			if (passWord.equals(pwdInTable)) {
				return userInfo;
			}
		}
		return null;
	}

}
