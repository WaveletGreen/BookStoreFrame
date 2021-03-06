<%@page import="util.StringUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
<script type="text/javascript" src="js/jQuery/jquery-3.2.1.slim.js"></script>
<script type="text/javascript" src="js/order.js"></script>

<script type="text/javascript">
// 	$(function() {
// 		$("#toOrderForm").submit(function() {
// 			alert($("[name='book_id']"));
// 			$("[name='book_id']").each(function() {
// 				alert($(this).val());
// 			});
// 			return false;
// 		});

// 	});
</script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<div class="logo_1">LOGO</div>
			<div class="logo_2">网上书城</div>
		</div>
		<div id="presentUser" style="margin-left: 70%">
			<s:if test="user!=null">网上书城欢迎您，<s:property
					value="user.userName" />
			</s:if>
			<s:else>
				<a href='/BookStoreFrame/jsp/login.jsp'>点击登陆</a>
			</s:else>
		</div>
		<div id="navbar">
			<div class="userMenu">
				<ul>
					<li class="current"><a href="fancUserFunction_search.action">首页</a>
					</li>
					<li><a href="servlet/orderServlet">我的订单</a></li>
					<li><a
						href='fancOrderFunction_getUserCart.action?user.userName=<s:property value="user.userName"/>'>购物车</a></li>
					<li><a href="globalGlobal_logout">注销</a></li>
				</ul>
			</div>
			<form method="get" name="search"
				action="fancUserFunction_search.action">
				搜索：<input class="input-text" type="text" name="searchBookName"
					value='' /><input class="input-btn" type="submit" name="submit"
					value='' />
			</form>
		</div>
	</div>
	<div id="content" class="wrap">
		<div class="list bookList">
			<form method="get" name="shoping"
				action="fancOrderFunction_putIntoUserCart" id="toOrderForm">
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
				</table>
				<div class="page-spliter">
					<a href="fancUserFunction_search.action?page.pageIndex=1">首页</a>
					<s:if test="page.prePageIndex!=page.pageIndex">
						<a
							href='fancUserFunction_search.action?page.pageIndex=<s:property value="page.prePageIndex"/>'>上一页</a>
					</s:if>
					<s:if test="page.nextPageIndex!=page.pageIndex">
						<a
							href='fancUserFunction_search.action?page.pageIndex=<s:property value="page.nextPageIndex"/>'>下一页</a>
					</s:if>
					<a
						href='fancUserFunction_search.action?page.pageIndex=<s:property value="page.totalPages"/>'>尾页</a>&nbsp;&nbsp;&nbsp;
					第
					<s:property value="page.pageIndex" />
					页 /
					<s:property value="page.totalPages" />
					页

				</div>
				<div class="button">
					<input class="input-btn" type="submit" name="submit" value="" />
				</div>
				<input type="hidden" name="user.userName"
					value="<s:property value="user.userName"/>" /> <input
					type="hidden" value="1" name="buyNum" />
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">网上书城 &copy; 版权所有</div>
</body>
</html>