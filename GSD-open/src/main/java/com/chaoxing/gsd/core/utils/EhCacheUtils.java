package com.chaoxing.gsd.core.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * ehcache工具
 * @author winsl
 *
 */
public class EhCacheUtils {


	private final static CacheManager
		cacheManager =   CacheManager.create(EhCacheUtils.class.getClassLoader().getResourceAsStream("ehcache.xml"));

	/**
	 * 缓存名称
	 */
	public static String CACHE_NAME="SYS_CACHE_NAME";

	/**
	 * 采用默认策略保存的缓存
	 * @param key
	 * @param value
	 */
	public static void put(String key,Object value){
		Cache cache = cacheManager.getCache(CACHE_NAME);
		Element element = new Element(key, value);
		cache.put(element);
	}
	
	/**
	 * 添加缓存并指定过期时间
	 * @param key
	 * @param value
	 * @param time 秒
	 */
	public static void put(String key, Object value, int time){
		Cache cache = cacheManager.getCache(CACHE_NAME);
		Element element = new Element(key, value);
		element.setTimeToLive(time);
		cache.put(element);
	}


	/**
	 * 取缓存值
	 * @param key
	 * @return
	 */
	public static Object get(String key){
		Cache cache = cacheManager.getCache(CACHE_NAME);
		Element element =cache.get(key);
		if(element!=null){
			return element.getObjectValue();
		}
		return null;
	}
}
