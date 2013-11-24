<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<base href="<%=basePath%>">
 <title>员工管理</title>
    <jsp:include page="/page/index/common.jsp"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
	<table id="dg"></table>
  </body>
  <script>
	$(function(){
		  $('#dg').datagrid({   
			   url:'${pageContext.request.contextPath}/employee/list.do',  
			   pageNumber:1,
			   pageSize:10,
			   loadMsg:"正在加载数据，请稍侯！",
			   width: "100%",
			    height: "500",  
			   columns:[[
					{field:'ck',title:'选择',align:'center',checkbox:true},
				    {field:'id',title:'ID',width:100},       
				    {field:'name',title:'姓名',width:100},  
				    {field:'sex',title:'性别',width:100},    
				    {field:'age',title:'年龄',width:100},
				    {field:'mobile',title:'手机',width:100},
				    {field:'account',title:'帐号',width:100},
				    {field:'email',title:'邮箱',width:100}
				]],
				onHeaderContextMenu: function(e, field){
				$(this).datagrid('columnMenu',e);	
		   	 	}, 
				pagination:true,
				toolbar:[
							 {
								id:'addstaff',
								text:'添加员工',
								iconCls:'icon-add',
								disabled:false,
								handler:function(){
									addstaff();
								}
							},
							{
								id:'updatestaff',
								text:'更新员工',
								iconCls:'icon-edit',
								disabled:true,
								handler:function(){
									updatestaff();
								}
							},
							{
								id:'enablestaff',
								text:'启用员工',
								iconCls:'icon-ok',
								disabled:true,
								handler:function(){
									enablestaff();
								}
							},
							{
								id:'disablestaff',
								text:'禁用员工',
								iconCls:'icon-no',
								disabled:true,
								handler:function(){
									disablestaff();
								}
							} ]
		});
	})
</script>
</html>

