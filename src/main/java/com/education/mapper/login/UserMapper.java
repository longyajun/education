package com.education.mapper.login;

import java.util.List;

import com.education.entity.User;

public interface UserMapper {

	Integer update(User user);
	
	User load(Integer id);
	
	User loadByUserName(String username);
	
	List<User> listUser();
}
