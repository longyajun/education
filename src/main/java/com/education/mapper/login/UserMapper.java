package com.education.mapper.login;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.education.entity.Areas;
import com.education.entity.Cities;
import com.education.entity.Provinces;
import com.education.entity.User;

public interface UserMapper {

	/**
	 * 根据用户名加载用户对象（用于登录使用）
	 * 
	 * @param email
	 * @param mobile
	 * @return
	 */
	User loadByUserName(@Param(value = "email") String email,@Param(value = "mobile") String mobile);

	/**
	 * 添加单个用户
	 * 
	 * @param user
	 * @return
	 */
	int insert(User user);
	
	/**
	 * 查询区域
	 * @param provinces
	 * @return
	 */
	List<Provinces> listProvinces();
	
	List<Cities> listCities(String cities);
	
	List<Areas> listAreas(String provinceid);

}
