/**
 * 
 */
package com.chnjan.ccblog.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chnjan.ccblog.main.dao.BlogCommentDao;
import com.chnjan.ccblog.main.domain.BlogComment;
import com.chnjan.ccblog.main.service.BlogCommentService;

/**
 * @author chenjian
 * @date 2018年10月28日
 * blog评论service实现
 */

@Service("blogCommentService")
public class BlogCommentServiceImpl implements BlogCommentService {
	
	@Autowired
	private BlogCommentDao blogCommentDao;

	/* (non-Javadoc)
	 * @see com.chnjan.ccblog.main.service.BlogCommentService#getBlogCommentsByBlogId(java.lang.String)
	 */
	@Override
	public List<BlogComment> getBlogCommentsByBlogId(String blogId) {
		List<BlogComment> comments = blogCommentDao.queryCommetList(blogId);
		return comments;
	}

}
