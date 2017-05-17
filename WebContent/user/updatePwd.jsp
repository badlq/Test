<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户密码</title>
</head>
<body>
	<form action="../UserUpdate" method="post">
		输入旧密码:<input type="password" name="oldPwd">
		输入新密码:<input type="password" name="newPwd">
		<input type="submit" value="确认提交">
	</form>
</body>
</html>