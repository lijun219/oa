<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script type="text/javascript">
	var t = 3;
	setInterval(function() {
		if (t <= 0) {
			history.go(-1);
		}
		document.getElementById("time").innerHTML = t;
		t = t - 1;
	}, 1000)
</script>
</head>
<body style="background-image: none;">
	<center style="margin-top:20%;">
		<p>您没有权限访问该页面！<font id="time">3</font>秒后将自动返回。</p>
		<p>
			<a href="${base}/index.jsp">首页</a>&nbsp;&nbsp; <a
				href="javascript:void(0);" onclick="history.go(-1);">上一页</a>
		</p>
	</center>
</body>
</html>
