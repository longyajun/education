package com.education.modules.login.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.education.entity.User;
import com.education.modules.login.service.IUserService;

/**
 * http://localhost:8080/education/login
 * @author lsk
 *
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IUserService userService;
	
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletResponse response){
        return "login";
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Model model){
    	 String username = user.getUserName();
         String password = user.getPassword();
         logger.info("准备登录用户 => " + username);
         logger.info("准备用户密码 => " + password);
         
		return null;
    }
}
