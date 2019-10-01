package com.zfy.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.zfy.pojo.User;
import com.zfy.service.UserService;
import com.zfy.service.impl.UserServiceImpl;

/**
 * 
 * 1.��longin.jsp��¼��ȥ��
 * ��¼�ɹ���ֱ�ӵ���homeҳ��,homeҳ����������ɾ�Ĳ飻
 * ��ɾ�Ĳ��ֱ�ӵ���homeҳ�棬���к������
 * ��¼ʧ�ܣ��򷵻�login.jspҳ�棻
 * ���ｨ����һ��servlet�н���ʵ�֣�����������ͬ�ķ�����
 * 2.��־˵��
 * ��������һ����debug���𣬷��ؽ��ʹ��info����
 * 3.servlet�ض���·��˵����
 * ���·�����ӵ�ǰ�����·��������Դ��·����
 * 		���·�����servlet�ı����а���Ŀ¼��������ض�����Դ����ʧ�ܣ�
 * ����·��������ʹ�þ���·�� ����һ��/��ʾ��������Ŀ¼��
 * 		/��Ŀ������/��Դ·����
 * 4.servlet����ת����
 * 		/��ʾ��Ŀ��Ŀ¼��
 * 		req.getRequestDispatcher("/login.jsp").forward(req, resp);
 * @author DELL
 *
 */
@WebServlet("/login")
public class UserLogin extends HttpServlet {
	//������־����
	Logger logger=Logger.getLogger(UserLogin.class);
	
	//servic�����
	UserService us=new UserServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��������ǰ�����Ը��ݷ������иı䣻
		String oper=req.getParameter("oper");
		if("login".equals(oper)) {
			//���õ�¼������
			checkUserLogin(req, resp);
		}else if("sel".equals(oper)) {
			//���ò�ѯ�����û���Ϣ������
			selUser(req, resp);
			
		}else if("selall".equals(oper)) {
			//���ò�ѯ�����û���Ϣ������
			selAllUser(req, resp);
			
		}else if("add".equals(oper)) {
			//�����û���Ϣ������
			addUser(req, resp);
			
		}else if("del".equals(oper)) {
			//ɾ���û���Ϣ������
			delUser(req, resp);
			
		}else if("upd".equals(oper)) {
			//�����˳�������
			updUser(req, resp);
			
		}else {
			logger.debug("û���ҵ���Ӧ���Ĳ�������"+oper);
		}
		
	}
	//��
	private void updUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uid=req.getParameter("uid");
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		int index=us.updUser(uid,uname,pwd);
		if(index>0) {
			resp.sendRedirect("/user/main.jsp");
		}else {
			resp.sendRedirect("/user/error.jsp");
		}
	}
	//ɾ
	private void delUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String uid=req.getParameter("uid");
		int index=us.delUser(uid);
		if(index>0) {
			resp.sendRedirect("/user/main.jsp");
		}else {
			resp.sendRedirect("/user/error.jsp");
		}
	}
	//��
	private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String uid=req.getParameter("uid");
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		int index=us.addUser(uid,uname,pwd);
		if(index>0) {
			resp.sendRedirect("/user/main.jsp");
		}else {
			resp.sendRedirect("/user/error.jsp");
		}
	}
	//������
	private void selAllUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		List<User> list=us.selAllUser();
		req.setAttribute("list", list);
		if(list!=null) {
			req.getRequestDispatcher("/show.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/user/error.jsp");
		}
		
	}
	//��ѯһ��
	private void selUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=req.getParameter("uname");
		User user=us.selUser(uname);
		List<User> list=new ArrayList<User>();
		list.add(user);
		req.setAttribute("list", list);
		if(list!=null) {
			req.getRequestDispatcher("/show.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/user/error.jsp");
		}
	}

	//�����˳�����ʵ������
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡsession�����٣�
		HttpSession session=req.getSession();
		session.invalidate();
		//�ض��򵽵�¼ҳ�棻
		resp.sendRedirect("/user/login.jsp");
	}
	//�����¼����¼�ɹ�����mainҳ�棻
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//��req��õ����ݣ��Բ�������ʽת��ҵ��㣻
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		User u= us.checkLoginService(uname, pwd);
		
		if(u!=null) {
			//�ض���ǰ��ȡsession����
			HttpSession session=req.getSession();
			session.setAttribute("user", u);
			//�ض���;����ʹ�þ���·����
			resp.sendRedirect("/user/main.jsp");
			return;
		}else {
			//����ת��
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
	}
}
