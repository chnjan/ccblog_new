/**
 * 
 */
package com.chnjan.ccblog.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chnjan.ccblog.main.dao.BlogTypeDao;
import com.chnjan.ccblog.main.domain.BlogType;
import com.chnjan.ccblog.main.service.BlogTypeService;

/**
 * @author chenjian
 * @date 2018年6月6日
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService{
	
	@Autowired
	private BlogTypeDao blogTypeDao;
	
	/**
	 * 根据typeid查询分类
	 * */
	@Override
	public BlogType queryBlogTypesByTypeId(String typeId) {
		
		return blogTypeDao.queryBlogTypesByTypeId(typeId);
	}

	/**
	 * 根据url查询该用户下的所有blog分类
	 * */
	@Override
	public List<BlogType> queryBlogTypesByUserurl(String uurl) {
		
		return blogTypeDao.queryBlogTypesByUserurl(uurl);
	}

}
