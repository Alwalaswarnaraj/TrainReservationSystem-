<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	form{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	padding: 10px 20px;
	font-size: 16px;
	cursor: pointer;
}
</style>
</head>
<body>
	<h1 align="center" style="font-size: 45px">Train Reservation</h1>
	<form action="register" method="post">
	<h2 style="text-decoration: underline;">Registration</h2>
		<h3>Enter the username        : <input type="input" name="username"></h3>
		<h3>Enter the password        : <input type="password" name="password"></h3>
		<h3>Enter the EmailID         : <input type="email" name="email"></h3>
		<h3>Enter the Role(user/admin):<input type="input" name="role"></h3>
		<input type="submit" value="Register" style="width: 100px; height: 30px; font-size: 20px">
	</form>
</body>
</html>