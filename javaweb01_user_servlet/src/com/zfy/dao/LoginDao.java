package com.zfy.dao;

import java.util.List;

import com.zfy.pojo.User;

public interface LoginDao {
	//check
	User checkLoginDao(String uname,String pwd);
	//����uid��ȡ����
	User checkUidDao(String uid);
	//����
	int updUser(String uid,String uname,String pwd);
	//ɾ
	int delUser(String uid);
	//add
	int addUser(String uid, String uname, String pwd);
	//sel all
	List<User> selAll();
	//sel one by name
	User selUser(String uname);
}
