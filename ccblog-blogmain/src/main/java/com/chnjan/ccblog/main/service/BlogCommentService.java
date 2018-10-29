/**
 * 
 */
package com.chnjan.ccblog.main.service;

import java.util.List;

import com.chnjan.ccblog.main.domain.BlogComment;

/**
 * @author chenjian
 * @date 2018年10月28日
 * blog评论service
 */
public interface BlogCommentService {

	/**
	 * 通过blogId查询显示评论
	 * @param blogId
	 * @return List<BlogComment>
	 * */
	List<BlogComment> getBlogCommentsByBlogId(String blogId);
}
