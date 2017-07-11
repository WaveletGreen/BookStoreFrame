<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>${sessionScope.loginedUser.userName}的购物车</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/shoppingCartJs.js"></script>
</head>

<body onload="checkValidate()">
	<div id="header" class="wrap">
		<div id="logo">
			<div class="logo_1">LOGO</div>
			<div class="logo_2">网上书城</div>
		</div>

		<div id="navbar">
			<div class="userMenu">
				<ul>
					<li><a href="servlet/toIndexServlet">首页</a></li>
					<li><a href="servlet/orderServlet">我的订单</a></li>
					<li class="current"><a href="servlet/shoppingCartServlet">${loginedUser.userName}购物车</a>
					</li>
					<li><a href="servlet/logoutServlet">注销</a></li>
				</ul>
			</div>
			<form method="get" name="search" action="servlet/doBookListServlet">
				搜索：<input class="input-text" type="text" name="bookName" value='' /><input
					class="input-btn" type="submit" name="submit" value='' />
			</form>
		</div>
	</div>
	<div id="content" class="wrap">
		<div class="list bookList">
			<form method="post" name="shoping" action="servlet/getOrderServlet">

				<table>
					<s:if test="cart==null">
						<tr>
							<td>您的购物车还没有东西，<a href="servlet/toIndexServlet">继续购物</a>
							</td>
						</tr>
					</s:if>
					<!-- 					<input type="hidden" name="orderStatus" value=1 /> -->
					<%-- 					<input type="hidden" name="userName" value="${loginedUser.userName}" /> --%>
					<tr class="title">
						<th class="view">图片预览</th>
						<th>书名</th>
						<th class="nums">数量</th>
						<th class="price">价格&nbsp;&nbsp;&nbsp;&nbsp;</th>
					</tr>
					<s:iterator value="cart" var="cr" status="status">
						<tr <s:if test="#status%2==0">class="odd"</s:if>>
							<td class="thumb"><img
								src='<s:property value="#cr.bookPhoto" />' /></td>
							<td class="thumb"><s:property value="#cr.bookName" /></td>
							<td class="nums"><s:property value="#cr.number" /></td>
							<td class="price"><s:property value="#cr.price" /></td>
						</tr>
					</s:iterator>
				</table>
				<div class="button">

					<h4>
						<input type="hidden" name="totalCost" id="totalCost" value=0 />总价：￥<span
							id="cost">...</span>元
					</h4>
					<input class="input-chart" type="submit" name="submit" value="" />
				</div>
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">网上书城 &copy; 版权所有</div>

</body>
</html>
