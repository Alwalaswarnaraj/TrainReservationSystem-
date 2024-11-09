<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Train Reservation</title>
<link href="styles.css" rel="stylesheet">
<style type="text/css">
/* Main page styling */

#submit{
	position: absolute;
    left: 50%;
    transform: translateX(-50%);
    font-size: 16px;
    cursor: pointer;
}

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

h1 {
    text-align: center;
    color: green;
}

input[type="text"] {
    width: 200px; /* Set the desired width */
    height: 20px; /* Set the desired height */
    padding: 1px; /* Optional: Adds space inside the input box */
    /* font-size: 1px; /* Optional: Increases the font size */ */
}


    .button-container {
        
        justify-content: left;
        margin-left: 10px;
        margin-top: 10px; /* Optional: Adds some space above the button */
    }
	
	.button-container a{
		text-decoration: none;
		padding-top:20px;
		
		font-size: 20px;
	}

</style>
</head>
<body>
    <h1>Train Reservation</h1>

    <div>
        <form action="trainavailable" method="post">
            <h4 align="center">
                Enter source: <input type="text" name="source"> to Enter Destination: <input type="text" name="destination">
            </h4>
            <button type="submit" value="submit" id='submit'>submit</button>
        </form>
    </div>

    <!-- Open Side Panel Button -->
    <button class="open-btn" onclick="openPanel()">Open Panel</button>

    <!-- Side Panel -->
    <div id="mySidePanel" class="side-panel">
        <a href="javascript:void(0)" class="close-btn" onclick="closePanel()">&times;</a>
        <%
        
        
		HttpSession ses = request.getSession(false);
		String name = (String) ses.getAttribute("name");
		%>
		<h1><%=name%></h1>
		
		<div class="button-container">
		<a href="#">check reservations</a> <br>
		</div>
		<div class="button-container">
		<a href="#">change password</a><br>
		</div>
		<div class="button-container">
		<a href="#">update userName</a> <br>
		</div>
		<div class="button-container">
			<a href="#">change password</a><br>
		</div>
    </div>

    <script>
        function openPanel() {
            document.getElementById("mySidePanel").style.width = "300px";
        }

        function closePanel() {
            document.getElementById("mySidePanel").style.width = "0";
        }
    </script>
</body>
</html>
