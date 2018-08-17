<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="sideBar">
	<div id="sideBarMain">
			
		<!--done-->
		<div class="newsItem">
			<h3 class="catListTitle">公告</h3>
			<div id="blog-news">
				<div id="profile_block">昵称：
					<a href="javascript:void(0)">${blogUserInfo.nickName}</a><br>
					博龄：<a title="入坑时间：<fmt:formatDate value="${blogUserInfo.createTime}" pattern="yyyy-MM-dd"/>" href="javascript:void(0)">11个月</a><br>
					<!-- 粉丝：<a href="http://home.cnblogs.com/u/skyfsm/followers/">144</a><br>
					关注：<a href="http://home.cnblogs.com/u/skyfsm/followees/">20</a>
					<div id="p_b_follow"><a onclick="follow('0615e00a-49d6-e611-845c-ac853d9f53ac')" href="javascript:void(0);">+加关注</a></div> -->
				</div>
			</div>
			<!-- <script type="text/javascript">loadBlogNews();</script> -->
		</div>

		<!-- <div id="blog-calendar">
		<table title="Calendar" class="Cal" id="blogCalendar" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<td colspan="7">
						<table class="CalTitle" cellspacing="0">
							<tbody>
								<tr>
									<td class="CalNextPrev">
										<a onclick="loadBlogCalendar('2017/11/01');return false;" href="javascript:void(0);">&lt;</a>
									</td>
									<td align="center">2017年12月</td>
									<td align="right" class="CalNextPrev"><a onclick="loadBlogCalendar('2018/01/01');return false;" href="javascript:void(0);">&gt;</a></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<th align="center" class="CalDayHeader" abbr="日" scope="col">日</th>
					<th align="center" class="CalDayHeader" abbr="一" scope="col">一</th>
					<th align="center" class="CalDayHeader" abbr="二" scope="col">二</th>
					<th align="center" class="CalDayHeader" abbr="三" scope="col">三</th>
					<th align="center" class="CalDayHeader" abbr="四" scope="col">四</th>
					<th align="center" class="CalDayHeader" abbr="五" scope="col">五</th>
					<th align="center" class="CalDayHeader" abbr="六" scope="col">六</th>
					</tr>
				<tr>
				<td align="center" class="CalOtherMonthDay">26</td>
				<td align="center" class="CalOtherMonthDay">27</td><td align="center" class="CalOtherMonthDay">28</td><td align="center" class="CalOtherMonthDay">29</td><td align="center" class="CalOtherMonthDay">30</td><td align="center">1</td><td align="center" class="CalWeekendDay">2</td></tr><tr><td align="center" class="CalWeekendDay">3</td><td align="center">4</td><td align="center">5</td><td align="center">6</td><td align="center">7</td><td align="center">8</td><td align="center" class="CalWeekendDay">9</td></tr><tr><td align="center" class="CalWeekendDay">10</td><td align="center">11</td><td align="center"><a href="http://www.cnblogs.com/skyfsm/archive/2017/12/12.html"><u>12</u></a></td><td align="center">13</td><td align="center">14</td><td align="center">15</td><td align="center" class="CalWeekendDay">16</td></tr><tr><td align="center" class="CalWeekendDay"><a href="http://www.cnblogs.com/skyfsm/archive/2017/12/17.html"><u>17</u></a></td><td align="center">18</td><td align="center">19</td><td align="center">20</td><td align="center">21</td><td align="center">22</td><td align="center" class="CalTodayDay"><a href="http://www.cnblogs.com/skyfsm/archive/2017/12/23.html"><u>23</u></a></td></tr><tr><td align="center" class="CalWeekendDay">24</td><td align="center">25</td><td align="center">26</td><td align="center">27</td><td align="center">28</td><td align="center">29</td><td align="center" class="CalWeekendDay">30</td></tr><tr><td align="center" class="CalWeekendDay">31</td><td align="center" class="CalOtherMonthDay">1</td><td align="center" class="CalOtherMonthDay">2</td><td align="center" class="CalOtherMonthDay">3</td><td align="center" class="CalOtherMonthDay">4</td><td align="center" class="CalOtherMonthDay">5</td><td align="center" class="CalOtherMonthDay">6</td></tr>
			</tbody>
		</table>
		</div> -->
