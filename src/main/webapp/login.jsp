<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>个人博客后台管理系统</title>
<link href="${pageContext.request.contextPath }/static/Wopop_files/style_log.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/Wopop_files/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/Wopop_files/userpanel.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/Wopop_files/jquery.ui.all.css">
<script src="${pageContext.request.contextPath }/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
</head>

<script type="text/javascript">
	function checkForm(){
		var userName = $("#username").val();
		var password = $("#password").val();
		if(userName==""||userName==null){
			alert("用户名不能为空");
			return false;
		}
		if(password==""||password==null){
			alert("密码不能为空");
			return false;
		}
		return true;
	}
</script>


<body class="login" mycollectionplug="bind">
<div class="login_m">
<div class="login_logo"><img src="${pageContext.request.contextPath }/static/Wopop_files/myBlogLogo.png" width="320" height="60"></div>
<div class="login_boder">

<form action="${pageContext.request.contextPath}/manager/login.do" method="post" onsubmit="return checkForm()">
<div class="login_padding" id="login_model">
  <h2>用户名</h2>
  <label>
    <input type="text" id="username" name="userName" class="txt_input txt_input2" value="" >
  </label>
  <h2>密码</h2>
  <label>
    <input type="password" name="password" id="password" class="txt_input"  value="">
  </label>
 
 

 
  <p class="forgot"><font style="color:red">${errorInfo }</font>&nbsp;&nbsp;&nbsp;<a id="iforget" href="javascript:void(0);">忘记密码?</a></p>
  <div class="rem_sub">
  <div class="rem_sub_l">
  <input type="checkbox" name="checkbox" id="save_me">
   <label for="checkbox">记住我</label>
   </div>
    <label>
      <input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;" >
    </label>
  </div>
</div>
</form>


</div><!--login_m end-->
 <br> <br>
<p align="center"> 版权所有 <a href="#" target="_blank" title="郑小强">郑小强</a> - 邮箱: <a href="#" title="Email" target="_blank">675942639@qq.com</a></p>

</body>
</html>