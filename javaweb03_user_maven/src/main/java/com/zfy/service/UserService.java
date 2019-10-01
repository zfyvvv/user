package com.zfy.service;

import java.util.List;
import com.zfy.pojo.User;

public interface UserService {
	
	int addUser(User user);
	int removeUser(User user);
	int updUser(User user);
	List<User> showUser();
	User checkLogin(User user);
	User selByname(User user);

}
