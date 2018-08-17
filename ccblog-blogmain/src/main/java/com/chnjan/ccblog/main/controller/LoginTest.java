/**
 * 
 */
package com.chnjan.ccblog.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chnjan.ccblog.pub.sysparam.SystemParamUtil;

/**
 * @author chenjian
 * @date 2018年6月13日
 */
@Controller
public class LoginTest {

	@RequestMapping("/needlogin")
	public String redirectTest(HttpServletRequest request,HttpServletResponse response) {
		//判断如果session里没有
		//如果没有说明没登录，重定向到登录系统的登录页面
		try {
			response.sendRedirect("http://localhost:8088/ccuser/user/tosignin");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success ok";
	}
	
	@RequestMapping("/needlog")
	public void redirectTest2(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		//先取token判断有无
		String token = request.getParameter("key");
		System.out.println(token);
		//如果没有token或token无效就跳到登录界面
		if (StringUtils.isEmpty(token)) {
			
			String reqstUrl = request.getRequestURL().toString();
			//判断如果session里没有
			//如果没有说明没登录，重定向到登录系统的登录页面
			//登录地址
			String signinurl = SystemParamUtil.getSysValue("auth.login.signinurl");
			
			//登录地址带上参数
			signinurl = signinurl + "?callback=" + reqstUrl;
			try {
				response.sendRedirect(signinurl);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		//token有效就继续访问
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write("登录成功，成功看到需要登录后才能看到的内容");
			writer.flush();
			writer.close();
		}
		
	}
}
