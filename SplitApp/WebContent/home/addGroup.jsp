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
<title>LocHome|Add Group</title>
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




<script type="text/javascript">
$(document).ready(function(){
    var maxField = 10; //Input fields increment limitation
    var addButton = $('.add_button'); //Add button selector
    var wrapper = $('.field_wrapper'); //Input field wrapper
    var x = 1; //Initial field counter is 1
    //var fieldHTML = '<div><br><input type="text" name="friendPhNo['+x+']" required><a href="javascript:void(0);" class="remove_button"><img src="./image/remove-icon.png" style="width:20px;"/></a></div>'; //New input field html 
    
    
    //Once add button is clicked
    $(addButton).click(function(){
        //Check maximum number of input fields
        if(x < maxField){ 
            
            var fieldHTML = '<div><br><input type="text" name="friendPhNo['+x+']" required><a href="javascript:void(0);" class="remove_button"><img src="./image/remove-icon.png" style="width:20px;"/></a></div>'; //New input field html 
            x++; //Increment field counter
            $(wrapper).append(fieldHTML); //Add field html
        }
    });
    
    //Once remove button is clicked
    $(wrapper).on('click', '.remove_button', function(e){
        e.preventDefault();
        $(this).parent('div').remove(); //Remove field html
        x--; //Decrement field counter
    });
});
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
			
			
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="AddGroupAction">Add New
						Group</a></li>
			</ul>

		</div>



		<div class="nav navbar-nav navbar-right">
			<a href="LogoutAction">Logout</a>
		</div>

	</nav>


<div role="alert">
		<s:if test="hasActionErrors()">
			<s:actionerror />
		</s:if>
	</div>


	<div class="jumbotron">
		<div class="container text-center">
			<h1>Add Group</h1>
			<p>My App</p>
		</div>
	</div>

	<div class="container-fluid bg-3 text-center">
		<h3>Add Group</h3>
		<br>

		<form action="AddFriendInGroupAction" class="form-container">
		
		<label><b>Group Name</b></label><br> <input type="text"
				name="groupName" required> <br> <br>

			<label><b>Friend Phone No</b></label><br> 
			
			<div class="field_wrapper">
					<input type="text" name="friendPhNo[0]" required>
						<a href="javascript:void(0);" class="add_button" title="Add field"><img src="./image/add-icon.png" style="width:20px;"/></a>
						
			</div>
				 <br> <br>
			<button type="submit" value="Add Friend">Add Friend</button>
		</form>



		<br> <br>

		<div class="jumbotron text-center" style="margin-bottom: 0">
			<p>Footer</p>
		</div>
</body>
</html>
