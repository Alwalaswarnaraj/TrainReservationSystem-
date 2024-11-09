<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	padding: 10px 20px; 
	font-size: 16px;
	cursor: pointer;
}
input.submit{
	position: absolute;
	/* top: 50%; */
	left: 50%;
	/* transform: translate(-50%, -50%);
	padding: 10px 20px; */
	font-size: 16px;
	cursor: pointer;
}

</style>
</head>
<body>
	<h1 align="center">Train Reservation</h1>
	
	<form action="login" method="post">
		<h3>Enter your user Name: <input type="text" name="name"></h3>
		<h3>Enter your user password: <input type="password" name="password"></h3>
		<input type="submit" value="login">
	</form><br>
	<form action="registration.jsp">
		<button type="submit">register</button>
	</form>

</body>
</html>