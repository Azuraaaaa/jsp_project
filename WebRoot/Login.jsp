<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/Login.css">
  </head>
<body>
	<div class="main">
		<div class="head">
			<div></div>
		</div>
		<div class="tab">
			<div class="wel">
				欢迎登录钢笔选购网站
				<div class="second">
					——敬！还在书写的你
				</div>
			</div>
			<form action="loginServlet" method="post">
				<div>
					<input type="text" name="name" placeholder="手机号/用户名">
				</div>
				<div>
					<input type="password" name="password" placeholder="密码">
				</div>
		    	${loginErrorMessage}
		    	<div class="forget">
		    		<a href="Register.jsp">还没有账号？立即注册</a>
		    	</div>
				<div>
					<button>立即登录</button>
				</div>
			</form>
		</div>
	</div>
	<footer>
		<div>Copyright &copy; 2017-2018 Azura Inc. All Rights Reserved</div>
	</footer>
</body>
</html>