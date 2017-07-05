<%@page import="util.StringUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'registerSuccess.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<%
	//String loginUser ="当前用户未登录";
	String loginUser = "<a href='/bookStore/jsp/login.jsp'>点击登陆</a>";
	//暂时注释
	// 	if (session.getAttribute("loginedUser") == null
	// 			&& session.getAttribute("tourer") == null) {
	// 		response.sendRedirect("UserFunction_getAllBooks.action");
	// 	}
%>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<div class="logo_1">LOGO</div>
			<div class="logo_2">网上书城</div>
		</div>
		<div id="presentUser" style="margin-left: 70%">
			<c:if test="${not empty sessionScope.loginedUser}">网上书城欢迎您，${sessionScope.loginedUser.userName}</c:if>
			<c:if test="${empty sessionScope.loginedUser}"><%=loginUser%></c:if>
		</div>
		<div id="navbar">
			<div class="userMenu">
				<ul>
					<li class="current"><a href="servlet/doBookListServlet">首页</a>
					</li>
					<li><a href="servlet/orderServlet">我的订单</a></li>
					<li><a href="servlet/shoppingCartServlet">购物车</a></li>
					<li><a href="servlet/logoutServlet">注销</a></li>
				</ul>
			</div>
			<form method="get" name="search" action="UserFunction_getBooksByPage">
				搜索：<input class="input-text" type="text" name="bookName" value='' /><input
					class="input-btn" type="submit" name="submit" value='' />
			</form>
		</div>
	</div>
	<div id="content" class="wrap">
		<div class="list bookList">
			<form method="post" name="shoping" action="servlet/shoppingServlet">
				<table>
					<tr class="title">
						<th class="checker"></th>
						<th>书名</th>
						<th class="price">价格</th>
						<th class="store">库存</th>
						<th class="view">图片预览</th>
					</tr>
					<s:if test="bookLists==null">
						<tr>
							<td colspan="5">没有您要查找的数据</td>
						</tr>
					</s:if>
					<s:else>
						<s:iterator value="bookLists" var="book">
							<tr>
								<td class="title"><input type="checkbox" name="book_id"
									value='<s:property value="bookId" />' /></td>
								<td class="title"><s:property value="bookName" /></td>
								<td><s:property value="bookPrice" /></td>
								<td><s:property value="bookStock" /></td>
								<td class="thumb"><img
									src='<s:property value="bookPhoto" />' /></td>
							</tr>
						</s:iterator>
					</s:else>
					<s:iterator value="bookLists" var="book">
						<tr>
							<td class="title"><input type="checkbox" name="book_id"
								value='<s:property value="bookId"/>' /></td>
							<td class="title"><s:property value="bookName" />
							</td>
							<td><s:property value="bookPrice" /></td>

							<td><input type="hidden" name="amount" value="1" /> <s:property
									value="bookStock" /></td>
							<td class="thumb"><img
								src='<s:property value="bookPhoto" />' /></td>
						</tr>
					</s:iterator>

				</table>
				<div class="page-spliter">
					<a href="servlet/doBookListServlet?pageIndex=1">首页</a>
					<c:if test="${pageIndex!=1}">
						<a href="servlet/doBookListServlet?pageIndex=${prePageIndex }">上一页</a>
					</c:if>
					<c:if test="${pageIndex!= totalPages }">
						<a href="servlet/doBookListServlet?pageIndex=${nextPageIndex }">下一页</a>
					</c:if>
					<a href="servlet/doBookListServlet?pageIndex=${totalPages }">尾页</a>&nbsp;&nbsp;&nbsp;
					<c:if test="${totalPages!=0}">第${pageIndex}页 
				 					/</c:if>
					${totalPages}页
				</div>
				<div class="button">
					<input class="input-btn" type="submit" name="submit" value="" />
				</div>
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">网上书城 &copy; 版权所有</div>
</body>
</html>