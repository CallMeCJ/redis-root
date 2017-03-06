package com.cjzheng.cache;

/**
 * 
 * @Description: TODO
 * @author: zhengchaojie
 * @date 2017年3月6日 上午9:26:54
 *
 */
public interface UserCache {
	String get(String key);

	String set(String key, String value);

	String hget(String hkey, String key);

	long hset(String hkey, String key, String value);

	long incr(String key);

	long decr(String key);

	long expire(String key, int second);

	long ttl(String key);

	long del(String key);

	long hdel(String hkey, String key);
}
