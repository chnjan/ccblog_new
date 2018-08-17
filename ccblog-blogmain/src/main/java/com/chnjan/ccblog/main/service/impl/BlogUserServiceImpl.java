package com.chnjan.ccblog.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.chnjan.ccblog.main.dao.BlogUserDao;
import com.chnjan.ccblog.main.domain.BlogUser;
import com.chnjan.ccblog.main.service.BlogUserService;

/**
 * @author chenjian
 *
 */
@Service("blogUserService")
public class BlogUserServiceImpl implements BlogUserService {

	@Autowired
	private BlogUserDao blogUserDao;
	
	/**
	 * 通过路径里的url变量查询用户信息
	 * @param url 从路径中获取的用户url变量
	 * @return BlogUser url对应的用户信息
	 * */
	public BlogUser queryBlogUserByUrl(String url) {
		if (url==null || "".equals(url)) {
			return null;
		}
		BlogUser userInfo = blogUserDao.queryBlogUserByUrl(url);
		return userInfo;
	}

	/**
	 * @see com.chnjan.ccblog.main.service.BlogUserService#queryBlogUserByUid(String)
	 * */
	@Override
	public BlogUser queryBlogUserByUid(String uid) {
		if (StringUtils.isEmpty(uid)) {
			return null;
		}
		BlogUser user = blogUserDao.queryBlogUserByUid(uid);
		return user;
	}

}
