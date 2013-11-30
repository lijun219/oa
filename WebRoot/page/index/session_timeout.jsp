<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>登陆超时</title>
</head>

<body>
	<center>会话超时!您没有登录,或登录超时,请重新登录!</center>
	<center>
		<a href="page/index/login.jsp">登陆</a>
	</center>
</body>
</html>
