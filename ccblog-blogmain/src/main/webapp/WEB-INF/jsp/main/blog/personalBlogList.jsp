<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String bathPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${blogUserInfo.nickName}的blog</title>
	<link href="<%=path %>/css/auth/auth.css" type="text/css" rel="stylesheet"/>
	<link href="<%=path %>/css/blog/blog-common.css" type="text/css" rel="stylesheet"/>
	<link href="<%=path %>/css/blog/bundle-SimpleMemory.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="<%=path %>/js/jquery/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/main/pagina.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/main/auth/loginInfo.jsp"></jsp:include>
<div id="home">
	<%-- <%@include file="/WEB-INF/jsp/main/blog/blogListHead.jsp" %> --%>
	<jsp:include page="/WEB-INF/jsp/main/blog/blogListHead.jsp"></jsp:include>

	<div id="main">
	<div id="mainContent">
	<div class="forFlow">
		<c:forEach var="ablog" items="${userBlogs }">
		<div class="day">
			<div class="dayTitle">
				<a id="homepage1_HomePageDays_DaysList_ctl00_ImageLink" href="http://www.cnblogs.com/skyfsm/archive/2017/12/23.html">2017年12月23日</a>				  
			</div>
			<div class="postTitle">
				<a class="postTitle2" id="homepage1_HomePageDays_DaysList_ctl00_DayList_TitleUrl_0" href="<%=path %>/blog/${ablog.userUrl}/${ablog.blogId}.html">${ablog.title }</a>
			</div>
			<div class="postCon"><div class="c_b_p_desc">摘要: ${ablog.blogAbstract}<a class="c_b_p_desc_readmore" href="<%=path %>/blog/${ablog.userUrl}/${ablog.blogId}.html">阅读全文</a></div></div>
			<div class="clear"></div>
			<div class="postDesc">
				posted @ <fmt:formatDate value="${ablog.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				&nbsp;&nbsp;&nbsp;&nbsp;${blogUserInfo.nickName}&nbsp;&nbsp;&nbsp;&nbsp;阅读(${ablog.readCount})&nbsp;评论(${ablog.commentCount})
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path %>/user/blog/edit?blogid=${ablog.blogId}" rel="nofollow">编辑</a></div>
			<div class="clear"></div>
		</div>
		</c:forEach>

		<input id="pageurl" type="hidden" value="<%=path %>/blog/${pageuri}" />
		<input id="currentpage" type="hidden" value="${page.currentPage}"/>
		<input id="totlepage" type="hidden" value="${page.totlePage}"/>
		<div class="topicListFooter">
			<div class="pager">共${page.totlePage }页，第${page.currentPage}页：&nbsp;
				<a href="<%=path %>/blog/${blogUserInfo.userUrl}">首页</a>&nbsp;
				<a id="pre" href="javascript:void(0);" onclick="prePage()">上一页</a>&nbsp;
				<a id="next" href="javascript:void(0);" onclick="nextPage()">下一页</a>&nbsp;
				<a href="<%=path %>/blog/${blogUserInfo.userUrl}?page=${page.totlePage }">末页</a>&nbsp;
				<select id="selctpage" style="width: 40px">
					<c:if test="${page.totlePage>0}">
						<c:forEach begin="1" end="${page.totlePage }" varStatus="statu">
							<option value="${statu.index }">${statu.index }</option>
						</c:forEach>
					</c:if>
					
				</select>
				<a href="javascript:void(0);" onclick="gotoPage()">跳转</a>&nbsp;
			</div>
		</div>


	</div><!--end: forFlow -->
	</div><!--end: mainContent 主体内容容器-->

	<%@include file="/WEB-INF/jsp/main/blog/blogListSide.jsp" %>
	<div class="clear"></div>
	</div><!--end: main -->
	<div class="clear"></div>
	<div id="footer">
		Copyright ©2018 chnjan
	</div>
</div>
</body>
</html>