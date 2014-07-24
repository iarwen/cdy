<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = (String) request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/style.css" />
    <script type="text/javascript" src="<%=path%>/admin/js/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>/admin/js/jquery.sorted.js"></script>
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

        @media (max-width: 980px) {
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
<form class="form-inline definewidth m20" action="index" method="get">    
    用户名：
    <input type="text" name="userName" class="abc input-default" placeholder="模糊匹配用户名"  value="${ user.userName}">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
	    <tr>
	        <th>用户id</th>
	        <th>用户名称</th>
	        <th>用户状态</th>
	        <th>最后登录时间</th>
	        <th>操作</th>
	    </tr>
    </thead>
	<tbody>
	 	<c:forEach var="user" items="${userlist}" varStatus="status">   
     		<tr <c:if test="${status.count%2==0}">bgcolor="#CCCCFE"</c:if> align="left">
     			<td>${user.userId}</td>
     			<td>${user.userName}</td>
     			<td><c:if test="${user.locked==0}">正常</c:if><c:if test="${user.locked==1}">锁定</c:if></td>
     			<td>${user.lastVisit}</td>
     			<td>
	     			<button class="btn btn-warning" onclick="del('${user.userId}')">删除</button>
	     			<button class="btn btn-success" onclick="enable('${user.userId}')">解锁</button>
	     			<button class="btn btn-warning" onclick="disable('${user.userId}')">锁定</button>
     			</td>
            </tr>   
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
    $(function () {
		$('#addnew').click(function(){
				window.location.href="gotoaddnew";
		 });
    });

	function del(id)
	{
		if(confirm("确定要删除吗？"))
		{
			var url = "delete/"+id;
			window.location.href=url;		
		}
	}
	function enable(id)
	{
		if(confirm("确定要启用吗？"))
		{
			var url = "enable/"+id;
			window.location.href=url;		
		}
	}
	function disable(id)
	{
		if(confirm("确定要禁用吗？"))
		{
			var url = "disable/"+id;
			window.location.href=url;		
		}
	}
</script>
</body>
</html>