package com.wuya.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuya.dao.UserMapper;
import com.wuya.model.User;
import com.wuya.servcie.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User findUserById(Integer id) {
		if(id != null){
			return userMapper.selectByPrimaryKey(id);
		}else{
			return null;
		}
	}

}
