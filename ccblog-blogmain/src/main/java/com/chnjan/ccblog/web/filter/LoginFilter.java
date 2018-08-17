/**
 * 
 */
package com.chnjan.ccblog.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.chnjan.ccblog.main.domain.BlogUser;
import com.chnjan.ccblog.main.service.BlogUserService;
import com.chnjan.ccblog.pub.outsys.http.HttpUtil;
import com.chnjan.ccblog.pub.sysparam.SystemParamUtil;
import com.chnjan.ccblog.pub.sysparam.XmlConfRead;

/**
 * @author chenjian
 * @date 2018年6月16日
 * 登录拦截过滤器
 */
public class LoginFilter implements Filter {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);
	
	//Spring容器
	private WebApplicationContext webApplicationContext;
	
	//需拦截的地址
	private static Set<String> urls = XmlConfRead.getInterceptUrls();

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取web容器
		ServletContext sc = filterConfig.getServletContext();
		//获取spring容器
		webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		//ip地址
		String localip = httpServletRequest.getLocalAddr();
		String localName = httpServletRequest.getLocalName();
		//客户ip
		String clientIp = httpServletRequest.getRemoteAddr();
		//客户主机
		String remoteHost = httpServletRequest.getRemoteHost();
		//请求用户的电脑账号
		String localUser = httpServletRequest.getRemoteUser();
		
		//uri地址
		String uri = httpServletRequest.getRequestURI();
		
		LOGGER.info("client--"+"ip:"+clientIp+",host:"+remoteHost+",User:"+localUser+"--访问--"+"server--"
						+"ip:"+localip+",name:"+localName+",uri:"+uri);
		String contex = httpServletRequest.getContextPath();
		//去除context后的uri
		String compuri = uri.substring(contex.length());
		//如果当前请求的uri在需要拦截的配置里
		if (isNeedIntercept(compuri)) {
			//System.out.println("1--9-");
			//当前访问的用户是否有权限访问
			boolean islogin = loginValidate(httpServletRequest, httpServletResponse);
			if (islogin) {
				//登录验证通过
				chain.doFilter(httpServletRequest, httpServletResponse);
				//System.out.println("18---");
			} else {
				//System.out.println("4---");
				//跳转到统一登录平台---------------
				//统一验证平台登录页面地址
				String loginPageUrl = SystemParamUtil.getSysValue("auth.login.signinurl");
				//带上受限资源连接
				loginPageUrl = loginPageUrl +"?callback="+ httpServletRequest.getRequestURL();
				httpServletResponse.sendRedirect(loginPageUrl);
			}
			
		}else {
			chain.doFilter(request, response);
		}

	}
	
	/**
	 * 受限资源进行拦截处理，判断是否有权限访问
	 * @throws IOException 
	 * */
	private boolean loginValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//定义登录验证是否通过的标志
		boolean islogin = false;
		//System.out.println("2--10-");
		HttpSession session = request.getSession();
		//首先从session里获取用户的token
		Object logintoken = session.getAttribute("token");
		
		//为空说明用户没登录，或过期，然后需进一步验证请求地址有没有带token
		if (logintoken == null) {
			//判断请求地址后面有没有带token
			String token = request.getParameter("signinkey");
			//System.out.println("3--11-");
			//如果请求地址也没有token，那说明就没有登录，重定向到统一验证平台的登录页面
			if (!StringUtils.isEmpty(token)) {
				//System.out.println("12---");
				//有值说明在统一登录平台登录过，回调过来的---------
				//调统一登录平台的接口验证此token的真假或有效性
				String uid = isEffectToken(token);
				//验证通过则登录并保存session，验证不通过跳到登录页面
				if (StringUtils.hasText(uid)) {
					session.setAttribute("token", token);
					//根据uid查询用户信息，然后放入session
					BlogUserService blogUserService = (BlogUserService) webApplicationContext.getBean("blogUserService");
					BlogUser blogUser = blogUserService.queryBlogUserByUid(uid);
					session.setAttribute("currentUser", blogUser);
					islogin = true;
					//System.out.println("17---");
				}
			}
		}else {
			//非空说明已经登录
			islogin = true;
		}
		return islogin;
	}
	
	/**
	 * 向统一验证平台调接口验证token是否有效
	 * 请求报文类似{"systemid":"blogmain","token":"20184567854211"}
	 * 响应报文{"code":"1","desc":"success","iseffect":"y","userId":"20180618120326123654"}
	 * @return String 有效返回用户id，否则返回null
	 * */
	@SuppressWarnings("unchecked")
	private String isEffectToken(String token) {
		//System.out.println("13---");
		
		String userId = null;
		
		//拼接报文------------------------
		Map<String, String> postMap = new HashMap<>();
		//从系统配置中获取系统id
		String systemid = SystemParamUtil.getSysValue("outsys.system.id");
		postMap.put("systemid", systemid);
		postMap.put("token", token);
		//装换成json字符串
		String postMsg = JSON.toJSONString(postMap);
		LOGGER.info("向统一验证平台发送请求验证token："+postMsg);
		//发送请求------------------------
		//从系统配置中获取服务地址
		String url = SystemParamUtil.getSysValue("outsys.token.validurl");
		//返回报文
		String acceptMsg = null;
		try {
			acceptMsg = HttpUtil.httppost(url, postMsg);
			
		} catch (Exception e) {
			LOGGER.error("调用token验证接口异常："+e.getMessage());
		}
		
		//解析请求，并验证结果-----------------
		if (!StringUtils.isEmpty(acceptMsg)) {
			Map<String, Object> returnMap = (Map<String, Object>) JSON.parse(acceptMsg);
			String code = (String) returnMap.get("code");
			String iseffect = (String) returnMap.get("iseffect");
			//接口执行成功，并验证token有效
			if ("1".equals(code) && "y".equals(iseffect)) {
				//从响应报文里取得用户id
				userId = (String) returnMap.get("userId");
			}
		}
		LOGGER.info("调token验证接口："+acceptMsg);
		//System.out.println("16---");
		return userId;
	}
	
	/**
	 * 判断输入的uri字符串是否是受限资源
	 * */
	private boolean isNeedIntercept(String uri) {
		for (String urStr : urls) {
			if (uri.startsWith(urStr)) {
				return true;
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		
	}

}
