<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
this is showpeople<br/>

<table border="1">
	<c:forEach items="${list}" var="user">
		<tr>
			<td>${user.uid }</td>
			<td>${user.uname }</td>
			<td>${user.pwd }</td>
		</tr>
	</c:forEach>
</table>

<a href='main.jsp'>main</a><br/>
</body>
</html>