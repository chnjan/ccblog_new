<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();
	String bathPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
	<link href="<%=path %>/css/auth/auth.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="<%=path %>/js/jquery/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/main/auth/login.js"></script>
</head>
<body>
<script type="text/javascript">
var content = "<%= path%>";
$(document).ready(function(){
	$("#span_vali").on("click",function(){
		$("#valiImg").attr("src","<%=path %>/signin/getvaliImg?b="+Math.random());
	});
	$("#lgin").on("click",loginform);
	$("#loginName").on("focus",function(){
		if($("#loginName").val()=="登录账号/邮箱/手机号码")
		{
			$("#loginName").val("");
		}
	});
	$("#loginName").on("blur",function(){
		if($("#loginName").val()=="")
		{
			$("#loginName").val("登录账号/邮箱/手机号码");
		}
	});
});

</script>
<div class="maindiv">
	<div>
		<form id="loginform" action="<%= path%>/auth/signin" method="post">
			<input name="callback" value="${callback}" type="hidden">
			<table id="table_login">
				<thead>
					<tr><td colspan="2"><span id="login_thead">登录</span></td></tr>
				</thead>
				<tbody>
					<tr><td colspan="2"><input class="input_login" id="loginName" name="loginName" type="text" value="登录账号/邮箱/手机号码" /></td></tr>
					<tr><td colspan="2"><input class="input_login" id="passWord" name="passWord" type="password"/></td></tr>
					<tr>
						<td width="45%">
							<input id="vali_passimg" name="vali_passimg" type="text" maxlength="6" />
							<span id="span_hasvali"></span>
						</td>
						<td width="65%">
							<img id="valiImg" style="width: 100px;height: 25px;float: left;" alt="验证码" src="<%=path %>/signin/getvaliImg" />
							<span id="span_vali" style="background-image:url('<%=path %>/image/auth/refesh.jpg');"></span>
						</td>
					</tr>
					<c:if test="${msg != null}">
					<tr style="text-align: center;"><td colspan="2"><label style="color: red">${msg}</label></td></tr>
					</c:if>
					<tr style="text-align: center;"><td colspan="2"><input id="lgin" type="button" value="登录" /></td></tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
</body>
</html>