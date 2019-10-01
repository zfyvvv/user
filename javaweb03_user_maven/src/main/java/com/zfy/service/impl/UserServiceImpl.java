package com.zfy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zfy.mapper.UserMapper;
import com.zfy.pojo.User;
import com.zfy.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	Logger logger=Logger.getLogger(UserServiceImpl.class);

	@Resource
	private UserMapper userMapper;
	
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}

	@Override
	public int removeUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.delUser(user);
	}

	@Override
	public int updUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updUser(user);
	}

	@Override
	public List<User> showUser() {
		// TODO Auto-generated method stub
		return userMapper.selAll();
	}

	@Override
	public User checkLogin(User user) {
		// TODO Auto-generated method stub
		logger.debug(user.getUname()+"·¢ÆðµÇÂ¼ÇëÇó£¡");
		User u=userMapper.checkLogin(user);
		if(u!=null) {
			logger.debug(user.getUname()+"µÇÂ¼³É¹¦£¡");
		}else {
			logger.debug(user.getUname()+"µÇÂ¼Ê§°Ü£¡");
		}
		return u;
	}

	@Override
	public User selByname(User user) {
		// TODO Auto-generated method stub
		return userMapper.selByName(user);
	}

}
