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
<title>没有权限</title>
<script type="text/javascript">
	if (self.location != top.location) {
		top.location.href = location.href;
	}
</script>

</head>

<body>
	<center>
		你没有权限访问该页面！ <a href="${base}/index.jsp">返回首页</a>
	</center>
</body>
</html>
