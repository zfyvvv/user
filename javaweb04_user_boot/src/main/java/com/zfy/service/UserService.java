package com.zfy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zfy.pojo.User;

@Service
public interface UserService {
	
	int addUser(User user);
	int removeUser(User user);
	int updUser(User user);
	List<User> showUser();
	User checkLogin(User user);
	User selByname(User user);

}
