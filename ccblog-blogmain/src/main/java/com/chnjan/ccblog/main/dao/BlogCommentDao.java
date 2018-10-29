/**
 * 
 */
package com.chnjan.ccblog.main.dao;

import java.util.List;

import com.chnjan.ccblog.main.domain.BlogComment;

/**
 * @author chenjian
 * @date 2018年10月28日
 */
public interface BlogCommentDao {

	/**
	 * 通过blogId查询评论列表
	 * @param blogId
	 * @return List<BlogComment>
	 * */
	List<BlogComment> queryCommetList(String blogId);
}
