/**
 * 
 */
package com.chnjan.ccblog.main.domain;

import java.util.Date;

/**
 * 2017-12-14
 * @author chenjian
 * 博客信息实体类
 */
public class Blog {
	/**
	 * id
	 * */
	private String blogId;
	
	/**
	 * 类型
	 * */
	private String typeid;
	
	/**
	 * 作者url
	 * */
	private String userUrl;
	
	/**
	 * 标题
	 * */
	private String title;
	
	/**
	 * 内容
	 * */
	private String content;
	
	/**
	 * 内容摘要
	 * */
	private String blogAbstract;
	
	/**
	 * 创建时间
	 * */
	private Date createTime;
	
	/**
	 * 最近更新时间
	 * */
	private Date lastUpdateTime;
	
	/**
	 * 阅读量
	 * */
	private Integer readCount;
	
	/**
	 * 评论量
	 * */
	private Integer commentCount;
	
	/**
	 * 推荐量
	 * */
	private Integer upupCount;

	
	
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
	 * @return the typeid
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * @return the userUrl
	 */
	public String getUserUrl() {
		return userUrl;
	}

	/**
	 * @param userUrl the userUrl to set
	 */
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the blogAbstract
	 */
	public String getBlogAbstract() {
		return blogAbstract;
	}

	/**
	 * @param blogAbstract the blogAbstract to set
	 */
	public void setBlogAbstract(String blogAbstract) {
		this.blogAbstract = blogAbstract;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the lastUpdateTime
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime the lastUpdateTime to set
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return the readCount
	 */
	public Integer getReadCount() {
		return readCount;
	}

	/**
	 * @param readCount the readCount to set
	 */
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	
	/**
	 * @return the commentCount
	 */
	public Integer getCommentCount() {
		return commentCount;
	}

	/**
	 * @param commentCount the commentCount to set
	 */
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * @return the upupCount
	 */
	public Integer getUpupCount() {
		return upupCount;
	}

	/**
	 * @param upupCount the upupCount to set
	 */
	public void setUpupCount(Integer upupCount) {
		this.upupCount = upupCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", typeid=" + typeid + ", userUrl=" + userUrl + ", title=" + title
				+ ", content=" + content + ", blogAbstract=" + blogAbstract + ", createTime=" + createTime
				+ ", lastUpdateTime=" + lastUpdateTime + ", readCount=" + readCount + ", commentCount=" + commentCount
				+ ", upupCount=" + upupCount + "]";
	}
	
}
