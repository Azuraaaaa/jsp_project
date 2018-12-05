<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>错误提示</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/UserError.css">
  </head>
<body>
  	  <nav>
    	<a href="javascript:history.back(-1)">返回</a>
      </nav>
  	  <div>
  	  	<h2>用户名称或密码不能为空且用户名不能包括以下字符：</h2>
  	  	<div>!、#、$、%、^、;、\\、//、/、,、:、<、>、?、+</div>
  	  </div>
	<footer>
		<div>Copyright &copy; 2017-2018 Azura Inc. All Rights Reserved</div>
	</footer>
</body>
</html>