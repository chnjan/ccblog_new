/**
 * 
 */
package com.chnjan.ccblog.main.domain;

import java.util.Date;

/**
 * @author chenjian
 * @date 2018年10月28日
 * 
 * blog评论实体
 */
public class BlogComment {
	
	/**
	 * 评论id
	 * */
	private String commentId;
	
	/**
	 * 父评论id
	 * */
	private String supperCommentId;
	
	/**
	 * 被评论blog的id
	 * */
	private String blogId;
	
	/**
	 * 评论人的url
	 * */
	private String userUrl;
	
	/**
	 * 用户昵称
	 * */
	private String nickName;
	
	/**
	 * 评论创建时间
	 * */
	private Date createtime;
	
	/**
	 * 评论内容
	 * */
	private String content;
	
	/**
	 * 评论是否显示
	 * */
	private String isdisplay;
	
	/**
	 * 评论级别，父评论是0，其他加1
	 * */
	private int level;
	
	/**
	 * 支持数
	 * */
	private int supportcount;
	
	/**
	 * 反对数
	 * */
	private int againstcount;

	/**
	 * @return the commentId
	 */
	public String getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the supperCommentId
	 */
	public String getSupperCommentId() {
		return supperCommentId;
	}

	/**
	 * @param supperCommentId the supperCommentId to set
	 */
	public void setSupperCommentId(String supperCommentId) {
		this.supperCommentId = supperCommentId;
	}

	/**
	 * @return the blogId
	 */
	public String getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId the blogId to set
	 */
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	/**
	 * @return the userUrl
	 */
	public String getUserUrl() {
		return userUrl;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @param userUrl the userUrl to set
	 */
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	/**
	 * @return the createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the isdisplay
	 */
	public String getIsdisplay() {
		return isdisplay;
	}

	/**
	 * @param isdisplay the isdisplay to set
	 */
	public void setIsdisplay(String isdisplay) {
		this.isdisplay = isdisplay;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the supportcount
	 */
	public int getSupportcount() {
		return supportcount;
	}

	/**
	 * @param supportcount the supportcount to set
	 */
	public void setSupportcount(int supportcount) {
		this.supportcount = supportcount;
	}

	/**
	 * @return the againstcount
	 */
	public int getAgainstcount() {
		return againstcount;
	}

	/**
	 * @param againstcount the againstcount to set
	 */
	public void setAgainstcount(int againstcount) {
		this.againstcount = againstcount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BlogComment [commentId=" + commentId + ", supperCommentId=" + supperCommentId + ", blogId=" + blogId
				+ ", userUrl=" + userUrl + ", nickName=" + nickName + ", createtime=" + createtime + ", content="
				+ content + ", isdisplay=" + isdisplay + ", level=" + level + ", supportcount=" + supportcount
				+ ", againstcount=" + againstcount + "]";
	}

}
