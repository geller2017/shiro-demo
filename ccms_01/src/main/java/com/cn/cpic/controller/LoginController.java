package com.cn.cpic.controller;  
  
import java.security.Principal;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.cpic.config.Md5Util;
import com.cn.cpic.pojo.User;
import com.cn.cpic.service.IUserService;  
  
  
@Controller  
public class LoginController {  
    @Resource  
    private IUserService userService;  
      
    @RequestMapping("/login")  
    public String toIndex(HttpServletRequest request,Model model){  
        return "login"; 
    }  
    
    @RequestMapping("/login/auth")  
    public String doLogin(HttpServletRequest request){ 
    	try{
    		String username = request.getParameter("loginname");  
            String pwd = request.getParameter("password");  
            UsernamePasswordToken token = new UsernamePasswordToken(username, Md5Util.MD5(username+pwd));   
            Subject currentUser = SecurityUtils.getSubject();   
            currentUser.login(token);  
            return "home";
    	}catch(Exception e){
    		return "login";
    	}
    } 
    
    
    @RequestMapping("/user/getUserinfo") 
    @ResponseBody
    public User getUserinfo(HttpServletRequest request){ 
    	return (User)SecurityUtils.getSubject().getPrincipal();
    } 
} 