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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/List.css">
  </head>
  
  <body>
  	<nav>
  		<a href="index.jsp">首页</a>
    	<a href="updateUserServlet?id=${loginId}">欢迎：${loginName}</a>
    </nav>
    <div class="list">
		<section class="t">详细列表</section>
		<section class="search">
			<form action="searchServlet" method="post">
				<input type="text" name="search" placeholder="输入要搜索的内容">
				<button type="submit">搜索</button>
			</form>
		</section>
		<section class="word_list">
		<c:forEach var="p" items="${penAll}">
			<div class="word_list_item">
				<div class="image">
					<img src="image/${p.penImg}.jpg">
				</div>
				<div class="txt">
					<input type="hidden" name="penId" value="${p.penId}">
					<div>${p.penName}</div>
					<div>${p.penInfo}</div>
					<a href="mainServlet?penId=${p.penId}">查看详情</a>&nbsp;&nbsp;
					<a href="deletePenServlet?penId=${p.penId}">删除</a>
				</div>
			</div>
		</c:forEach>
		</section>
	</div>
	<footer>
		<div>Copyright &copy; 2017-2018 Azura Inc. All Rights Reserved</div>
	</footer>
  </body>
</html>
