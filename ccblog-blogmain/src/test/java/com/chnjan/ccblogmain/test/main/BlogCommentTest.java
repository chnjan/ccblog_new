/**
 * 
 */
package com.chnjan.ccblogmain.test.main;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chnjan.ccblog.main.domain.BlogComment;
import com.chnjan.ccblog.main.service.BlogCommentService;

/**
 * @author chenjian
 * @date 2018年10月28日
 * blog评论测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml",
	"classpath:mybatis/spring-mybatis.xml",
	"classpath:timer/*.timer.xml"})
public class BlogCommentTest {
	
	@Autowired
	private BlogCommentService blogCommentService;
	
	@Test
	public void commentListQueryTest() {
		String blogId = "2018062515131841401493656";
		List<BlogComment> comments = blogCommentService.getBlogCommentsByBlogId(blogId);
		for (BlogComment blogComment : comments) {
			System.out.println(blogComment.toString());
		}
	}

}
