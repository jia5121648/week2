<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
1
	<table>
		<tr>
			<th>商品ID</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>已售百分比</th>
		</tr>
		
		<c:forEach items="${list }" var="g">
			<tr>
				<td>${g.id }</td>
				<td>${g.name }</td>
				<td>${g.price }</td>
				<td>${g.baifen }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>