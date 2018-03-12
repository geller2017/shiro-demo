package com.cn.cpic.sys;


import java.util.HashSet;  
import java.util.Iterator;  
import java.util.Set;  

import org.apache.shiro.authc.AuthenticationException;  
import org.apache.shiro.authc.AuthenticationInfo;  
import org.apache.shiro.authc.AuthenticationToken;  
import org.apache.shiro.authc.LockedAccountException;  
import org.apache.shiro.authc.SimpleAuthenticationInfo;  
import org.apache.shiro.authc.UnknownAccountException;  
import org.apache.shiro.authz.AuthorizationInfo;  
import org.apache.shiro.authz.SimpleAuthorizationInfo;  
import org.apache.shiro.realm.AuthorizingRealm;  
import org.apache.shiro.subject.PrincipalCollection;  
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.cpic.pojo.Permission;
import com.cn.cpic.pojo.Role;
import com.cn.cpic.pojo.User;
import com.cn.cpic.service.IUserService;

public class UserRealm extends AuthorizingRealm{  
    
  @Autowired  
  private IUserService userService;  

  /** 
   * ��Ȩ���� 
   */  
  @Override  
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
//    String username = (String) getAvailablePrincipal(principals);  
      String username = (String) principals.getPrimaryPrincipal();  
        
      Set<Role> roleSet =  userService.findUserByUsername(username).getRoleSet();  
      //��ɫ���ļ���  
      Set<String> roles = new HashSet<String>();  
      //Ȩ�����ļ���  
      Set<String> permissions = new HashSet<String>();  
        
      Iterator<Role> it = roleSet.iterator();  
      while(it.hasNext()){  
          roles.add(it.next().getName());  
          for(Permission per:it.next().getPermissionSet()){  
              permissions.add(per.getName());  
          }  
      }  

        
      SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
        
      authorizationInfo.addRoles(roles);  
      authorizationInfo.addStringPermissions(permissions);  
        
        
      return authorizationInfo;  
  }  

  /** 
   * �����֤���� 
   */  
  @Override  
  protected AuthenticationInfo doGetAuthenticationInfo(  
          AuthenticationToken token) throws AuthenticationException {  
        
      String username = (String) token.getPrincipal();  
      User user = userService.findUserByUsername(username);  
        
      if(user==null){  
          //ľ���ҵ��û�  
          throw new UnknownAccountException("û���ҵ����˺�");  
      }  
      /* if(Boolean.TRUE.equals(user.getLocked())) {   
              throw new LockedAccountException(); //�ʺ�����   
          } */  
        
      /** 
       * ����AuthenticatingRealmʹ��CredentialsMatcher��������ƥ�䣬��������˼ҵĲ��ÿ����ڴ��жϻ��Զ���ʵ��   
       */  
      SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),getName());  
        
        
      return info;  
  }  
  
  
    
  @Override  
  public String getName() {  
      return getClass().getName();  
  }  

}  