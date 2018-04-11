package com.education.modules.login.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.education.common.util.MD5Tools;
import com.education.entity.User;
import com.education.mapper.login.UserMapper;
import com.education.modules.login.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserMapper userMapper;

	/**
	 * 更新单个用户信息
	 * 
	 */
	@Override
	public User update(User user) {
		String password = user.getPassword();
		if (password != null) {
			try {
				user.setPassword(new String(MD5Tools.Encrytor(password)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		userMapper.update(user);
		return user;
	}

	/**
	 * 根据主键 id 加载用户对象
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public User load(int id) {
		return userMapper.load(id);
	}

	/**
	 * 根据用户名加载用户对象（用于登录使用）
	 * 
	 * @param username
	 * @return
	 */
	@Override
	public User loadByUsername(String username) {
		return userMapper.loadByUserName(username);
	}

	/**
	 * 登录逻辑 1、先根据用户名查询用户对象 2、如果有用户对象，则继续匹配密码 如果没有用户对象，则抛出异常
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public User login(String username, String password) {
		User user = userMapper.loadByUserName(username);
		return user;
	}

	/**
	 * 查询所有的用户对象列表
	 * 
	 * @return
	 */
	@Override
	public List<User> list() {
		return userMapper.listUser();
	}
}
