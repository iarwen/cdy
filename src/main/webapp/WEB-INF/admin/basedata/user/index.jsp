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
	href="<%=path%>/admin/js/bootstrap-3.2.0-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/admin/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/admin/css/style.css?v=<%=System.currentTimeMillis()%>" />
<script type="text/javascript" src="<%=path%>/admin/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/admin/js/jquery.sorted.js"></script>
<script type="text/javascript"
	src="<%=path%>/admin/js/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/admin/js/ckform.js"></script>
<script type="text/javascript"
	src="<%=path%>/admin/js/common.js?v=<%=System.currentTimeMillis()%>"></script>
<style type="text/css">
body {
	font-family: 微软雅黑
}

hr {
	padding: 0px;
	margin: 0px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<form class="form-inline m20" action="index" method="get">
				<input type="text" name="userName"
					class="form-control input-default" placeholder="模糊匹配用户名"
					value="${ user.userName}" />
				<button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>
		<div class="row">
			<hr />
		</div>
		<div class="row m10">
			<div class="col-sm-12">
				<button type="button" class="btn  btn-success" id="addnew">新增</button>
				<button type="button" class="btn  btn-info" id="addnew">编辑</button>
				<button class="btn btn-warning" onclick="del()">删除</button>
				<button class="btn btn-success" onclick="enable()">解锁</button>
				<button class="btn btn-warning" onclick="disable()">锁定</button>
			</div>
		</div>
		<div class="row">
			<hr />
		</div>
		<div class="row m10">
			<div class="col-sm-12 .table-responsive">
				<table
					class="table table-bordered table-hover  definewidth  table-condensed">
					<thead>
						<tr>
							<th>用户ID</th>
							<th>用户名称</th>
							<th>用户状态</th>
							<th>最后登录时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${userlist}" varStatus="status">
							<tr align="left" uid="${user.userId}">
								<td>${user.userId}</td>
								<td>${user.userName}</td>
								<td><c:if test="${user.locked==0}">正常</c:if> <c:if
										test="${user.locked==1}">锁定</c:if></td>
								<td>${user.lastVisit}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<ul class="pagination">
					<li><a href="#">&laquo;</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#addnew').click(function() {
				window.location.href = "gotoaddnew";
			});
		});

		function del() {
			if (confirm("确定要删除吗？")) {
				var uids = [];
				$(".tableRowSelected").each(function() {
					var user=new Object();
					user.userId=$(this).attr("uid");
					uids.push(user);
				});
				$.ajax({
					   type: "POST",
					   url:"delete",
					   dataType:"json",      
					   contentType:"application/json",   
					   data: JSON.stringify(uids) ,
					   success: function(data){
						   if(data.isSuccess){
								reloadData();
							}else{
								alert(data.msg);
							}
					   }
					});
			}
		}
		function enable() {
			if (confirm("确定要启用吗？")) {
				var url = "enable/" + id;
				window.location.href = url;
			}
		}
		function disable(id) {
			if (confirm("确定要禁用吗？")) {
				var url = "disable/" + id;
				window.location.href = url;
			}
		}
	</script>
</body>
</html>