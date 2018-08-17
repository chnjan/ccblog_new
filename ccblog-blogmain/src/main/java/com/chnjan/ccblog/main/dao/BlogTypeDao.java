/**
 * 
 */
package com.chnjan.ccblog.main.dao;

import java.util.List;

import com.chnjan.ccblog.main.domain.BlogType;

/**
 * @author chenjian
 * @date 2018年6月6日
 */
public interface BlogTypeDao {
	
	/**
	 * 根据用户typeid查询log分类
	 * @param typeId
	 * @return BlogType
	 * */
	BlogType queryBlogTypesByTypeId(String typeId);
	
	/**
	 * 根据url查询该用户下的所有blog分类
	 * */
	List<BlogType> queryBlogTypesByUserurl(String uurl);

}
