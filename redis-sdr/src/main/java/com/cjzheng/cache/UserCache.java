package com.cjzheng.cache;

import com.cjzheng.pojo.User;

/**
 * 
 * @Description: TODO
 * @author: zhengchaojie
 * @date 2017��3��6�� ����9:26:54
 *
 */
public interface UserCache {
	
	public void put(User user);

	public void delete(User user);

	public User get(User user);
}
