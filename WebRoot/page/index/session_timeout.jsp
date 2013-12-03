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
<link rel="stylesheet" href="css/reset.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen">
</head>
<body style="background-image: none;">
	<center style="margin-top:20%;">
		<p>会话超时!您没有登录,或登录超时,请重新登录!</p>
		<p>
			<a href="">登陆</a>
		</p>
	</center>
</body>
</html>
