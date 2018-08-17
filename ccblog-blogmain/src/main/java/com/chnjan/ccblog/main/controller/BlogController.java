package com.chnjan.ccblog.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chnjan.ccblog.pub.random.IdGenerate;
import com.chnjan.ccblog.pub.page.Pagination;
import com.chnjan.ccblog.pub.htmltools.HtmlTool;
import com.chnjan.ccblog.main.domain.Blog;
import com.chnjan.ccblog.main.domain.BlogType;
import com.chnjan.ccblog.main.domain.BlogUser;
import com.chnjan.ccblog.main.service.BlogService;
import com.chnjan.ccblog.main.service.BlogTypeService;
import com.chnjan.ccblog.main.service.BlogUserService;

/**
 * @author chenjian
 * blog controller类
 * 2017-12-23
 */
@Controller
public class BlogController{
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private BlogUserService blogUserService;
	
	@Autowired
	private BlogTypeService blogTypeService;
	
	private Pagination page;
	//分页查询时每页的数量
	private int pagesize = 15;

	@RequestMapping("/blog")
	public String errorpage() {
		return "error";
	}
	
	/**
	 * 查询用户blog列表
	 * */
	@RequestMapping("/blog/{userUrl}")
	public ModelAndView showUserBlogList(@PathVariable String userUrl,
			@RequestParam(value = "page",defaultValue = "1") String currentPage) {
		ModelAndView mav = new ModelAndView();
		//查询用户信息
		BlogUser userInfo = queryUserBlogInfo(userUrl,mav);
		if (userInfo == null) {
			return mav;
		}
		
		//设置分页参数
		page = new Pagination();
		//设置每页数量
		page.setPageSize(pagesize);
		page.setCurrentPage(currentPage);
		
		//查询用户blog列表
		List<Blog> blogs = blogService.queryBlogListByUid(userUrl,page);
		
		mav.setViewName("main/blog/personalBlogList");
		
		//blog列表信息
		mav.addObject("userBlogs", blogs);
		//分页信息
		mav.addObject("page", page);
		//当前页面uri，分页使用
		mav.addObject("pageuri", userUrl);
		return mav;
	}
	
	/**
	 * 根据分类查询blog列表
	 * */
	@RequestMapping("/blog/{userUrl}/{typeId}")
	public ModelAndView showCatalogBlogs(@PathVariable String userUrl,@PathVariable String typeId,
			@RequestParam(value = "page",defaultValue = "1") String currentPage) {
		ModelAndView mav = new ModelAndView();
		//查询用户信息
		BlogUser userInfo = queryUserBlogInfo(userUrl,mav);
		if (userInfo == null) {
			return mav;
		}
		
		//设置分页参数
		page = new Pagination();
		//设置每页数量
		page.setPageSize(pagesize);
		page.setCurrentPage(currentPage);
		
		List<Blog> blogs = null;
		if ("0".equals(typeId)) {
			//查询默认分类下的blog
			blogs = blogService.queryDefaultTypeBlogList(userUrl, page);
		} else {
			//查询分类下的blog
			blogs = blogService.queryBlogListByType(typeId, page);
		}
		
		mav.setViewName("main/blog/personalBlogList");
		
		//blog列表信息
		mav.addObject("userBlogs", blogs);
		//分页信息
		mav.addObject("page", page);
		//当前页面uri，分页使用
		mav.addObject("pageuri", userUrl+"/"+typeId);
		
		return mav;
	}

