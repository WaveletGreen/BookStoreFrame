<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'putinto.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<s:property value="user"/>
<s:property value="cart"/>

	<table>
		<tr>
			<th class="orderId">订单编号</th>
			<th class="userName">收货人</th>
			<th class="price">订单金额</th>
			<th class="createTime">下单时间</th>
			<th class="status">订单状态</th>
			<th class="status">详情</th>
		</tr>
		<s:iterator value="cart" var="cr">
			<tr class="title">
				<td class="thumb"><s:property value="#cr.orderId" /></td>
				<td><s:property value="#cr.orderGetman" /></td>
				<td class="thumb"><s:property value="#cr.orderPrice" /></td>
				<td class="thumb"></td>
				<td class="thumb">${c.orderStatus==0?"已完成":"未完成"}</td>
			</tr>
		</s:iterator>


	</table>
</body>
</html>
