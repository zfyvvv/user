package com.zfy.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.zfy.dao.LoginDao;
import com.zfy.dao.impl.LoginDaoImpl;
import com.zfy.pojo.User;
import com.zfy.service.UserService;

/**
 * 1.��ӡ�ŵ�service��ҵ��
 * @author DELL
 *
 */
public class UserServiceImpl implements UserService{
	//������־����
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	
	//����DAO����ȶ���
	LoginDao loginDaoImpl=new LoginDaoImpl();
	//Ч���û���¼��Ϣ
	
	@Override
	public User checkLoginService(String name, String pwd) {
		//��ӡ��־��Ϣ��
		logger.debug(name+"�����¼����");
		User u=loginDaoImpl.checkLoginDao(name, pwd);
		if(u!=null) {
			logger.debug(name+"��¼�ɹ���");
		}else {
			logger.debug(name+"��¼ʧ�ܣ�");
		}
		return u;
	}
	
	//Ч���û�cookie��Ϣ
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
