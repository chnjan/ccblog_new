/**
 * 
 */
package com.chnjan.ccblog.pub.cache;

/**
 * @author chenjian
 * @date 2018年7月24日
 * 当前登录用户的缓存信息
 */
public interface CurrentUserCache {

	/**
	 * @param key 键值
	 * @return Object 返回用户信息对象
	 * 获取登录用户信息缓存
	 * */
	Object getCurrentUser(Object key);
	
	/**
	 * @param key 键值
	 * @param value 要缓存的对象
	 * 添加缓存
	 * */
	void putCurrentUser(Object key, Object value);
	
	/**
	 * @param key 要移除的缓存对象key值
	 * 移除缓存
	 * */
	void removeCurrentUser(Object key);
}
