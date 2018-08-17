/**
 * 
 */
package com.chnjan.ccblog.main.domain;

/**
 * @author chenjian
 * @date 2018年6月6日
 * blog类别实体
 */
public class BlogType {
	
	/**
	 * 类别id
	 * */
	private String typeId;
	
	/**
	 * 类别名字
	 * */
	private String typeName;
	
	/**
	 * 所属用户的url
	 * */
	private String userUrl;
	
	/**
	 * 该类别下blog数量
	 * */
	private String blogCount;

	/**
	 * @return the typeId
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	 * @return the blogCount
	 */
	public String getBlogCount() {
		return blogCount;
	}

	/**
	 * @param blogCount the blogCount to set
	 */
	public void setBlogCount(String blogCount) {
		this.blogCount = blogCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BlogType [typeId=" + typeId + ", typeName=" + typeName + ", userUrl=" + userUrl + ", blogCount="
				+ blogCount + "]";
	}

	
	
}
