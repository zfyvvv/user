package com.zfy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.zfy.pojo.User;
public interface UserMapper {
	//增；
	int addUser(User user);
	//删；
	int delUser(User user);
	//改
	int updUser(User user);
	//查
	List<User> selAll();
	//登录验证
	User checkLogin(User user);
	
	User selByName(User user);
}
