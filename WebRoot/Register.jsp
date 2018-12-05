<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/Register.css">
  </head>
<body>
	<div class="head">
		<div></div>
	</div>
	<div class="tab">
		<form action="userAction" method="post">
			<table>
				<tr>
					<td align="right">昵称：</td>
					<td><input type="text" name="name" size="30"></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password" name="password" size="30"></td>
				</tr>
				<tr>
					<td align="right">手机号：</td>
					<td><input type="text" name="phone" size="30"></td>
				</tr>
				<tr>
					<td align="right">性别：</td>
					<td>
						<input type="radio" name="sex" checked value="男">男
						<input type="radio" name="sex" value="女">女
					</td>
				</tr>
				<tr>
					<td align="right">生日：</td>
					<td>
						<input type="date" name="birthday">
					</td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" size="30" name="email"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div>${regist}</div>
						<button>立即注册</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<footer>
		<div>Copyright &copy; 1998-2001 Azura Inc. All Rights Reserved</div>
	</footer>
</body>
</html>
