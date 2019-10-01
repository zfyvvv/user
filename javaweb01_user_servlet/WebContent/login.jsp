<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
<input type="hidden" name="oper" value="login">
用户名：<input type="text" name="uname"/><br/>
密码：<input type="text" name="pwd"/><br/>
<input type="submit" value="submit"/><br/>
</form>
</body>
</html>