	/**
	 * 查询某条blog详细信息
	 * */
	@RequestMapping("/blog/{userUrl}/{blogId}.html")
	public ModelAndView showUserBlog(@PathVariable String userUrl,@PathVariable String blogId) {
		ModelAndView mav = new ModelAndView();
		//查询用户信息
		BlogUser userInfo = queryUserBlogInfo(userUrl,mav);
		if (userInfo == null) {
			return mav;
		}
		
		//展示blog详情页
		Blog blog = blogService.queryBlogById(blogId);
		//blog为空或者userUrl不匹配
		if (blog == null || !userUrl.equals(blog.getUserUrl())) {
			//错误页面
			mav.setViewName("error");
			return mav;
		}
		
		//查询blogtype
		BlogType blogType = blogTypeService.queryBlogTypesByTypeId(blog.getTypeid());
		//如果没有对应的分类，则展示默认分类
		if (blogType == null) {
			blogType = new BlogType();
			blogType.setTypeId("0");
			blogType.setTypeName("默认分类");
			blogType.setUserUrl(userUrl);
		}
		
		//blog详情页面
		mav.setViewName("main/blog/blogDetailPage");
		
		//blog信息
		mav.addObject("userBlog", blog);
		//分类信息
		mav.addObject("blogType", blogType);
		
		return mav;
	}
	
	/**
	 * 新增blog
	 * */
	@RequestMapping("/user/blog/add")
	public ModelAndView addBlog(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//获取登录的用户url
		String userUrl = getcurrentUserurl(request);//"chnjan";
		//通过获取的url查询用户信息
		BlogUser userInfo = queryUserBlogInfo(userUrl, mav);
		if (userInfo == null) {
			return mav;
		}
		mav.setViewName("main/blog/blogEdit");
		return mav;
	}
	
	/**
	 * 编辑blog
	 * */
	@RequestMapping("/user/blog/edit")
	public ModelAndView editBlog(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		//获取当前登录的用户信息
		String userUrl = getcurrentUserurl(request);//"chnjan";
		
		//设置用户信息
		BlogUser userInfo = queryUserBlogInfo(userUrl, mav);
		//查询的用户为空，返回错误页面
		if (userInfo == null) {
			return mav;
		}
		
		//获取要修改的blogid
		String blogId = request.getParameter("blogid");
		
		//查询要修改的blog
		Blog blog = blogService.queryBlogById(blogId);
		
		//如果要修改的blog不是当前登录人的则返回错误页面
		if (!userUrl.equals(blog.getUserUrl())) {
			return mav;
		}
		mav.addObject("editBlog", blog);
		mav.setViewName("main/blog/blogEdit");
		return mav;
	}
	/**
	 * 显示新增或修改blog
	 * */
	/*@RequestMapping("/user/{userUrl}/{action}")
	public ModelAndView showEditBlog(@PathVariable String userUrl, @PathVariable String action,
			HttpServletRequest request,Blog blog) {
		ModelAndView mav = new ModelAndView();

		// 判断用户是否已登录，当前用户与userUrl对应的用户是否相同

		// 设置用户信息
		BlogUser userInfo = queryUserBlogInfo(userUrl, mav);
		if (userInfo == null) {
			return mav;
		}

		// 判断动作类型
		if ("add".equals(action)) {
			// 新增----------------
			mav.setViewName("main/blog/blogEdit");
			return mav;
		
		} else if ("edit".equals(action)) {
			// 修改-----------------
			mav.setViewName("main/blog/blogEdit");
			return mav;
		
		} else if ("save".equals(action)) {
			//保存-----------------
			//验证参数是否符合要求
			if (!validBlog(blog)) {
				mav.setViewName("errorvalid");
				return mav;
			}
			//设置id,01表示blog
			blog.setBlogId(IdGenerate.generateId("01"));
			String content = blog.getContent();
			
			//设置摘要
			//删除html标签
			String blogAbstract = HtmlTool.delHTMLTag(content);
			//截取前200位
			if (blogAbstract.length()>200) {
				blogAbstract = blogAbstract.substring(0,199);
			}
			blog.setBlogAbstract(blogAbstract);
			
			//设置用户信息
			blog.setUserUrl(userInfo.getUserUrl());
			
			//保存
			blogService.addBlog(blog);
			
			//如果保存成功
			mav.setViewName("forward:/blog/"+userUrl);
			return mav;
		
		// 如果都不是
		} else {
			mav.setViewName("error");
			return mav;
		}
		
	}*/
	
