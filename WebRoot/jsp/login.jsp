<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/user.css">
<script type="text/javascript" src="js/jQuery/jquery-3.2.1.slim.js"></script>
<script type="text/javascript" src="js/ck_login.js"></script>
</head>

<body>
	<div id="header" class="wrap">
		<div id="logo">
			<div class="logo_1">LOGO</div>
			<div class="logo_2">网上书城</div>
		</div>
		<div id="navbar">
			<form method="get" name="search" action="UserFunction_login.action">
				搜索：<input class="input-text" type="text" name="bookName" value='' /><input
					class="input-btn" type="submit" name="submit" value='' />
			</form>
		</div>
	</div>
	<div id="login">
		<h2>用户登陆</h2>
		<form method="post" action="fancUserFunction_login.action"
			id="loginForm">
			<dl>
				<dt>用户名：</dt>
				<dd>
					<input class="input-text" type="text" name="user.userName"
						id="loginNameId" onfocus="change();" /><span id="spUserName"
						class="removeLoginRemind">请输入用户名</span>
				<dt>密 码：</dt>
				<dd>
					<input class="input-text" type="password" name="user.password"
						id="loginPassword" onfocus="change();" /><span id="spPassword"
						class="removeLoginRemind">请输入密码</span>
				<dt></dt>
				<dd class="button">
					<input class="input-btn" type="submit" name="submit" value="" /> <input
						class="input-reg" type="button" name="register" value=""
						onclick="window.location='/BookStoreFrame/jsp/register.jsp';" />
				</dd>
			</dl>
			<div id="errorMsg">
				<s:fielderror value="errorMsg" />
			</div>
		</form>
	</div>
	<div id="footer" class="wrap">网上书城 &copy; 版权所有</div>
</body>
</html>
