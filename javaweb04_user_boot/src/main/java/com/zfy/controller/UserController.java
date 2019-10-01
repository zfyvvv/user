package com.zfy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zfy.pojo.User;
import com.zfy.service.UserService;
import com.zfy.service.impl.UserServiceImpl;


@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("login")
	public String loginUser(User user) {
		User user2=userServiceImpl.checkLogin(user);
		if(user2!=null) {
			return "main";
		}else{
			return "login.jsp";
		}
	}
	
	@RequestMapping("add")
	public String addUser(User user) {
		userServiceImpl.addUser(user);
		return "main";
	}
	@RequestMapping("del")
	public String delUser(User user) {
		userServiceImpl.removeUser(user);
		return "main";
	}
	@RequestMapping("upd")
	public String updUser(User user) {
		userServiceImpl.updUser(user);
		return "main";
	}
	@RequestMapping("show")
	public String showUser(Model model) {
		List<User> list = userServiceImpl.showUser();
		model.addAttribute("list", list);
		return "show.jsp";
	}
	
	@RequestMapping("showone")
	public String showOneUser(User user,Model model) {
		User user2=userServiceImpl.selByname(user);
		//System.out.println(user2);
		List<User> list =new ArrayList<User>();
		list.add(user2);
		model.addAttribute("list", list);
		return "show.jsp";
	}
	
	@RequestMapping("main")
	public String updUser() {
		return "main.jsp";
	}

}
