package com.jygj.admin.dao;

import java.util.List;

import com.jygj.admin.dao.entity.UserEntity;

public interface UserDao {

	/**
	 * 
	 * @return
	 */
	List<UserEntity> queryAll();

}
