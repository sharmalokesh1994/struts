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
<title>LocHome|Home</title>
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


<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

{
box-sizing
:
 
border-box
;
}

/* Button used to open the contact form - fixed at the bottom of the page */
/*.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}*/

/* The popup form - hidden by default */
.form-popup {
	display: none;
	position: fixed;
	bottom: 0;
	right: 15px;
	border: 3px solid #f1f1f1;
	z-index: 9;
}

/* Add styles to the form container */
.form-container {
	max-width: 300px;
	padding: 10px;
	background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	border: none;
	background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus
	{
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
	background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}
</style>






</head>
<body>



<script>
	$(document).ready(function(){
		// code to read selected table row cell data (values).
		$(".open-button").on('click',function(){
			 var currentRow=$(this).closest("tr");
			 var col1=currentRow.find("td:eq(0)").html();
			 var col2=currentRow.find("td:eq(1)").html();
			 var col3=currentRow.find("td:eq(2)").html();
			 var data=col1+"\n"+col2+"\n"+col3;
			 //document.getElementById('output').innerHTML = "add to " + col1;
			 
			 document.getElementById('output').value = col1;
			 document.getElementById("myForm").style.display = "block";
		});
	});

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>


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







<div class="form-popup" id="myForm">
  <form action="AddMoneyAction" class="form-container">

	<label><b>Friends Phone No</b></label>
    <input id = "output" type="text" name="friendPhNo" readonly>
	
    <label for="Description"><b>Description</b></label>
    <input type="text" placeholder="Description" name="des" required>

    <label for="psw"><b>money</b></label>
    <input type="text" placeholder="Enter money" name="money" required>

    <label><b>Paid By you</b></label>
	<input type="radio" name="paid" value="self" checked> <br>
	<label><b>Paid By your Friend</b></label>
	<input type="radio" name="paid" value="friend"> <br>
	
	<button type="submit" class="btn">add</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>


	<div class="jumbotron">
		<div class="container text-center">
			<h1>Welcome on ActivityPage</h1>
			<p>My App</p>
		</div>
	</div>

	<div class="container-fluid bg-3 text-center">
		<h3></h3>
		<br>
		<table class="table">
			<thead>
				<tr>
					
					<th scope="col">Friend Phone No</th>
					<th scope="col">Description</th>
					<th scope="col">Balance</th>
					<th scope="col">Date</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="activities" status="rowStatus" var="activitie">
				<tr>
					<td><s:property value="#activitie.friendPhNo" /></td>
					<td>
						<s:property value="#activitie.descrition" />
					</td>
					<td><s:property value="#activitie.balance" /></td>
					<td><s:property value="#activitie.date" /></td>
				</tr>

			</s:iterator>
			</tbody>
		</table>



		<br> <br>

		<div class="jumbotron text-center" style="margin-bottom: 0">
			<p>Footer</p>
		</div>
</body>
</html>