<!-- <script type="text/javascript">loadBlogDefaultCalendar();</script> -->
			
		<div id="leftcontentcontainer">
		<div id="blog-sidecolumn">
		<!-- <div class="sidebar-block" id="sidebar_search">
			<div class="mySearch" id="sidebar_search">
				<h3 class="catListTitle">搜索</h3>
				<div id="sidebar_search_box">
					<div class="div_my_zzk" id="widget_my_zzk"><input class="input_my_zzk" id="q" onkeydown="return zzk_go_enter(event);" type="text">&nbsp;<input class="btn_my_zzk" id="btnZzk" onclick="zzk_go()" type="button" value="找找看"></div>
					<div class="div_my_zzk" id="widget_my_google"><input name="google_q" class="input_my_zzk" id="google_q" onkeydown="return google_go_enter(event)" type="text">&nbsp;<input class="btn_my_zzk" onclick="google_go()" type="button" value="谷歌搜索"></div>
				</div>
			</div>
		</div> -->
		
		<div class="sidebar-block" id="sidebar_toptags"></div>
		<div id="sidebar_categories">
			<div class="catListPostCategory sidebar-block" id="sidebar_postcategory">
				<h3 class="catListTitle">随笔分类<span style="font-size: 11px; font-weight: normal;">(${blogUserInfo.blogCount})</span></h3>
				<ul>
					<c:forEach var="blogType" items="${userTypeInfo}">
						<li><a href="<%=path %>/blog/${blogType.userUrl}/${blogType.typeId}">${blogType.typeName}(${blogType.blogCount})</a> </li>
					</c:forEach>
				</ul>
			</div>

		</div>
		<!-- <div class="sidebar-block" id="sidebar_scorerank">
			<div class="catListBlogRank">
			<h3 class="catListTitle">积分与排名</h3>
			<ul>
				<li class="liScore">
					积分 -	73522
				</li>
				<li class="liRank">
					排名 -	4371
				</li>
			</ul>
			</div>
		</div> -->
		<div class="sidebar-block" id="sidebar_recentcomments">
			<div id="recent_comments_wrap">
				<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" 
						width="190" height="80" id="honehoneclock" align="center">
					<param name="allowScriptAccess" value="always" />
					<param name="movie" value="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_wh.swf" />
					<param name="quality" value="high" />
					<param name="bgcolor" value="#ffffff" />
					<param name="wmode" value="transparent" />
					<embed wmode="transparent" src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_wh.swf" 
							quality="high" bgcolor="#ffffff" width="200" height="90" name="honehoneclock" align="center" 
							type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
				</object>
			</div>
		</div>
		<!-- 
		<div class="sidebar-block" id="sidebar_topviewedposts">
			<div id="topview_posts_wrap">
				<div class="catListView">
					<h3 class="catListTitle">阅读排行榜</h3>
					<div id="TopViewPostsBlock"><ul><li><a href="http://www.cnblogs.com/skyfsm/p/6806246.html">1. 基于深度学习的目标检测技术演进：R-CNN、Fast R-CNN、Faster R-CNN(10532)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/6672167.html">2. 两年波折路（考研、工作、考研）(7765)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/7411961.html">3. OpenCV探索之路（二十四）图像拼接和图像融合技术(7256)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/6287787.html">4. Linux编程之UDP SOCKET全攻略(5882)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/6897313.html">5. OpenCV探索之路（十四）：绘制点、直线、几何图形(4001)</a></li></ul></div>
				</div>
			</div>
		</div>
		<div class="sidebar-block" id="sidebar_topcommentedposts">
			<div id="topfeedback_posts_wrap">
				<div class="catListFeedback">
					<h3 class="catListTitle">评论排行榜</h3>
					<div id="TopFeedbackPostsBlock"><ul><li><a href="http://www.cnblogs.com/skyfsm/p/6672167.html">1. 两年波折路（考研、工作、考研）(84)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/7411961.html">2. OpenCV探索之路（二十四）图像拼接和图像融合技术(29)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/7324346.html">3. OpenCV探索之路（二十二）：制作一个类“全能扫描王”的简易扫描软件(13)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/7253208.html">4. Opencv探索之路（二十）：制作一个简易手动图像配准工具(12)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/6872648.html">5. OpenCV探索之路（二）：图像处理的基础知识点串烧(11)</a></li></ul></div>
				</div>
			</div>
		</div>
		<div class="sidebar-block" id="sidebar_topdiggedposts">
			<div id="topdigg_posts_wrap">
				<div class="catListView">
					<h3 class="catListTitle">推荐排行榜</h3>
					<div id="TopDiggPostsBlock"><ul><li><a href="http://www.cnblogs.com/skyfsm/p/6672167.html">1. 两年波折路（考研、工作、考研）(71)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/6806246.html">2. 基于深度学习的目标检测技术演进：R-CNN、Fast R-CNN、Faster R-CNN(12)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/8088158.html">3. 读研以来的一些感想：名校好在哪里？(9)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/7868877.html">4. OpenCV探索之路（二十七）：皮肤检测技术(7)</a></li><li><a href="http://www.cnblogs.com/skyfsm/p/6790245.html">5. 卷积神经网络CNN总结(7)</a></li></ul></div>
				</div>
			</div>
		</div> -->
		</div>
		<!-- <script type="text/javascript">loadBlogSideColumn();</script> -->
		</div>
	</div><!--end: sideBarMain -->
</div><!--end: sideBar 侧边栏容器 -->