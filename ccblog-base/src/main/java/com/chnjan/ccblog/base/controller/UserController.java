/**
 * 
 */
package com.chnjan.ccblog.base.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chnjan.ccblog.base.domain.UserInfo;
import com.chnjan.ccblog.base.domain.UserSession;
import com.chnjan.ccblog.base.service.UserInfoService;
import com.chnjan.ccblog.base.service.UserSessionService;
import com.chnjan.ccblog.pub.sysparam.SystemParamUtil;
import com.chnjan.ccblog.base.common.random.RandomImage;

/**
 * @author chenjian
 * @date 2018年6月11日
 */
@Controller
public class UserController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserSessionService userSessionService;
	
	@RequestMapping("/auth/tosignin")
	public ModelAndView loginPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//System.out.println("5---");
		//回调地址
		String callbackurl = request.getParameter("callback");
		
		//验证之前是否已经登录过------------------------
		//获取token，并验证其是否有效，如果有效说明已经登录过
		Cookie[] cookies = request.getCookies();
		String token = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("token".equals(cookie.getName())) {
					token = cookie.getValue();
					break;
				}
			}
		}
		
		//验证token是否有效
		UserSession userSession = userSessionService.getEffectUserSin(token);
		//无效返回登录页面
		if (userSession == null) {
			//System.out.println("6---");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("callback", callbackurl);
			modelAndView.setViewName("base/login/userLoginPageForm");
			return modelAndView;
		} else {
			//有效则跳转到回调页面，没有回调页面到默认页面
			if (!StringUtils.hasText(callbackurl)) {
				callbackurl = SystemParamUtil.getSysValue("auth.login.mainpage");
			}
			response.sendRedirect(callbackurl);
			return null;
		}
		
		
	}
	
	@RequestMapping("/auth/signin")
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		//验证验证码--------------
		//验证码
		//System.out.println("7---");
		String valicode = request.getParameter("vali_passimg");
		//验证码生成时保存在session里的值
		String sessionvalicode = (String) request.getSession().getAttribute("valicode");
		if (!(StringUtils.hasText(valicode) && valicode.equalsIgnoreCase(sessionvalicode))) {
			//验证码不通过，直接返回
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/auth/tosignin").forward(request, response);
			return;
		}
		
		//验证登录名和密码------------
		//用户名或邮箱或电话号码
		String name = request.getParameter("loginName");
		//密码
		String pwd = request.getParameter("passWord");
		if (!StringUtils.hasText(name) || !StringUtils.hasText(pwd)) {
			//用户名或密码有一个是空，直接返回
			request.setAttribute("msg", "请输入用户名和密码");
			request.getRequestDispatcher("/auth/tosignin").forward(request, response);
			return;
		}
		//验证用户名和密码是否匹配
		UserInfo userInfo = userInfoService.validPwd(name, pwd);
		if (userInfo == null) {
			//用户名和密码不匹配
			request.setAttribute("msg", "用户名或密码输入错误");
			request.getRequestDispatcher("/auth/tosignin").forward(request, response);
			return;
		}
		
		//处理登录操作-------------
		//生成唯一token
		String token = UUID.randomUUID().toString();
		//新增usersession
		UserSession newUserSession = new UserSession();
		newUserSession.setUid(userInfo.getUserId());
		newUserSession.setToken(token);
		userSessionService.newSession(newUserSession);
		//设置cookie
		Cookie cookie = new Cookie("token", token);
		//过期时间为关闭浏览器后清除
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		//跳转到回调地址
		String callbackurl = request.getParameter("callback");
		if (!StringUtils.hasText(callbackurl)) {
			callbackurl = SystemParamUtil.getSysValue("auth.login.mainpage");
		}
		//System.out.println("8---");
		response.sendRedirect(callbackurl+"?signinkey="+token);
	}
	
	/**
	 * 返回验证码图片
	 * 
	 * */
	@RequestMapping("/signin/getvaliImg")
	public void getValiImg(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		//生成随机验证码图片
		Map<String, Object> imgs = RandomImage.getValidImageAndStr();
		
		//随机码
		session.setAttribute("valicode", imgs.get("str"));
		BufferedImage valiImg = (BufferedImage) imgs.get("img");
		//设置响应内容为png图片
		response.setContentType("image/png");
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			ImageIO.write(valiImg, "png", os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(imgs.get("str"));
	}

}
