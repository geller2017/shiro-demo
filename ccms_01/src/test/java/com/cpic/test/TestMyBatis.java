package com.cpic.test;


import javax.annotation.Resource;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import com.alibaba.fastjson.JSON;
import com.cn.cpic.config.Md5Util;
import com.cn.cpic.pojo.User;
import com.cn.cpic.service.IUserService;  

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  

public class TestMyBatis {  
  private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//private ApplicationContext ac = null;  
  @Resource  
  private IUserService userService;  

//@Before  
//public void before() {  
//    ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//    userService = (IUserService) ac.getBean("userService");  
//}  

  @Test  
  public void test1() {  
      User user = userService.getUserById(1);  
      // System.out.println(user.getUserName());  
      // logger.info("值："+user.getUserName());  
      logger.info(JSON.toJSONString(user));  
  } 
  
  @Test 
  public void getMd5(){
	  System.out.println(Md5Util.MD5("user111111"));
  }
  
}  