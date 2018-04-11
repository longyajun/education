package com.education.modules.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.education.modules.login.service.IUserService;


@Controller
@RequestMapping("/login/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	
	//注册方法  
    @RequestMapping("/addregister")  
    public String register(HttpServletRequest request){
    	
		return null;
    }
	
	/**
	 * 登录成功，进入管理首页
	 */
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		return null;
	}
	
	
	
}
