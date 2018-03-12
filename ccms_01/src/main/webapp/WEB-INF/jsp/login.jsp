<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>测试</title>  
  </head>  
  <body>
	<form action="<%=request.getContextPath() %>/login/auth" method="post">
		<div>
			<label>用户名</label><input type="text" name="loginname" />
		</div>
		<div>
			<label>密 码</label><input type="text" name="password" />
		</div>
		<div>
			<input type="submit" value="登录" />
		</div>
	</form>
</body>  
</html> 