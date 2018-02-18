<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.3.3/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/static/jquery-easyui-1.3.3/themes/icon.css" />
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="/static/ckeditor/ckeditor.js"></script>

<title>Insert title here</title>
</head>

<script type="text/javascript">
	function submitData(){
		var name = $("#name").val();
		var title = $("#title").val();
		var filmTypeId = $("#filmTypeId").combobox("getValue");
		var districtId = $("#districtId").combobox("getValue");
		var hot = $("input[name='hot']:checked").val();
		var publishDate = $('#publishDate').datebox('getValue');
		var content=CKEDITOR.instances.content.getData();
		var imageFile = $("#imageFile").val();
		
		var file = document.getElementById("imageFile").files[0];
		
		
		if(name==null || name==""){
			alert("请输入电影名称!");
			return;
		}
		if(title==null || title==""){
			alert("请输入标题!");
			return;
		}
		if(imageFile==null || imageFile==""){
			alert("请选择电影图片!");
			return;
		}
		if(publishDate==null||publishDate==""){
			alert("请选择上映时间!");
			return;
		}
		if(filmTypeId==null||filmTypeId==""){
			alert("请选择电影类别!");
			return;
		}
		if(districtId==null||districtId==""){
			alert("请选择发行地区!");
			return;
		}
		if(content==null || content==""){
			alert("请输入电影内容!");
			return;
		}
		
		var form = new FormData();
		form.append("name",name);
		form.append("title",title);
		form.append("filmTypeId",filmTypeId);
		form.append("districtId",districtId);
		form.append("hot",hot);
		form.append("publishDate",publishDate);
		form.append("content",content);
		form.append("imageFile",file);
		
		var xhr = new XMLHttpRequest();
		
		xhr.open("post", "../admin/film/save.do", true);
		
		
		xhr.send(form);
		
		xhr.onload=function(){
			alert("上传成功!");
			resetData();
		};
		
	}
	
	function resetData(){
		$("#name").val("");
		$("#title").val("");
		document.getElementById("yes").checked=true;  
        document.getElementById("no").checked=false;
		//$("#publishDate").datetimebox("setValue", "");
		CKEDITOR.instances.content.setData("");
		$("#imageFile").val("");
		
	}
	
</script>


<body style="magrin:10px;">
	<div id="p" class="easyui-panel" title="添加电影" style="padding:10px">
		<table cellspacing="20px;">
			<tr>
				<td width="80px">电影名称:</td>
				<td>
					<input type="text" id="name" width="400px" class="easyui-validatebox" required="true">
				</td>
			</tr>
			<tr>
				<td width="80px">标题:</td>
				<td><input type="text" id="title" width="400px;" class="easyui-validatebox" required="true"></td>
			</tr>
			<tr>
				<td width="80px">电影图片:</td>
				<td>
					<input type="file" id="imageFile" name="imageFile" />
				</td>
			</tr>
			<tr>
				<td>上映时间</td>
				<td><input id="publishDate" type="text" class="easyui-datebox" required="required"></td>
			</tr>
			<tr>
				<td>电影类别</td>
				<td>
					<select class="easyui-combobox" editable="false" panelHeight="auto" id="filmTypeId" name="filmTypeId">
						<option value="" selected="selected">请选择电影类别</option>
						<c:forEach	var="filmType" items="${filmTypeList }" >
							<option  value="${filmType.id }">${filmType.typeName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>发行地区</td>
				<td>
					<select class="easyui-combobox" editable="false" name="districtId" panelHeight="auto" id="districtId">
						<option value="">请选择发行地区</option>
						<c:forEach var="district" items="${districtList }">
							<option value="${district.id }">${district.districtName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td width="80px">设置热门</td>
				<td>
					<input type="radio" id="yes" name="hot" value="1" checked="checked">是&nbsp;
					<input type="radio" id="no"  value="0" name="hot">否&nbsp;
				</td>
			</tr>
			<tr>
				<td valign="top">内容:</td>
				<td>
					<textarea id="content" name="content" rows="30" cols="80"></textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">发布</a>
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript">
	CKEDITOR.replace("content");
</script>
</body>
</html>