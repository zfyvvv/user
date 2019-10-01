package com.zfy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.zfy.pojo.User;
public interface UserMapper {
	//����
	int addUser(User user);
	//ɾ��
	int delUser(User user);
	//��
	int updUser(User user);
	//��
	List<User> selAll();
	//��¼��֤
	User checkLogin(User user);
	
	User selByName(User user);
}
