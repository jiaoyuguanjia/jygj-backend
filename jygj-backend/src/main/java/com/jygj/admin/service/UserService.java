package com.jygj.admin.service;

import java.util.List;

import com.jygj.admin.pojo.User;

public interface UserService {

	/**
	 * 查询所有的用户信息列表
	 * 
	 * @return 返回用户信息列表
	 */
	List<User> queryAll();

}
