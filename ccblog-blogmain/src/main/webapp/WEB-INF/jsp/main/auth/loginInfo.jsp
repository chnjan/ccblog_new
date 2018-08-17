<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="com.chnjan.ccblog.pub.sysparam.SystemParamUtil" %>
<%
	String loginpage = SystemParamUtil.getSysValue("auth.login.signinurl");
%>
<div id="head_top">
	<div id="logindiv">
		<c:if test="${empty sessionScope.currentUser}">
			<a class="login_regin" href="<%=loginpage%>">登录</a>
			<a class="login_regin" href="javascript:void(0);">注册</a>
		</c:if>
		<c:if test="${!empty sessionScope.currentUser}">
			<a class="login_regin" href="<%=request.getContextPath() %>/blog/${sessionScope.currentUser.userUrl}">${sessionScope.currentUser.nickName}</a>
			<a class="login_regin" href="javascript:void(0);">退出</a>
		</c:if>
	</div>
</div>