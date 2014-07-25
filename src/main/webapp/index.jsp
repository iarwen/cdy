<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = (String) request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理系统</title>
	<meta charset="UTF-8">
   <link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/style.css" />
    <script type="text/javascript" src="<%=path%>/admin/js/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>/admin/js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=path%>/admin/js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=path%>/admin/js/ckform.js"></script>
    <script type="text/javascript" src="<%=path%>/admin/js/common.js"></script>
    <script type="text/javascript">
	function showing() {
		var url = '/servlet/imageServlet?time=' + Math.random();
		document.getElementById("coding").src = url;
	}
	function valid() {
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
		return true;
	}
    </script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
            font-family: 微软雅黑;
        }

        .form-signin {
            max-width: 400px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
            text-align: center;
        }

        .form-signin input[type="text"],
        .form-signin input[type="verify"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
		
		.errmsg{
			padding-left: 50px;
			color: red;
		}
    </style>  
</head>
<body>
<div class="container">

    <form class="form-signin" method="post"  onsubmit=" return  valid()" action="/login">
        <h2 class="form-signin-heading">登录系统</h2>
        
        <input type="text"  id ="loginId" name="userName" class="input-block-level" placeholder="账号" value="${user.userName }">
      
        <input type="password" id ="password"  name="password" class="input-block-level" placeholder="密码"  value="${user.password }">
       
	     <input type="text"  id="number" name="verify" class="input-medium col-xm-6" placeholder="验证码" value="${verify }">
	     
	     <img id="coding" alt="user code"   class="col-xm-3" src="/servlet/imageServlet" />
		 <a href="javascript:showing()"  class="col-xm-3" > 看不清,换一张 </a>
		 <div class="row errmsg" >&nbsp;${errorMsg}</div>
        <p><button class="btn btn-large btn-primary" type="submit">登录</button></p>
    </form>

</div>
</body>
</html>