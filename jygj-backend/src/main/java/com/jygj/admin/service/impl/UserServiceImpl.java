package com.jygj.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jygj.admin.pojo.User;
import com.jygj.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> queryAll() {
		List<User> userList = new ArrayList<User>();
		for(UserEntity entity: (List<UserEntity>) userDao.queryAll()) {
			userList.add(new User(entity));
		}
		return userList;
	}*/

}
