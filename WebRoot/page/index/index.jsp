<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>Simpla Admin by www.865171.cn</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/invalid.css" type="text/css" media="screen" />
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/facebox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.wysiwyg.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.datePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.date.js"></script>
</head>
<script type="text/javascript">
$(function(){
<%--	$("#authority").click(--%>
<%--			function (){--%>
<%--				$("#authority").removeClass("nav-top-item").addClass("nav-top-item current");--%>
<%--				$("#myprocedures").removeClass("nav-top-item").addClass("nav-top-item current");--%>
<%--				$("#personnel").removeClass("nav-top-item").addClass("nav-top-item current");--%>
<%--				$("#administration").removeClass("nav-top-item").addClass("nav-top-item current");--%>
<%--				$("#finance").removeClass("nav-top-item").addClass("nav-top-item current");--%>
<%--				$("#system").removeClass("nav-top-item").addClass("nav-top-item current");--%>
<%--			});--%>
})

</script>
<body>
<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h1 id="sidebar-title"><a href="#">Simpla Admin</a></h1>
      <!-- Logo (221px wide) -->
      <a href="http://www.865171.cn"><img id="logo" src="${pageContext.request.contextPath}/images/logo.png" alt="Simpla Admin logo" /></a>
      <!-- Sidebar Profile links -->
      <div id="profile-links"> Hello, <a href="#" title="Edit your profile">865171</a>, you have <a href="#messages" rel="modal" title="3 Messages">3 Messages</a><br />
        <br />
        <a href="#" title="View the Site">View the Site</a> | <a href="#" title="Sign Out">Sign Out</a> </div>
      <ul id="main-nav">
        <!-- Accordion Menu -->
        <li> <a href="#" class="nav-top-item" id="myprocedures">我的流程 </a> 
        
        
        </li>
        <li> <a href="#" class="nav-top-item" id="authority"> 权限管理 </a>
          <ul>
            <li><a href="#">功能管理</a></li>
            <li><a href="#">角色管理</a></li>
            <li><a href="#">权限管理</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item" id="personnel"> 人事管理 </a>
          <ul>
            <li><a href="${pageContext.request.contextPath}/employee/index.do" target="right_iframe">员工管理</a></li>
            <li><a href="#" >薪酬管理</a></li>
            <li><a href="#">调动管理</a></li>
            <li><a href="#">考勤管理</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item" id="administration"> 行政管理 </a>
          <ul>
            <li><a href="#">会议管理 </a></li>
            <li><a href="#">办公用品管理</a></li>
            <li><a href="#">车辆使用管理</a></li>
            <li><a href="#">固定资产管理</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item" id="finance"> 客户管理 </a>
          <ul>
            <li><a href="#">Calendar Overview</a></li>
            <li><a href="#">Add a new Event</a></li>
            <li><a href="#">Calendar Settings</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item" id="system"> 系统设置 </a>
          <ul>
            <li><a href="#">General</a></li>
            <li><a href="#">Design</a></li>
            <li><a href="#">Your Profile</a></li>
            <li><a href="#">Users and Permissions</a></li>
          </ul>
        </li>
      </ul>
      <!-- End #main-nav -->
      <div id="messages" style="display: none">
        <!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
        <h3>3 Messages</h3>
        <p> <strong>17th May 2009</strong> by Admin<br />
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <p> <strong>2nd May 2009</strong> by Jane Doe<br />
          Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis, tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <p> <strong>25th April 2009</strong> by Admin<br />
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <form action="#" method="post">
          <h4>New Message</h4>
          <fieldset>
          <textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
          </fieldset>
          <fieldset>
          <select name="dropdown" class="small-input">
            <option value="option1">Send to...</option>
            <option value="option2">Everyone</option>
            <option value="option3">Admin</option>
            <option value="option4">Jane Doe</option>
          </select>
          <input class="button" type="submit" value="Send" />
          </fieldset>
        </form>
      </div>
      <!-- End #messages -->
    </div>
  </div>
  <!-- End #sidebar -->
  <div id="main-content">
 	<iframe name="right_iframe" id="right_iframe" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
  </div>
  <!-- End #main-content -->
</div>
 <script type="text/javascript">
<%--  	function currentli(obj){--%>
<%--  		var html = $(obj).parent().parent().prev().html();--%>
<%--  		html = html.substring(html.indexOf('</i>')+'</i>'.length);--%>
<%--  		$('#firsttitle').html(html);--%>
<%--  		$('#secondtitle').html($(obj).html());--%>
<%--  		var liarray = $('li.active');--%>
<%--  		$.each(liarray, function(i,e){      --%>
<%--  	      $(e).removeClass('active');--%>
<%--  	  	});--%>
<%--  		$(obj).parent().addClass('active');--%>
<%--  	}--%>
  </script>
</body>

<!-- Download From www.exet.tk-->
</html>
