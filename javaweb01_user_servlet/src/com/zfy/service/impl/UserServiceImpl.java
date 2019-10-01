package com.zfy.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.zfy.dao.LoginDao;
import com.zfy.dao.impl.LoginDaoImpl;
import com.zfy.pojo.User;
import com.zfy.service.UserService;

/**
 * 1.打印放到service层业务；
 * @author DELL
 *
 */
public class UserServiceImpl implements UserService{
	//声明日志对象；
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	
	//创建DAO层过度对象
	LoginDao loginDaoImpl=new LoginDaoImpl();
	//效验用户登录信息
	
	@Override
	public User checkLoginService(String name, String pwd) {
		//打印日志信息；
		logger.debug(name+"发起登录请求！");
		User u=loginDaoImpl.checkLoginDao(name, pwd);
		if(u!=null) {
			logger.debug(name+"登录成功！");
		}else {
			logger.debug(name+"登录失败！");
		}
		return u;
	}
	
	//效验用户cookie信息
	@Override
	public User checkUidService(String uid) {
		// TODO Auto-generated method stub
		return loginDaoImpl.checkUidDao(uid);
	}

	@Override
	public int updUser(String uid,String uname,String pwd) {
		// TODO Auto-generated method stub
		return loginDaoImpl.updUser(uid,uname,pwd);
	}

	@Override
	public int delUser(String uid) {
		// TODO Auto-generated method stub
		return loginDaoImpl.delUser(uid);
	}

	@Override
	public int addUser(String uid, String uname, String pwd) {
		// TODO Auto-generated method stub
		return loginDaoImpl.addUser(uid,uname,pwd);
	}

	@Override
	public List<User> selAllUser() {
		// TODO Auto-generated method stub
		return loginDaoImpl.selAll();
	}

	@Override
	public User selUser(String uname) {
		// TODO Auto-generated method stub
		return loginDaoImpl.selUser(uname);
	}

}
