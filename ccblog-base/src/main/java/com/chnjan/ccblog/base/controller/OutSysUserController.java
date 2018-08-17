package com.chnjan.ccblog.base.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.chnjan.ccblog.base.domain.UserSession;
import com.chnjan.ccblog.base.service.UserSessionService;

/**
 * @author chenjian
 * @date 2018年6月17日
 * 提供接口给外部系统调用
 */
@Controller
public class OutSysUserController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(OutSysUserController.class);
	
	@Autowired
	private UserSessionService userSessionService;

	/**
	 * 验证token
	 * 请求报文类似{"systemid":"blogmain","token":"20184567854211"}application/json
	 * 响应报文{"code":"1","desc":"success","iseffect":"y","userId":"20180618120326123654"}
	 * */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/outsys/user/token",method=RequestMethod.POST,produces= {"text/html;charset=UTF-8"})
	@ResponseBody
	public String validToken(HttpServletRequest request) {
		//System.out.println("14---");
		//请求报文
		String requsetMsg = null;
		//响应报文
		String returnMsg = null;
		Map<String, Object> responseMap = new HashMap<>();
		
		String token = null;
		String outsysid = null;
		try {
			//获取请求报文
			requsetMsg = getRequsetMessage(request);
			Map<String, Object> requestMap = (Map<String, Object>) JSON.parse(requsetMsg);
			//外部系统id
			outsysid = (String) requestMap.get("systemid");
			//要验证的token
			token = (String) requestMap.get("token");
		} catch (Exception e) {
			LOGGER.error("服务错误:"+e.getMessage());
		}
		if (StringUtils.isEmpty(outsysid) || StringUtils.isEmpty(token)) {
			responseMap.put("code", "0");
			responseMap.put("desc", "报文格式错误");
			responseMap.put("iseffect", "n");
			responseMap.put("userId", null);
			returnMsg = JSON.toJSONString(responseMap);
			LOGGER.info("外部系统"+outsysid+"调用验证token接口失败:"+returnMsg);
			return returnMsg;
		}
		//验证token是否有效
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UserSession userSession = userSessionService.getEffectUserSin(token);
		System.out.println("验证token是否有效,查询的"+userSession);
		if (userSession == null) {
			//token无效
			responseMap.put("code", "1");
			responseMap.put("desc", "token无效");
			responseMap.put("iseffect", "n");
			responseMap.put("userId", null);
		}else {
			//token有效
			responseMap.put("code", "1");
			responseMap.put("desc", "接口调用成功");
			responseMap.put("iseffect", "y");
			responseMap.put("userId", userSession.getUid());
		}
		returnMsg = JSON.toJSONString(responseMap);
		LOGGER.info("外部系统"+outsysid+"调用验证token接口成功:"+returnMsg);
		//System.out.println("15---");
		return returnMsg;
	}
	
	/**
	 * 从request里面获取请求报文
	 * @throws IOException
	 * */
	private String getRequsetMessage(HttpServletRequest request) throws IOException {
		//InputStream inputStream = request.getInputStream();
		//InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		//会以filter里设置的utf-8编码来解码
		BufferedReader bufferedReader = request.getReader();//new BufferedReader(inputStreamReader);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
		}
		
		return sb.toString();
	}
}
