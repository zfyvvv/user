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
 * 1.从longin.jsp登录进去；
 * 登录成功，直接到达home页面,home页面里面有增删改查；
 * 增删改查后，直接到达home页面，进行后操作；
 * 登录失败，则返回login.jsp页面；
 * 这里建议在一个servlet中进行实现，可以新增不同的方法；
 * 2.日志说明
 * 方法里面一般是debug级别，返回结果使用info级别；
 * 3.servlet重定向路径说明：
 * 相对路径：从当前请求的路径查找资源的路径；
 * 		相对路径如果servlet的别名中包含目录，会造成重定向资源查找失败；
 * 绝对路径：建议使用绝对路径 ；第一个/表示服务器根目录，
 * 		/项目虚拟名/资源路径；
 * 4.servlet请求转发；
 * 		/表示项目根目录，
 * 		req.getRequestDispatcher("/login.jsp").forward(req, resp);
 * @author DELL
 *
 */
@WebServlet("/login")
public class UserLogin extends HttpServlet {
	//声明日志对象；
	Logger logger=Logger.getLogger(UserLogin.class);
	
	//servic层对象，
	UserService us=new UserServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//处理请求前，可以根据方法进行改变；
		String oper=req.getParameter("oper");
		if("login".equals(oper)) {
			//调用登录方法；
			checkUserLogin(req, resp);
		}else if("sel".equals(oper)) {
			//调用查询个人用户信息方法；
			selUser(req, resp);
			
		}else if("selall".equals(oper)) {
			//调用查询所有用户信息方法；
			selAllUser(req, resp);
			
		}else if("add".equals(oper)) {
			//新增用户信息方法；
			addUser(req, resp);
			
		}else if("del".equals(oper)) {
			//删除用户信息方法；
			delUser(req, resp);
			
		}else if("upd".equals(oper)) {
			//调用退出方法；
			updUser(req, resp);
			
		}else {
			logger.debug("没有找到对应到的操作符："+oper);
		}
		
	}
	//改
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
	//删
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
	//增
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
	//查所有
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
	//查询一个
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

	//处理退出，待实现请求；
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session并销毁；
		HttpSession session=req.getSession();
		session.invalidate();
		//重定向到登录页面；
		resp.sendRedirect("/user/login.jsp");
	}
	//处理登录，登录成功进入main页面；
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//从req获得的数据，以参数的形式转给业务层；
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		User u= us.checkLoginService(uname, pwd);
		
		if(u!=null) {
			//重定向前获取session对象；
			HttpSession session=req.getSession();
			session.setAttribute("user", u);
			//重定向;建议使用绝对路径；
			resp.sendRedirect("/user/main.jsp");
			return;
		}else {
			//请求转发
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
	}
}
