<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	
</script>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style type="text/css">
@import
	url("https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap")
	;

* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	background-color: #353836;
	color: white;
	font-family: "Poppins", sans-serif;
}

#allhead {
	text-decoration: none;
}

#allhead:hover {
	color: white;
}

header {
	padding: 0 20px;
	background-color: #1d1f1d;
	height: 50px;
	display: flex;
	justify-content: space-between;
	position: sticky;
}

#brand {
	font-weight: bold;
	font-size: 18px;
	display: flex;
	align-items: center;
}

#brand a {
	color: #09c372;
}

.sticky {
	position: fixed;
	top: 0;
	width: 100%
}

ul {
	list-style: none;
	height: 100%;
	display: flex;
	align-items: center;
	justify-content: space-around;
}

ul a {
	color: white;
}

ul li {
	padding: 5px;
	margin-left: 10px;
}

ul li:hover {
	transform: scale(1.1);
	transition: 0.3s;
}

#login, #signup {
	border-radius: 5px;
	padding: 5px 8px;
}

#login {
	border: 1px solid #498afb;
}

#signup {
	border: 1px solid #ff3860;
}

#signup a {
	color: #ff3860;
}

#login a {
	color: #498afb;
}

#hamburger-icon {
	margin: auto 0;
	display: none;
	cursor: pointer;
}

#hamburger-icon div {
	width: 35px;
	height: 3px;
	background-color: white;
	margin: 6px 0;
	transition: 0.4s;
}

.open .bar1 {
	-webkit-transform: rotate(-45deg) translate(-6px, 6px);
	transform: rotate(-45deg) translate(-6px, 6px);
}

.open .bar2 {
	opacity: 0;
}

.open .bar3 {
	-webkit-transform: rotate(45deg) translate(-6px, -8px);
	transform: rotate(45deg) translate(-6px, -8px);
}

.open .mobile-menu {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: flex-start;
}

.mobile-menu {
	display: none;
	position: absolute;
	top: 50px;
	left: 0;
	height: calc(100vh - 50px);
	width: 100%;
	background-color: black;
}

.mobile-menu li {
	margin-bottom: 10px;
}

.mobile-menu a {
	text-decoration: none;
}

@media only screen and (max-width: 600px) {
	header nav {
		display: none;
	}
	#hamburger-icon {
		display: block;
	}
}
</style>
</head>
<body>

	<header class="header" id="myHeader">
		<div id="brand">
			<a href="adminPage">Smart Bank</a>
		</div>
		<nav>
			<ul>
				
				<li><a id="allhead" href="/userHomePage/${cid}/${uid}">Home</a></li>
				<li id="login"><a id="allhead">${uid}</a></li>
				<li id="signup"><a id="allhead" href="/logout">Logout</a></li>
			</ul>
		</nav>
		<div id="hamburger-icon" onclick="toggleMobileMenu(this)">
			<div class="bar1"></div>
			<div class="bar2"></div>
			<div class="bar3"></div>
			<ul class="mobile-menu">
				<li><a href="/userHomePage/${cid}/${uid}">Home</a></li>
				<li id="signup"><a href="/logout">Logout</a></li>
			</ul>
		</div>
	</header>
	<br>
	<br>
	<h3 style="text-align: center;"><b>Account &nbsp; Summary</b></h3>
	
	<div id="brand" style="width: 70%; margin: auto; text-align: center;">
		<nav style="width: 100%;">
		
			<b style="float: right; margin-top: 10px;padding-left: 5px;">Search: <input id="gfg"
				type="text" placeholder="Search here">
			</b>
		</nav>
	</div>
	<table class="table table-dark table-striped"
		style="width: 70%; text-align: center; margin: auto; margin-top: 5px;">
		<thead>
			<tr>
				<th scope="col">Corp-Id</th>
				<th scope="col">Account-Name</th>
				<th scope="col">Branch</th>
				<th scope="col">Avail-Balance</th>
				<th scope="col">Delete Users</th>
			</tr>
		</thead>
		<c:forEach var="row" items="${list}">
			<tbody id="geeks">
				<tr>
					<td>${row.corporateid}</td>
					<td>${row.accountname}</td>
					<td>${row.accountbranch}</td>
					<td>${row.availablebalance}</td>
					<td><a href="/accDetails?cid=${row.corporateid}&accno=${row.accountno}&uid=${uid}&cid=${cid}"style="color: #ff3860;">View Details</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>


	<script type="text/javascript">
		function toggleMobileMenu(menu) {
			menu.classList.toggle('open');
		}
		window.onscroll = function() {
			myFunction()
		};

		// Get the header
		var header = document.getElementById("myHeader");

		// Get the offset position of the navbar
		var sticky = header.offsetTop;

		// Add the sticky class to the header when you reach its scroll position. Remove "sticky" when you leave the scroll position
		function myFunction() {
			if (window.pageYOffset > sticky) {
				header.classList.add("sticky");
			} else {
				header.classList.remove("sticky");
			}
		}
		
		function preventBack() {window.history.forward(); }  
		setTimeout("preventBack()", 0);  
		window.onunload = function () {null};
		//search code

		 $(document).ready(function() {
                $("#gfg").on("keyup", function() {
                    var value = $(this).val().toLowerCase();
                    $("#geeks tr").filter(function() {
                        $(this).toggle($(this).text()
                        .toLowerCase().indexOf(value) > -1)
                    });
                });
            });
		
	</script>
</body>
</html>