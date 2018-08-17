/**
 * 
 */
package com.chnjan.ccblog.main.domain;

import java.util.Date;

/**
 * blog用户信息实体
 * @author chenjian
 * @date 2018年6月5日
 */
public class BlogUser {
	
	/**
	 * 用户id
	 * */
	private String userId;
	
	/**
	 * 呢称
	 * */
	private String nickName;
	
	/**
	 * 用户url
	 * */
	private String userUrl;
	
	/**
	 * 个性签名
	 * */
	private String saySome;
	
	/**
	 * 发表的blog数量
	 * */
	private Integer blogCount;
	
	/**
	 * 发表的评论数量
	 * */
	private Integer commentCount;
	
	/**
	 * 创建时间
	 * */
	private Date createTime;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @return the saySome
	 */
	public String getSaySome() {
		return saySome;
	}

	/**
	 * @param saySome the saySome to set
	 */
	public void setSaySome(String saySome) {
		this.saySome = saySome;
	}

	/**
	 * @return the blogCount
	 */
	public Integer getBlogCount() {
		return blogCount;
	}

	/**
	 * @param blogCount the blogCount to set
	 */
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BlogUser [userId=" + userId + ", nickName=" + nickName + ", userUrl=" + userUrl + ", saySome=" + saySome
				+ ", blogCount=" + blogCount + ", commentCount=" + commentCount + ", createTime=" + createTime + "]";
	}

}
