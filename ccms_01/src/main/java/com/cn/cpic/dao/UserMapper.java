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
     * �����û�����ѯ�û��ͽ�ɫ��Ϣ
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}