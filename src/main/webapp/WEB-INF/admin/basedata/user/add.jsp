<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = (String) request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/admin/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/admin/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/style.css" />
<script type="text/javascript" src="<%=path%>/admin/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/admin/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/admin/js/ckform.js"></script>
<script type="text/javascript" src="<%=path%>/admin/js/common.js"></script>
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>
	<form action="save" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">用户名</td>
				<td><input type="text" name="userName" value="${user.userName}" /><span
					style="color: red"><c:if test="${errorMsg!=null}">${errorMsg }</c:if></span></td>
			</tr>
			<tr>
				<td class="tableleft">密码</td>
				<td><input type="password" name="password"
					value="${user.password}" /></td>
			</tr>
			<tr>
				<td class="tableleft">真实名字</td>
				<td><input type="text" name="realname" /></td>
			</tr>
			<tr>
				<td class="tableleft">Email</td>
				<td><input type="text" name="email" value="" /></td>
			</tr>
			<tr>
				<td class="tableleft">状态</td>
				<td><input type="radio" name="locked" value="1"
					<c:if test="${user.locked==1}">checked</c:if> /> 禁用 <input
					type="radio" name="locked" value="0"
					<c:if test="${user.locked==0||user.locked==null}">checked</c:if> />启用
				</td>
			</tr>
			<tr>
				<td class="tableleft">角色</td>
				<td>${role_checkbox}</td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">取消</button>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(function() {
			$('#backid').click(function() {
				window.location.href = "index";
			});

		});
	</script>
</body>
</html>
