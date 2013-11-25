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
 	<div id="addEmployeeDialog"  title="添加员工"  style="padding:5px;background:#fff;">
	</div>
	<table id="dg"></table>
  </body>
  <script>
	$(function(){
		  $('#dg').datagrid({   
			   url:'${pageContext.request.contextPath}/employee/list.do',  
			   pageNumber:1,
			   pageSize:10,
			   loadMsg:"正在加载数据，请稍侯！",
			   width: "60%",
			    height: "500",  
			   columns:[[
					{field:'ck',title:'选择',align:'center',checkbox:true},
				    {field:'id',title:'ID',width:100},       
				    {field:'name',title:'姓名',width:100},  
				    {field:'sex',title:'性别',width:100},    
				    {field:'age',title:'年龄',width:100},
				    {field:'mobile',title:'手机',width:100},
				    {field:'account',title:'帐号',width:100},
				    {field:'email',title:'邮箱',width:100},
				    {field:'address',title:'地址',width:100},
				    {field:'createTime',title:'创建时间',width:200,align:'center',formatter: function(value, row, index){
						  return value.replace('T', ' ');
					 }}
				]],
				onHeaderContextMenu: function(e, field){
				$(this).datagrid('columnMenu',e);	
		   	 	}, 
				pagination:true,
				toolbar:[
							 {
								id:'addEmployee',
								text:'添加员工',
								iconCls:'icon-add',
								disabled:false,
								handler:function(){
									addEmployee();
								}
							},
							{
								id:'updateEmployee',
								text:'更新员工',
								iconCls:'icon-edit',
								disabled:false,
								handler:function(){
									
								}
							},
							{
								id:'enableEmployee',
								text:'启用员工',
								iconCls:'icon-ok',
								disabled:false,
								handler:function(){
									
								}
							},
							{
								id:'disableEmployee',
								text:'禁用员工',
								iconCls:'icon-no',
								disabled:false,
								handler:function(){
									
								}
							}],
				onLoadError:function(){
					$.messager.alert('提示','加载数据失败，请重试!',"error");	
				},
				onLoadSuccess:function(){
				},
				onSelect:function(){//当用户选择某行时触发
<%--					$('#dg').datagrid('btenable',['updateEmployee','enableEmployee','disableEmployee']);--%>
				},
				onUnselect:function(){//当用户取消选择某行时触发
<%--					$('#dg').datagrid('btenable',['updateEmployee','enableEmployee','disableEmployee']);--%>
				}
		});
		  //新增员工
		  function addEmployee(){
				$('#addEmployeeDialog').dialog({
					href:"${pageContext.request.contextPath}/employee/addEmployee.do?_="+Math.random(),
					width:600,
					height:400,
					modal: true,//是否显示窗口后面的遮罩
					maximizable:false,
					fit:false,
					cache:false,
					onClose:function(){
					},
					onMove:function(left,top){
						if(top<=0)$('#addEmployeeDialog').dialog('resize',{top:0});
					}
				});	
			}
				
	})
</script>
</html>

