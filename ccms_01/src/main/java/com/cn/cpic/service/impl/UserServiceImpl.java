package com.cn.cpic.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.cpic.dao.UserMapper;
import com.cn.cpic.pojo.User;
import com.cn.cpic.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private UserMapper userDao;  
    @Override  
    public User getUserById(int userId) {  
        return userDao.selectByPrimaryKey(userId);  
    }
	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}    
}
