<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr/>
this is the main.jsp of user!
<hr/>
<br/>

<form action="showone" method="post">
查询用户<br/>
用户名：<input type="text" name="uname"/><br/>
<input type="submit" value="submit"/><br/>
</form>
<hr/>
<form action="show" method="post">
查询所有用户<br/>
<input type="submit" value="submit"/><br/>
</form>
<hr/>
<form action="add" method="post">
增加用户<br/>
用户ID：<input type="text" name="uid"/><br/>
用户名：<input type="text" name="uname"/><br/>
密码：<input type="text" name="pwd"/><br/>
<input type="submit" value="submit"/><br/>
</form>
<hr/>
<form action="del" method="post">
删除用户<br/>
用户ID：<input type="text" name="uid"/><br/>
<input type="submit" value="submit"/><br/>
</form>
<hr/>
<form action="upd" method="post">
修改用户信息<br/>
用户ID：<input type="text" name="uid"/><br/>
用户名：<input type="text" name="uname"/><br/>
密码：<input type="text" name="pwd"/><br/>
<input type="submit" value="submit"/><br/>
</form>
<hr/>
</body>
</html>