
package com.chnjan.ccblog.main.service;

import com.chnjan.ccblog.main.domain.BlogUser;

/**
 * @author chenjian
 * 2017-12-24
 * 用户信息查询service
 */
public interface BlogUserService {
	
	/**
	 * 通过路径里的url变量查询用户信息
	 * @param url 从路径中获取的用户url变量
	 * @return BlogUser url对应的用户信息
	 * */
	BlogUser queryBlogUserByUrl(String url);
	
	/**
	 * 通过uid查询用户信息
	 * @param uid 用户唯一id
	 * @return BlogUser
	 * */
	BlogUser queryBlogUserByUid(String uid);

}
