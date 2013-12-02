<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>用户登录</title>
<link rel="stylesheet" href="css/reset.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/invalid.css" type="text/css"
	media="screen" />
</head>
<body id="login">
	<div id="login-wrapper">
		<div id="login-top">
			<h1>用户登录</h1>
		</div>
		<div id="login-content">
			<form action="${pageContext.request.contextPath}/loginAction">
				<div class="notification information png_bg">
					<div>
						<%
							if (session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION") == null) {
								out.print("请输入用户名和密码登录。");
							} else {
								out.print(((Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")).getMessage());
							}
						%>
					</div>
				</div>
				<p>
					<label>用户名： </label><input name="username" class="text-input"
						type="text" />
				</p>
				<div class="clear"></div>
				<p>
					<label>密码：</label> <input name="password" class="text-input"
						type="password" />
				</p>
				<div class="clear"></div>
				<p id="remember-password">
					<label><input name="rememberMe" type="checkbox" />记住我</label>
				</p>
				<div class="clear"></div>
				<p>
					<input class="button" type="submit" value="登 录" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>