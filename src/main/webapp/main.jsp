<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = (String) request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>index</title>
    <script src="<%=contextPath%>/js/jquery-easyui-1.3.5/jquery.min.js" type="text/javascript"></script>
    <script src="<%=contextPath%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js" type="text/javascript"></script>

    <link href="<%=contextPath%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="<%=contextPath%>/js/jquery-easyui-1.3.5/themes/icon.css" rel="stylesheet" type="text/css" />
</head>

<body class="easyui-layout" fit="true">
   
		<div region="north" border="false" style="overflow:hidden;height:60px;background:#A4BED4;">
			<h2>Borderå¸å±</h2>
		</div>
		<div region="south" split="true" style="height:50px;background:#efefef;">
		</div>
		<div region="east" icon="icon-reload" title="Menu2" split="true" style="width:180px;">
		</div>
		<div region="west" split="true" title="Menu1" style="width:100px;">
		</div>
		<div region="center" title="Main Form" style="background:#eee;">
		</div>
 
</body>
</html>