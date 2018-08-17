<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String bathPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>edit blog</title>
	<link href="<%=path %>/css/auth/auth.css" type="text/css" rel="stylesheet"/>
	<link href="<%=path %>/css/blog/blog-common.css" type="text/css" rel="stylesheet"/>
	<link href="<%=path %>/css/blog/bundle-SimpleMemory.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/uedit/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/uedit/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/uedit/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/jquery/jquery-3.1.0.min.js"></script>
	<style type="text/css">
	.divtitle{font-size: 16px; margin-bottom: 20px;height: 30px;}
	.labletitle{margin-left: 10px;}
	#title{width: 450px;}
	.input{height: 25px;}
	.labletype{margin-left: 40px;width: 50px;}
	.bottonsubmit{width: 50px;float:right;margin-top: 8px;margin-right: 180px;}
	</style>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/main/auth/loginInfo.jsp"></jsp:include>
	<div id="home">
	<jsp:include page="/WEB-INF/jsp/main/blog/blogListHead.jsp"></jsp:include>
	<div id="main" style="height: 920px;">
		<div id="mainContent" style="margin-left: 0em;">
			<div class="forFlow" style="margin-left: 0em;">
				<form id="savaBlogForm" name="savaBlogForm" method="post">
					<div class="divtitle">
						<label class="labletitle">标题：</label>
						<input id="title" name="title" class="input" type="text">
						<label class="labletype">分类：</label>
						<select id="type" name="typeid" class="input">
							<c:forEach var="blogType" items="${userTypeInfo}">
								<option value="${blogType.typeId}">${blogType.typeName}</option>
							</c:forEach>
						</select>
						<input class="input labletype" id="saveblog" type="button" value="发表" onclick="savablog()"/>
						<input id="content" name="content" type="hidden"/>
						<input id="blogId" name="blogId" value="${editBlog.blogId}" type="hidden"/>
					</div>
				</form>
				<div>
				    <script id="editor" type="text/plain" style="width:948px;height:800px;"></script>
					<input class="input bottonsubmit" type="button" value="发表" onclick="savablog()"/>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor',{
    	toolbars: [
            ['fullscreen', 'insertcode', 'undo', 'redo', 'bold', 'link', 'emotion',
             'simpleupload']],
		autoHeightEnabled: true,		//高度可变
		autoFloatEnabled: true,			//自动浮动
		initialFrameWidth: '948',
		initialFrameHeight: '800',	//初始化高度
		elementPathEnabled: false	//不显示元素路径
		});
    //编辑blog时设置内容
    //ue.execCommand('insertHtml', 'hhhhh');//${editBlog.content}//setContent("${editBlog.content}");
    
    function savablog() {
    	var content = UE.getEditor('editor').getContent();
    	document.getElementById("content").value = content;
		var form = document.getElementById("savaBlogForm");
		form.action = "<%=path%>/user/blog/save";
		form.submit();
	}
    
    function seteditblog() {
    	//设置内容
    	ue.setContent(eidtcontent,false);
	}
    var eidtcontent = '${editBlog.content}';
    //编辑时设置内容
    $(document).ready(function(){
    	var title = '${editBlog.title}';
    	if(title!='')
   		{
    		//设置标题
	    	$("#title").val(title);
   		}
    	//设置类型
    	var typeid = '${editBlog.typeid}';
    	if(typeid!='')
   		{
	    	$("#type").val(typeid);
   		}
    	//500毫秒后设置内容，因为ue这段时间还未加载好
    	
    	if(eidtcontent!='')
   		{
	    	setTimeout(seteditblog,500);
   		}
    });
	</script>
</body>
</html>