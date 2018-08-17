/**
 * 
 */
package com.chnjan.ccblog.main.service;

import java.util.List;

import com.chnjan.ccblog.main.domain.BlogType;

/**
 * @author chenjian
 * @date 2018年6月6日
 */
public interface BlogTypeService {

	/**
	 * 根据用户typeid查询log分类
	 * @param typeId
	 * @return BlogType
	 * */
	BlogType queryBlogTypesByTypeId(String typeId);
	
	/**
	 * 根据用户url查询该用户下的所有blog分类
	 * @param uurl 用户url
	 * @return List<BlogType>
	 * */
	List<BlogType> queryBlogTypesByUserurl(String uurl);
}
