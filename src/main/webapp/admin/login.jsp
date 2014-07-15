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
   <link rel="stylesheet" type="text/css" href="<%=path%>/admin1//Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/admin1//Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/admin1//Css/style.css" />
    <script type="text/javascript" src="<%=path%>/admin1//Js/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>/admin1//Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=path%>/admin1//Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=path%>/admin1//Js/ckform.js"></script>
    <script type="text/javascript" src="<%=path%>/admin1//Js/common.js"></script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
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
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>  
</head>
<body>
<div class="container">

    <form class="form-signin" method="post" action="<%=path%>/admin1//index.html">
        <h2 class="form-signin-heading">登录系统</h2>
        <input type="text" name="username" class="input-block-level" placeholder="账号">
        <input type="password" name="password" class="input-block-level" placeholder="密码">
        <input type="text" name="verify" class="input-medium" placeholder="验证码">
       
        <p><button class="btn btn-large btn-primary" type="submit">登录</button></p>
    </form>

</div>
</body>
</html>