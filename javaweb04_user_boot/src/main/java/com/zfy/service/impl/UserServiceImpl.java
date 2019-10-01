package com.zfy.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfy.mapper.UserMapper;
import com.zfy.pojo.User;
import com.zfy.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	Logger logger=Logger.getLogger(UserServiceImpl.class);

	@Autowired
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
		logger.debug(user.getUname()+"发起登录请求！");
		User u=userMapper.checkLogin(user);
		if(u!=null) {
			logger.debug(user.getUname()+"登录成功！");
		}else {
			logger.debug(user.getUname()+"登录失败！");
		}
		return u;
	}

	@Override
	public User selByname(User user) {
		// TODO Auto-generated method stub
		return userMapper.selByName(user);
	}

}
