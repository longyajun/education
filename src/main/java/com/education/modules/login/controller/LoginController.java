package com.education.modules.login.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.education.common.Constants;
import com.education.common.util.AjaxJson;
import com.education.common.util.BeautifyUtil;
import com.education.common.util.JsonOutPut;
import com.education.entity.User;
import com.education.modules.login.service.IUserService;

/**
 * http://localhost:8080/education/login
 * 
 * @author lsk
 *
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(HttpServletResponse response) {
    	System.out.println("进入登录页面！！！");
    	User user=userService.loadByUsername("test");
        String userStr= JSON.toJSONString(user);
        
        logger.info("打印：{0}" + BeautifyUtil.formatJson(userStr));
        JsonOutPut.objectToResponse(new AjaxJson(0,userStr.toString()), response);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, Model model) {
		String username = user.getUserName();
		String password = user.getPassword();
		logger.info("准备登录用户 => " + username + "准备用户密码 => " + password);
		User userEntity = userService.login(username, password);
		String str = "";
		if (userEntity != null) {
			str = "index";
		} else {
			str = "login";
		}
		return str;
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(Constants.SESSION_KEY);
        return "redirect:/login";
    }
}
