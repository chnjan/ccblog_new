/**
 * 
 */
package com.chnjan.ccblog.pub.cache.ehcache;

import com.chnjan.ccblog.pub.cache.CurrentUserCache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * @author chenjian
 * @date 2018年7月24日
 * 
 * 使用ehcache实现登录用户信息的缓存
 */
public class EhcacheCurrentUserImpl implements CurrentUserCache{
	
	private Cache userCache;

	@Override
	public Object getCurrentUser(Object key) {
		Element element = userCache.get(key);
		if (element == null) {
			return null;
		}
		
		return element.getObjectValue();
	}

	@Override
	public void putCurrentUser(Object key, Object value) {
		userCache.put(new Element(key, value));
	}

	@Override
	public void removeCurrentUser(Object key) {
		userCache.remove(key);
		
	}

	/**
	 * @return the userCache
	 */
	public Cache getUserCache() {
		return userCache;
	}

	/**
	 * @param userCache the userCache to set
	 */
	public void setUserCache(Cache userCache) {
		this.userCache = userCache;
	}

}