	/**
	 * 保存blog
	 * */
	@RequestMapping("/user/blog/save")
	public ModelAndView saveBlog(HttpServletRequest request,Blog blog) {
		ModelAndView mav = new ModelAndView();

		//获取当前登录的用户信息
		String userUrl = getcurrentUserurl(request);//"chnjan";
		
		// 设置用户信息
		BlogUser userInfo = queryUserBlogInfo(userUrl, mav);
		if (userInfo == null) {
			return mav;
		}
		
		//验证参数是否符合要求
		if (!validBlog(blog)) {
			mav.setViewName("errorvalid");
			return mav;
		}
		
		String editBlogid = blog.getBlogId();
		
		Blog newBlog = null;
		boolean isedit = false;
		
		//通过blogid判断是修改还是保存
		if (StringUtils.isEmpty(editBlogid)) {
			//新增
			newBlog = new Blog();
			//设置id,01表示blog
			newBlog.setBlogId(IdGenerate.generateId("01"));
			
		} else {
			//修改
			newBlog = blogService.queryBlogById(editBlogid);
			//如果修改时没有查到要修改的blog则返回错误页面
			if (newBlog == null) {
				mav.setViewName("errorvalid");
				return mav;
			}
			isedit = true;
		}
		
		String content = blog.getContent();
		//设置内容
		newBlog.setContent(content);
		//设置标题
		newBlog.setTitle(blog.getTitle());
		//设置摘要
		//删除html标签
		String blogAbstract = HtmlTool.delHTMLTag(content);
		//截取前200位
		if (blogAbstract.length()>200) {
			blogAbstract = blogAbstract.substring(0,199);
		}
		newBlog.setBlogAbstract(blogAbstract);
		
		//设置blog类型
		newBlog.setTypeid(blog.getTypeid());
		
		//设置用户
		newBlog.setUserUrl(userUrl);
		
		//保存
		if (isedit) {
			blogService.updateBlog(newBlog);
		}else {
			blogService.addBlog(newBlog);
		}
		
		//如果保存成功
		//mav.setViewName("forward:/blog/"+userUrl);
		mav.setViewName("redirect:/blog/"+userUrl);
		return mav;
	}
	
	/**
	 * 获取当前登录用户的url
	 * */
	private String getcurrentUserurl(HttpServletRequest request) {
		HttpSession session = request.getSession();
		BlogUser blogUser = (BlogUser) session.getAttribute("currentUser");
		String userUrl = blogUser.getUserUrl();
		return userUrl ;
	}
	
	/**
	 * 根据用户的url来判断用户是否存在，
	 * 如果存在，将用户信息设置到ModelAndView
	 * 如果不存在返回错误页面
	 * @param userUrl 用户url路径
	 * @param mav 传入的ModelAndView
	 * @return UserBlogInfo 用户存在：用户信息对象
	 * 				不存在：null
	 * */
	public BlogUser queryUserBlogInfo(String userUrl, ModelAndView mav) {
		//userUrl为空，直接跳到错误页面
		if (userUrl==null || "".equals(userUrl)) {
			mav.setViewName("error");
			return null;
		}
		
		//通过url查用户信息
		BlogUser userInfo = blogUserService.queryBlogUserByUrl(userUrl);
		
		//对应的用户不存在
		if (userInfo == null || "".equals(userInfo.getUserId())) {
			mav.setViewName("error");
			return null;
		}
		
		//通过url查询用户的blog分类信息
		List<BlogType> types = blogTypeService.queryBlogTypesByUserurl(userUrl);
		mav.addObject("userTypeInfo", types);
		
		//blog作者信息
		mav.addObject("blogUserInfo", userInfo);
		return userInfo;
	}
	
	/**
	 * 验证前台输入的blog信息合法性
	 * @param blog blog对象
	 * @return boolean true:没问题 ,false:有问题
	 * */
	public boolean validBlog(Blog blog) {
		if(blog == null) {
			return false;
		}
		String title = blog.getTitle();
		if (title == null||title.length()>250) {
			return false;
		}
		String content = blog.getContent();
		if (content == null || content.length()>19000) {
			return false;
		}
		return true;
	}
}
