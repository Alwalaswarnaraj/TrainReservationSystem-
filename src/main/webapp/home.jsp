<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
button {
	position: absolute;
	/* top: 50%; */
	left: 50%;
	/*  transform: translate(-50%, -50%);
            padding: 10px 20px; */
	font-size: 16px;
	cursor: pointer;
}
</style>
<!-- <link rel="stylesheet" href="cs/homeStyle.css"> -->
</head>
<body>
	<h1 align="center">Train Reservation</h1>

	
	<div>

		<form action="trainavailable" method="post">
			<h4 align="center">
				Enter source:<input type="text" name="source"> to Enter
				Destination: <input type="text" name="destination">
			</h4>
			<button type="submit">submit</button>
			<!-- <input type="submit" value="submit"> -->
		</form>
	</div>
	  <!-- <script src="homeScript.js"></script> -->
</body>
</html>