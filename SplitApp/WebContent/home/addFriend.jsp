<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%  
response.setHeader("Cache-Control","no-store"); //HTTP 1.1  
response.setHeader("Pragma","no-cache"); //HTTP 1.0  
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%> 

<!DOCTYPE html>
<html lang="en">
<head>
<title>LocHome|Add Friend</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>



	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="HomeAction">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="AddFriendAction">Add New
						Friend</a></li>
			</ul>

			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="ActivityAction">Activity</a>
				</li>
			</ul>


			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="ContectAction">Contact
						Us</a></li>
			</ul>

		</div>



		<div class="nav navbar-nav navbar-right">
			<a href="LogoutAction">Logout</a>
		</div>

	</nav>




	<div class="jumbotron">
		<div class="container text-center">
			<h1>Welcome on Contact Us Page</h1>
			<p>My App</p>
		</div>
	</div>

<div role="alert">
		<s:if test="hasActionErrors()">
			<s:actionerror />
		</s:if>
	</div>

	<div class="container-fluid bg-3 text-center">
		<h3>Add Friend</h3>
		<br>

	
	
		<form action="AddNewFrienddAction" class="form-container">

			<label><b>Friend Phone No</b></label><br> <input type="text"
				name="friendPhNo" required> <br> <br>
			<button type="submit" value="Add Friend">Add Friend</button>
		</form>



		<br> <br>

		<div class="jumbotron text-center" style="margin-bottom: 0">
			<p>Footer</p>
		</div>
</body>
</html>
