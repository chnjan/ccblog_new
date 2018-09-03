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
	<title>${userBlog.title}</title>
	<link href="<%=path %>/css/auth/auth.css" type="text/css" rel="stylesheet"/>
	<link href="<%=path %>/css/blog/blog-common.css" type="text/css" rel="stylesheet"/>
	<link href="<%=path %>/css/blog/bundle-SimpleMemory.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/main/auth/loginInfo.jsp"></jsp:include>
<div id="home">
	<%-- <%@include file="/WEB-INF/jsp/main/blog/blogListHead.jsp" %> --%>
	<jsp:include page="/WEB-INF/jsp/main/blog/blogListHead.jsp"></jsp:include>

	<div id="main">
	<div id="mainContent">
	<div class="forFlow">
		
	<div id="post_detail">
	<!--done-->
		<div id="topics">
			<div class="post">
				<h1 class="postTitle">
					<a class="postTitle2" id="cb_post_title_url" href="javascript:void(0);">${userBlog.title}</a>
				</h1>
				<div class="clear"></div>
				<div class="postBody">
					<div class="blogpost-body cnblogs-markdown" id="cnblogs_post_body">
						${userBlog.content}
					</div>
					<div id="MySignature"></div>
					<div class="clear"></div>
					<div id="blog_post_info_block">
						<div id="BlogPostCategory">分类: <a href="<%=path %>/blog/${blogType.userUrl}/${blogType.typeId}">${blogType.typeName}</a></div>
						<div id="EntryTag"></div>
						<!-- <div id="blog_post_info">
							<div id="green_channel">
							    <a id="green_channel_digg" onclick="DiggIt(8088158,cb_blogId,1);green_channel_success(this,'谢谢推荐！');" href="javascript:void(0);">好文要顶</a>
							    <a id="green_channel_follow" onclick="follow('0615e00a-49d6-e611-845c-ac853d9f53ac');" href="javascript:void(0);">关注我</a>
							    <a id="green_channel_favorite" onclick="AddToWz(cb_entryId);return false;" href="javascript:void(0);">收藏该文</a>
							    <a title="分享至新浪微博" id="green_channel_weibo" onclick="ShareToTsina()" href="javascript:void(0);"><img alt="" src="//common.cnblogs.com/images/icon_weibo_24.png"></a>
							    <a title="分享至微信" id="green_channel_wechat" onclick="shareOnWechat()" href="javascript:void(0);"><img alt="" src="//common.cnblogs.com/images/wechat.png"></a>
							</div>
							<div id="author_profile">
							    <div class="author_profile_info" id="author_profile_info">
							        <a href="http://home.cnblogs.com/u/skyfsm/" target="_blank"><img class="author_avatar" alt="" src="//pic.cnblogs.com/face/1093303/20170109193150.png"></a>
							        <div class="author_profile_info" id="author_profile_detail">
							            <a href="http://home.cnblogs.com/u/skyfsm/">Madcola</a><br>
							            <a href="http://home.cnblogs.com/u/skyfsm/followees">关注 - 20</a><br>
							            <a href="http://home.cnblogs.com/u/skyfsm/followers">粉丝 - 148</a>
							        </div>
							    </div>
							    <div class="clear"></div>
							    <div id="author_profile_honor"></div>
							    <div id="author_profile_follow">
							        <a onclick="follow('0615e00a-49d6-e611-845c-ac853d9f53ac');return false;" href="javascript:void(0);">+加关注</a>
							    </div>
							</div>
							<div id="div_digg">
							    <div class="diggit" onclick="votePost(8088158,'Digg')">
							        <span class="diggnum" id="digg_count">10</span>
							    </div>
							    <div class="buryit" onclick="votePost(8088158,'Bury')">
							        <span class="burynum" id="bury_count">2</span>
							    </div>
							    <div class="clear"></div>
							    <div class="diggword" id="digg_tips">
							    </div>
							</div>
						</div> -->
						<div class="clear"></div>
						<!-- <div id="post_next_prev">
							<a class="p_n_p_prefix" href="http://www.cnblogs.com/skyfsm/p/8051705.html">« </a> 上一篇：<a title="发布于2017-12-17 12:10" href="http://www.cnblogs.com/skyfsm/p/8051705.html">【Keras】从两个实际任务掌握图像分类</a><br>
							<a class="p_n_p_prefix" href="http://www.cnblogs.com/skyfsm/p/8097397.html">» </a> 下一篇：<a title="发布于2017-12-24 09:49" href="http://www.cnblogs.com/skyfsm/p/8097397.html">OpenCV探索之路（二十八）：Bag of Features(BoF)图像分类实践</a><br>
						</div> -->
					</div>
		
				</div>
				<div class="postDesc">posted @ <span id="post-date"><fmt:formatDate value="${userBlog.createTime}" pattern="yyyy-MM-dd HH:mm"/></span> 
					<a href="<%=path %>/blog/${blogUserInfo.userUrl}">${blogUserInfo.nickName}</a> 阅读(<span id="post_view_count">${userBlog.readCount}</span>) 评论(<span id="post_comment_count">${userBlog.commentCount}</span>)  
					<a href="<%=path %>/user/blog/edit?blogid=${userBlog.blogId}" rel="nofollow">编辑</a> 
					<a onclick="AddToWz(8088158);return false;" href="#">收藏</a>
				</div>
			</div>
			<!-- <script src="//common.cnblogs.com/highlight/9.1.0/highlight.min.js?id=20160127"></script>
			<script>markdown_highlight();</script>
			<script type="text/javascript">var allowComments=true,cb_blogId=327280,cb_entryId=8088158,cb_blogApp=currentBlogApp,cb_blogUserGuid='0615e00a-49d6-e611-845c-ac853d9f53ac',cb_entryCreatedDate='2017/12/23 0:31:00';loadViewCount(cb_entryId);var cb_postType=1;</script> -->
			
		</div>
	<!--end: topics 文章、评论容器-->
	</div>
	<a name="!comments"></a>
	<div id="blog-comments-placeholder">
		<div id="comments_pager_top"></div><br>
		<div class="feedback_area_title">评论列表</div>
		<div class="feedbackNoItems"></div>	

		<div class="feedbackItem">
			<div class="feedbackListSubtitle">
				<div class="feedbackManage">
					&nbsp;&nbsp;<span class="comment_actions"></span>
				</div>
				<a class="layer" href="#3872094">#1楼</a><a name="3872094" id="comment_anchor_3872094"></a>  <span class="comment_date">2017-12-23 08:16</span> <a id="a_comment_author_3872094" target="_blank">xuanbgg</a> <a title="发送站内短消息" class="sendMsg2This">&nbsp;</a>
			</div>
			<div class="feedbackCon">
				<div class="blog_comment_body" id="comment_body_3872094">点赞</div><div class="comment_vote"><a class="comment_digg" onclick="return voteComment(3872094,'Digg',this)" href="javascript:void(0);">支持(0)</a><a class="comment_bury" onclick="return voteComment(3872094,'Bury',this)" href="javascript:void(0);">反对(0)</a></div>
			</div>
		</div>
	
		<div class="feedbackItem">
			<div class="feedbackListSubtitle">
				<div class="feedbackManage">
					&nbsp;&nbsp;<span class="comment_actions"></span>
				</div>
				<a class="layer" href="#3872110">#2楼</a><a name="3872110" id="comment_anchor_3872110"></a>  <span class="comment_date">2017-12-23 09:04</span> <a id="a_comment_author_3872110" target="_blank">阿辉</a> <a title="发送站内短消息" class="sendMsg2This" >&nbsp;</a>
			</div>
			<div class="feedbackCon">
				<div class="blog_comment_body" id="comment_body_3872110">氛围，环境</div><div class="comment_vote"><a class="comment_digg" onclick="return voteComment(3872110,'Digg',this)" href="javascript:void(0);">支持(0)</a><a class="comment_bury" onclick="return voteComment(3872110,'Bury',this)" href="javascript:void(0);">反对(0)</a></div>
			</div>
		</div>
	
	
		<div id="comments_pager_bottom"></div>
	</div>
	
	<!-- <script type="text/javascript">var commentManager = new blogCommentManager();commentManager.renderComments(0);</script> -->

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