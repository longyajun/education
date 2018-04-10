package com.education.modules.login.service;

import java.util.List;

import com.education.entity.User;


public interface IUserService {

	 /**
     * 更新单个用户信息
     * @param user
     * @return
     */
    User update(User user);

    /**
     * 根据主键 id 加载用户对象
     * @param id
     * @return
     */
    User load(int id);

    /**
     * 根据用户名加载用户对象（用于登录使用）
     * @param username
     * @return
     */
    User loadByUsername(String username);
    
	/**
     * 登录逻辑
     * 1、先根据用户名查询用户对象
     * 2、如果有用户对象，则继续匹配密码
     * 如果没有用户对象，则抛出异常
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);
    
    /**
     * 查询所有的用户对象列表
     * @return
     */
    List<User> list();
}
