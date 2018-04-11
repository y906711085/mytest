<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>登陆页面</title>
</head>

<body>
	<form action="login" method="post">
		用户名：<input name="username" type="text" /><br /> 密码：<input
			name="password" type="password" /><br /> <input type="submit"
			value="提交" />
	</form>
</body>
</html>
