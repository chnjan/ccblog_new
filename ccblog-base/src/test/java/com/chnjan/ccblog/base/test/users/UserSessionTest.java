/**
 * 
 */
package com.chnjan.ccblog.base.test.users;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chnjan.ccblog.base.domain.UserSession;
import com.chnjan.ccblog.base.service.UserSessionService;

/**
 * @author chenjian
 * @date 2018年6月16日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml",
	"classpath:mybatis/spring-mybatis.xml"})
//按方法的定义顺序执行
@FixMethodOrder(MethodSorters.DEFAULT)
public class UserSessionTest {

	@Autowired
	private UserSessionService userSessionService;
	
	@Test
	public void addTest() {
		UserSession userSession = new UserSession();
		userSession.setUid("20181615");
		userSession.setToken("20181615");
		//userSessionService.newSession(userSession);
	}
	
	@Test
	public void queryTest() throws InterruptedException {
		UserSession userSession = userSessionService.getUsrSession("650cd071-d4e2-4549-a091-45698f184a43");
		System.out.println(userSession);
		//Assert.assertTrue(userSession!=null);
	}
	
	@Test
	public void updateTest() {
		userSessionService.updateSession("20181615");
	}
}
