package com.education.modules.login.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.education.common.Constants;
import com.education.common.util.AjaxJson;
import com.education.common.util.BeautifyUtil;
import com.education.common.util.IPUtils;
import com.education.common.util.JsonOutPut;
import com.education.common.util.TimeUtils;
import com.education.entity.Provinces;
import com.education.entity.User;
import com.education.modules.login.service.IUserService;

@Controller
@RequestMapping("/login/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	
	/**
	 * 区域
	 * @return
	 * http://localhost:8080/education/login/user/listregion?provinceid=110000
	 * &&cityid=110100
	 * 
	 */
	@RequestMapping(value = "/listregion", method = RequestMethod.GET)
	public void listRegion(HttpServletRequest request,HttpServletResponse response,String provinceid,String cityid){
		String message = JSON.toJSONString(userService.listRegion(provinceid,cityid));
		BeautifyUtil.printJson(message);
        JsonOutPut.objectToResponse(new AjaxJson(0,message), response);
	}

	/**
	 * http://localhost:8080/education/login/user/adduser?userName=李明&&schoolName=北京市 东城区试练实&&gradeClass=初三&&password=123&&email=q@q.com&&mobile=15756332327&&status=2
	 * @param request
	 * @param response
	 * @param userName
	 * @param schoolName
	 * @param subject
	 * @param gradeClass
	 * @param password
	 * @param password1
	 * @param email
	 * @param mobile
	 */
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public void addUserInfo(HttpServletRequest request,HttpServletResponse response,String userName,String schoolName,String subject,String gradeClass,String password,String password1,String email,String mobile,int status) {
		if(password.equals(password1)){
			;
		}else{
			JsonOutPut.objectToResponse(new AjaxJson(-1,"两次密码不一致，请重新输入"), response);
			return;
		}
		
		User userSrc = userService.loadByUsername(email, mobile);
		if(userSrc != null){
			JsonOutPut.objectToResponse(new AjaxJson(-1,"帐号存在"), response);
			return;
		}
		
		User userinfo = new User();
		userinfo.setUserName(userName);
		userinfo.setSchoolName(schoolName);
		userinfo.setSubject(subject);
		userinfo.setGradeClass(gradeClass);
		userinfo.setPassword(password);
		userinfo.setPassword1(password1);
		userinfo.setEmail(email);
		userinfo.setMobile(mobile);
		userinfo.setLastLoginIp(IPUtils.getIpAddr(request));
		userinfo.setLastLoginDate(new TimeUtils().date2String(new Date()));
		
		userinfo.setStatus(status);//学生
		String message = JSON.toJSONString(userinfo);
		System.out.println(message);
		
		String userEntity = userService.insert(userinfo);
		if(userEntity != null){
			//userEntity等于零添加成功
			JsonOutPut.objectToResponse(new AjaxJson(Constants.ACCOUNT_SESSION_SUCCESS,Constants.ACCOUNT_CHINESE_SUCCESS), response);
		}else{
			JsonOutPut.objectToResponse(new AjaxJson(Constants.ACCOUNT_SESSION_FAIL,Constants.ACCOUNT_CHINESE_FAIL), response);
		}
	}
	//
	
	
	

}
