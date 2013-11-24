<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>Simpla Admin | Sign In by www.865171.cn</title>
   <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen" />
   <link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
   <link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen" />
   <script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
   <script type="text/javascript" src="script/simpla.jquery.configuration.js"></script>
   <script type="text/javascript" src="script/facebox.js"></script>
   <script type="text/javascript" src="script/jquery.wysiwyg.js"></script>
</head>
<body id="login">
<div id="login-wrapper" class="png_bg">
  <div id="login-top">
    <h1>Simpla Admin</h1>
    <!-- Logo (221px width) -->
    <a href=""><img id="logo" src="${pageContext.request.contextPath}/images/logo.png" alt="Simpla Admin logo" /></a> </div>
  <!-- End #logn-top -->
  <div id="login-content">
    <form action="employee/login.do">
      <div class="notification information png_bg">
        <div> Just click "Sign In". No password needed. </div>
      </div>
      <p>
        <label>Username</label>
        <input class="text-input" type="text" />
      </p>
      <div class="clear"></div>
      <p>
        <label>Password</label>
        <input class="text-input" type="password" />
      </p>
      <div class="clear"></div>
      <p id="remember-password">
        <input type="checkbox" />
        Remember me </p>
      <div class="clear"></div>
      <p>
        <input class="button" type="submit" value="Sign In" />
      </p>
    </form>
  </div>
  <!-- End #login-content -->
</div>
<!-- End #login-wrapper -->
</body>
</html>