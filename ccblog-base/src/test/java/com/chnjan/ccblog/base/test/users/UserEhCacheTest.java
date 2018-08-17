/**
 * 
 */
package com.chnjan.ccblog.base.test.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chnjan.ccblog.pub.cache.CurrentUserCache;

/**
 * @author chenjian
 * @date 2018年7月24日
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml",
	"classpath:mybatis/spring-mybatis.xml"})
public class UserEhCacheTest {

	@Autowired
	private ApplicationContext apcxt;
	
	@Test
	public void testcache() {
		 CurrentUserCache userCache = (CurrentUserCache) apcxt.getBean("currentUserCache");
		 //添加
		 userCache.putCurrentUser("2018", "66666666");
		 //查询
		 String reString = (String) userCache.getCurrentUser("2018");
		 System.out.println(reString);
		 //移除
		 userCache.removeCurrentUser("2018");
		 //查询
		 String reString2 = (String) userCache.getCurrentUser("2018");
		 System.out.println(reString2);
	}
}
