<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = (String) request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>login</title>
<link type="text/css" href="/css/reset.css" rel="stylesheet" />
<!--must have for everypage-->
<link type="text/css" href="/css/home.css" rel="stylesheet" />
<script type="text/javascript" src="/js/jquery-easyui-1.3.5/jquery.min.js">
	
</script>
<!--log_tabJS start-->
<script type="text/javascript" language="javascript">
	function loginSubmit() {
		var loginId = $("#loginId").val();
		var password = $("#password").val();
		var number = $("#number").val();
		if (loginId.length < 1) {
			alert("用户名不能为空！");
			return false;
		}
		if (password.length < 1) {
			alert("密码不能为空！");
			return false;
		}
		if (number.length < 1) {
			alert("验证码不能为空！");
			return false;
		}
		var tar_form = document.getElementById("myFrom");
		tar_form.action = "/userLogin.do?method=login";
		tar_form.submit();
	}

	function showing() {
		var url = '/servlet/imageServlet?time=' + Math.random();
		document.getElementById("coding").src = url;
	}

	if (window != top)
		top.location.href = location.href;
</script>
</head>
<body class="Back" onload="document.getElementById('loginId').focus()">
	<div class="Backstage">
		<div class="loginbox">
			<form name="myFrom" id="myFrom" method="post"
				action="/userLogin.do?method=login">
				<!--h_ul start-->
				<ul class="h_ul login">
					<li><label class="form-label" for="loginId" id="login_id_type">
							用户名： </label> <input type="text" class="hors_input_in" id="loginId"
						name="loginId" maxlength="50"
						onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" /></li>
					<li><label class="form-label" for="password"> 密码： </label> <input
						type="password" class="hors_input_in" id="password" maxlength="255"
						name="password" /></li>
					<li><label class="form-label" for="number"> 验证码： </label> <input
						type="text" id="number" name="number" maxlength="4"
						class="hors_input_in"> <label class="form-label">
							&nbsp; </label> <img id="coding" alt="user code" src="/servlet/imageServlet" />
						<a href="javascript:showing()"> 看不清，换一张 </a></li>
					<li><span style="color: #C00; margin: 0px 0px 0px 25px;">
							${message} </span></li>
					<li><label class="form-label"> &nbsp; </label> <input
						type="button" value=" 重置"
						onclick="document.myFrom.reset()" class="hors_input_btn" /> <input
						type="submit" value=" 登录" onclick="loginSubmit()"
						class="hors_input_btn" /></li>
				</ul>
				<!--h_ul end-->
			</form>
		</div>
	</div>
</body>
</html>
