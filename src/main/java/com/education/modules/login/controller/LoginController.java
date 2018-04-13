package com.education.modules.login.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.education.common.Constants;
import com.education.common.util.AjaxJson;
import com.education.common.util.BeautifyUtil;
import com.education.common.util.JsonOutPut;
import com.education.common.util.TimeUtils;
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

	/**
	 * http://localhost:8080/education/login?email=q@q.com&&mobile=15756332327
	 * @param response
	 * @param userName
	 * 邮箱登录，手机号码登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(HttpServletResponse response,String email,String mobile) {
		
    	logger.info("邮箱：" + email +" 手机号码：" + mobile);
        User user = userService.loadByUsername(email,mobile);
        String message = JSON.toJSONString(user);
        int i = -1;
        if(user == null){
        	message = "该帐号不存在！";
        }else if(user.getStatus() == 0){
        	i = 0;
        }else if(user.getStatus() == 1){
        	message = "1";
        }else if(user.getStatus() == 2){
        	message = "2";
        }else{
        	if(user.getMobile() == null || user.getMobile().length() <= 0 ){
        		message = "手机号码为空";
        	}else if(user.getEmail() == null || user.getEmail().length() <= 0){
        		message = "邮箱号为空";
        	}
        }
        
        BeautifyUtil.printJson(message);
        JsonOutPut.objectToResponse(new AjaxJson(i,message), response);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(HttpServletResponse response,String email,String mobile) {
		
		return null;
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(Constants.SESSION_KEY);
        return "redirect:/login";
    }
}
