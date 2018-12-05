<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index2.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/index.css">
	<script type="text/javascript">
		function display_alert()
		  {
		  	alert("查看详细信息请先登录！")
		  }
	</script>
</head>
<body>
	<nav>
    		<a href="Login.jsp">登录</a>
    		<a href="Register.jsp">注册</a>
    </nav>
	<div class="grid">
		<section class="t">钢笔</section>
		<div class="pic_list">
<!--
			<c:forEach var="p" items="${penAll}">
				<img src="/image/bg1.jpg">
				${p.penImg}
			</c:forEach>
-->
			<img src="image/gb1.jpg" onclick="display_alert()">
			<img src="image/gb2.jpg" onclick="display_alert()">
			<img src="image/gb3.jpg" onclick="display_alert()">
			<img src="image/gb4.jpg" onclick="display_alert()">
			<img src="image/gb5.jpg" onclick="display_alert()">
		</div>
	</div>
	<footer>
		<div>Copyright &copy; 2017-2018 Azura Inc. All Rights Reserved</div>
	</footer>
</body>
</html>
