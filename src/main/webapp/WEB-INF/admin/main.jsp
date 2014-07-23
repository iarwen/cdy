<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	String path = (String) request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>后台管理系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="<%=path%>/admin/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="<%=path%>/admin/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="<%=path%>/admin/assets/css/main-min.css" rel="stylesheet" type="text/css" />
    
    
 </head>
 <body>

  <div class="header">
    
      <div class="dl-title">
       
      </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${user.userName}</span><a href="/logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <ul id="J_Nav"  class="nav-list ks-clear">
        		<li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		
        		<li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>       
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>
  <script type="text/javascript" src="<%=path%>/admin/assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="<%=path%>/admin/assets/js/bui-min.js"></script>
  <script type="text/javascript" src="<%=path%>/admin/assets/js/common/main-min.js"></script>
  <script type="text/javascript" src="<%=path%>/admin/assets/js/config-min.js"></script>
  <script>
    BUI.use('common/main',function(){
      var config = [{id:'1', 
    	  				    menu:[{
    	  				    	text:'系统管理',items:[
    	  				    	                   {id:'1',text:'机构管理',href:'Node/index.html'},
    	  				    	                   {id:'3',text:'角色管理',href:'Role/index.html'},
    	  				    	                   {id:'4',text:'用户管理',href:'user/index'},
    	  				    	                   {id:'6',text:'菜单管理',href:'Menu/index.html'}
    	  				    	                     ]
    	  				         }]
      				},
                    {id:'7',homePage : '9',
    	  					menu:[{
    	  						text:'业务管理',items:[
    	  						                   {id:'9',text:'查询业务',href:'Node/index.html'}
    	  						                      ]
    	  					     }]
      				}];
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
 </body>
</html>