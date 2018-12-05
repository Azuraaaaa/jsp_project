<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/Main.css">
  </head>
  
  <body>
    <nav>
    	<a href="javascript:history.back(-1)">返回</a>
    </nav>
    <div>${searchInfo}</div>
    <c:forEach var="pen" items="${pen}">
	<div class="news">
		<img src="image/${pen.penImg}.jpg">
		<div>
			<h1>${pen.penName}</h1>
	        <p>${pen.penInfo}</p>
		</div>
		<img src="image/${pen.penImg}-1.jpg">
	</div>
	</c:forEach>
	<footer>
		<div>Copyright &copy; 2017-2018 Azura Inc. All Rights Reserved</div>
	</footer>
  </body>
</html>
