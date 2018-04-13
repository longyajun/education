package com.education.modules.login.service;

import java.util.List;

import com.education.entity.Provinces;
import com.education.entity.User;


public interface IUserService {
	
	User loadByUsername(String email,String mobile);

	String insert(User user);
	
	List<Provinces> listRegion(String provinceid,String cityid);
	
}
