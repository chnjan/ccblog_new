
package com.chnjan.ccblog.main.dao;

import com.chnjan.ccblog.main.domain.BlogUser;

/**
 * @author chenjian
 * 2017-12-24
 * 用户信息查询dao
 */
public interface BlogUserDao {

	/**
	 * 通过路径里的url变量查询用户信息
	 * 
	 * */
	BlogUser queryBlogUserByUrl(String url);
	
	/**
	 * 通过用户id查询用户信息
	 * 
	 * */
	BlogUser queryBlogUserByUid(String uid);
}
