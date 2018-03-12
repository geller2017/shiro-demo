package com.cn.cpic.dao;

import com.cn.cpic.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /***
     * 根据用户名查询用户和角色信息
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}