/**
 * 
 */
package com.chnjan.ccblog.base.test.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chnjan.ccblog.base.domain.UserInfo;
import com.chnjan.ccblog.base.service.UserInfoService;

/**
 * @author chenjian
 * @date 2018年6月15日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml",
	"classpath:mybatis/spring-mybatis.xml"})
public class UserTest {
	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void userquerytest() {
		String uid = "20180615173526123456";
		UserInfo userInfo = userInfoService.queryUserInfoById(uid);
		System.out.println(userInfo);
	}
}
