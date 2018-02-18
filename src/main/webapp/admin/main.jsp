<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8"></meta>
<title>后台管理界面</title>
<link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.3.3/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.3.3/themes/icon.css" />
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	/*<![CDATA[*/  
	function logout(){
		$.messager.confirm("系统提示","您确定要退出系统吗？",function(r){
			if(r){
				window.location.href="/admin/manager/logout";
			}
		});
	}
	
	function openTab(text,url,iconCls){
		if($("#tabs").tabs("exists",text)){
			$("#tabs").tabs("select",text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:99.6%' src='/admin/"+url+"'></iframe>";
			$("#tabs").tabs("add",{
				title:text,
				iconCls:iconCls,
				closable:true,
				content:content
			});
		}
	}
	
	/*]]>*/  
</script>
</head>
<body class="easyui-layout">
<div region="north" style="height: 86px;background-color: #E0ECFF">
	<table style="padding: 5px" width="100%">
		<tr>
			<td width="50%">
				<img alt="logo" src="/static/images/logo.png" />
			</td>
			<td valign="bottom" align="right" width="50%">
				<font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${currentUser.userName }</span></font>
			</td>
		</tr>
	</table>
</div>

<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div title="首页" data-options="iconCls:'icon-home'">
			<div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎使用</font></div>
		</div>
	</div>
</div>

<div region="west" style="width: 200px" title="导航菜单" split="true">
	<div style="padding-top: 10px;padding-left: 10px;">
	        <a href="javascript:openTab('添加电影信息','modifyFilm.jsp','icon-addFilm')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-addFilm'" style="width: 150px;">添加电影信息</a>
			<a href="javascript:openTab('电影动态管理','infoManage.html','icon-dynamic')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-dynamic'" style="width: 150px;">电影动态管理</a>
			<a href="javascript:openTab('电影信息管理','filmManage.html','icon-film')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-film'" style="width: 150px;">电影信息管理</a>
			<a href="javascript:openTab('网址信息管理','webSiteManage.html','icon-website')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-website'" style="width: 150px;">网址信息管理</a>
			<a href="javascript:openTab('友情链接管理','linkManage.html','icon-link')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px;">友情链接管理</a>
			<a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
	</div>
</div>

<div region="south" style="height: 30px;padding: 5px" align="center">
	Copyright © 2012-2017 南通小锋网络科技有限公司  版权所有
</div>
</body>
</html>