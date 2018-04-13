package com.education.modules.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.entity.Provinces;
import com.education.entity.User;
import com.education.mapper.login.UserMapper;
import com.education.modules.login.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 根据用户名加载用户对象（用于登录使用）
	 * username
	 */
	@Override
	public User loadByUsername(String email,String mobile) {
		return userMapper.loadByUserName(email,mobile);
	}

	@Override
	public String insert(User user) {
		if(userMapper.insert(user) == 1){
			return "0";
		}else{
			return "1";
		}
	}

	/**
	 * 区域查询
	 */
	@Override
	public List<Provinces> listRegion(String provinceid,String cityid) {
		List list = new ArrayList();
		if(provinceid != null){
			list = userMapper.listCities(provinceid);
		}else if(cityid !=null){
			list = userMapper.listAreas(cityid);
		}else{
			list = userMapper.listProvinces();
		}
		return list;
	}
}
