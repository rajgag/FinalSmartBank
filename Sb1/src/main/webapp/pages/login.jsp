<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style type="text/css">
body{
	background: url(pages/137906.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
.error {
    color: yellow;
    font-style: normal;
}

#btn {
	width: 110px;
	border: none;
	border-radius: 10px;
	background-color: black;
	color: white;
}

#btn:hover {
	background-color: white;
	color: black;
	cursor: pointer;
}

#anchor:hover {
	color: black;
	cursor: pointer;
}
</style>
</head>
<body>
	
	<%            
  response.setHeader("pragma", "no-cache");            
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");           
  response.setHeader("Expires", "0");
	%>
	 <%request.getSession().setAttribute("user", null);%>
	<div
		style="background-color:black; text-align: center; width: 50%; margin: auto; height: 420px; margin-top: 100px; border-radius: 10px; padding-top: 90px;opacity: 0.75;">
		<h2 style="color: white">Admin Login</h2>
		<br>
		
		 
		<form:form action="login" method="post" modelAttribute="user">
			<h6 style="color: red">${errorMessge}</h6>><br>
			<form:label path="username" cssStyle="color:white">
				<b>Login-Id:&nbsp;</b>
			</form:label>
			<form:input path="username" />
			<form:errors path="username" cssClass="error"/>
			<br>
			<br>
			<form:label path="password" cssStyle="color:white">
				<b>Password:</b>
			</form:label>
			<form:password path="password" />
			<form:errors path="password" cssClass="error"/>

			<br>
			<br>

			<form:button type="submit" id="btn">
				<b>Login</b>
			</form:button>
		</form:form>
		<br>
		<button id="btn">
			<a href="/user" id="anchor" style="text-decoration: none;"><b>User
					Login</b></a>
		</button>
	</div>
	
	<script type="text/javascript">
	
	function preventBack() {window.history.forward(); }  
	setTimeout("preventBack()", 0);  
	window.onunload = function () {null};  
	</script>

</body>
</html>