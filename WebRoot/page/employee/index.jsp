<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.min.js"></script>
  </head>
  <script type="text/javascript">
  	$(function(){
  		$.ajax({
  			url : "${pageContext.request.contextPath}/employee/list.do",
  			type:'post',
  			success: function(data) {
  	  			var employee= data.emlist;
  	  			var tr = $("<tr />"),td = $("<td/>");
  				for(var i=0;i<employee.length;i++){
  	  				var em=employee[i];
  					var _tr = tr.clone()
					.append(td.clone().append(em.id))
					.append(td.clone().append(em.name))
					.append(td.clone().append(em.mobile))
					.append(td.clone().append(em.email))
					.append(td.clone().append(em.account))
					.append(td.clone().append(em.sex))
					.append(td.clone().append(em.idCard))
					.append(td.clone().append(em.address));

					_tr.appendTo("#dataEm");
  	  			}
  			}
		});
  	  })
  </script>
  <style>
  .yg{border:1px solid gray;border-collapse: collapse;}
  .yg td{border:1px solid gray; text-align: center;}
  .yg tr {line-height:180%; }
  </style>
  <body>
 		<table>
	 		<tr>
	 			<td align="right" style="font-size:18px;font-family:宋体;color:gray;">编号</td>
	 			<td><input type="text" style="width:160;height:28;"/></td>
	 			<td align="right" style="font-size:18px;color:gray;">姓名</td>
	 			<td><input type="text"  style="width:160;height:28;"/></td>
	 			<td><input type="button" value="" style="background:url(${pageContext.request.contextPath}/images/jun_03.png);width:84;height:34;border:none;"/></td>
	 		</tr>
	 		
 		</table>
 		<table class="yg" id="dataEm" >
 			<tr background="${pageContext.request.contextPath}/images/jun_07.png" style="height:30px;">
	 			<td width="120px" >编号</td>
	 			<td width="120px">姓名</td>
	 			<td width="120px">电话</td>
	 			<td width="120px">邮箱</td>
	 			<td width="120px" >账号</td>
	 			<td width="120px">性别</td>
	 			<td width="180px">身份证号</td>
	 			<td width="200px">住址</td>
 			</tr>
 		</table>
 		<div style="text-align:right;width:900px;">
	 				<input type="button" value=" " style="background:url(${pageContext.request.contextPath}/images/jun_11.png);width:50;height:34;border:none;"/>
	 				<input type="button" value="1" style="background:url(${pageContext.request.contextPath}/images/jun_17.png);width:36;height:34;border:none;"/>
	 				<input type="button" value="2" style="background:url(${pageContext.request.contextPath}/images/jun_17.png);width:36;height:34;border:none;"/>
	 				<input type="button" value="3" style="background:url(${pageContext.request.contextPath}/images/jun_17.png);width:36;height:34;border:none;"/>
	 				<input type="button" value="5" style="background:url(${pageContext.request.contextPath}/images/jun_17.png);width:36;height:34;border:none;"/>
	 				<input type="button" value=" " style="background:url(${pageContext.request.contextPath}/images/jun_19.png);width:50;height:34;border:none;"/>
		</div>
  </body>
</html>
