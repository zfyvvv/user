package com.zfy.service;

import java.util.List;

import com.zfy.pojo.User;

public interface UserService {
	//check£»
	User checkLoginService(String name,String pwd);
	//check cookie
	User checkUidService(String uid);
	//upd
	int updUser(String uid,String uname,String pwd);
	//delete
	int delUser(String uid);
	//add
	int addUser(String uid, String uname, String pwd);
	//sel all
	List<User> selAllUser();
	//sel one by name
	User selUser(String uname);

}
