package com.cn.cpic.service;

import com.cn.cpic.pojo.User;

public interface IUserService {
	public User getUserById(int userId);

	public User findUserByUsername(String username);  
}
