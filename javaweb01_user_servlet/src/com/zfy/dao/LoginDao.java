package com.zfy.dao;

import java.util.List;

import com.zfy.pojo.User;

public interface LoginDao {
	//check
	User checkLoginDao(String uname,String pwd);
	//根据uid获取对象；
	User checkUidDao(String uid);
	//更改
	int updUser(String uid,String uname,String pwd);
	//删
	int delUser(String uid);
	//add
	int addUser(String uid, String uname, String pwd);
	//sel all
	List<User> selAll();
	//sel one by name
	User selUser(String uname);
}
