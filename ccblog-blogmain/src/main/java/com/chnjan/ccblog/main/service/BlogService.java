package com.chnjan.ccblog.main.service;

import java.util.List;

import com.chnjan.ccblog.pub.page.Pagination;
import com.chnjan.ccblog.main.domain.Blog;


/**
 * 2017-12-16
 * @author chenjian
 * 博客service接口
 */
public interface BlogService {

	/**
	 * 通过id查询一条博客信息
	 * 
	 * */
	Blog queryBlogById(String blogId);
	
	/**
	 * 新增一条blog信息
	 * 
	 * */
	void addBlog(Blog blog);
	
	/**
	 * 删除blog
	 * 
	 * */
	int deleteBlogById(String blogId);
	
	/**
	 * 修改blog
	 * 
	 * */
	int updateBlog(Blog blog);
	
	/**
	 * 首页查询博客列表
	 * */
	List<Blog> queryBlogList();
	
	/**
	 * 查询某个用户的所有blog列表
	 * @param uid 用户id
	 * @param page 分页信息对象
	 * @return List<blog>某个用户的blog列表
	 * */
	List<Blog> queryBlogListByUid(String uid,Pagination page);
	
	/**
	 * 查询某个分类的所有blog列表
	 * @param typeId blog分类id
	 * @param page 分页信息对象
	 * @return List<blog>某个分类下的blog列表
	 * */
	List<Blog> queryBlogListByType(String typeId,Pagination page);
	
	/**
	 * 查询某个用户下默认分类的所有blog列表
	 * @param userUrl 用户id
	 * @param page 分页信息对象
	 * @return List<blog>某个用户默认分类下的blog列表
	 * */
	List<Blog> queryDefaultTypeBlogList(String userUrl,Pagination page);
}
