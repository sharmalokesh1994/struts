<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%  
response.setHeader("Cache-Control","no-store"); //HTTP 1.1  
response.setHeader("Pragma","no-cache"); //HTTP 1.0  
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%> 

<html>

<head>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./CSS/login.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!--<script src="./JS/bootStrap.js"></script>
<script src="./JS/jquery.js"></script>-->

<title>LocHome|Login</title>
</head>

<body>

	<div role="alert">
		<s:if test="hasActionErrors()">
			<s:actionerror />
		</s:if>
	</div>
	<div class="container register">
		<div class="row">

			<div class="col-md-12 register-right">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">


						<div class="col-md-5 login">

							<div class="login-form">
								<p>Login</p>
								<s:form action="LoginAction">
									<div class="form-group">
										<input type="text" class="form-control" name="phNo" placeholder="Phone No *"
											value="" />
									</div>
									<div class="form-group">
										<input type="password" class="form-control" name="pass"
											placeholder="Password *" value="" />
									</div>

									<input type="submit" class="btnRegister" value="Login" />

								</s:form>

							</div>

						</div>



						<div class="col-md-5 sign-up">
							<!--<h3 class="register-heading">Register Here</h3>-->
							<div class="register-form">
								<p>Register Here</p>
								<s:form action="SignupAction">
									<div class="form-group">
										<input type="text" class="form-control" name="fName" required="required"
											placeholder="First Name *" value="" />
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="lName"
											placeholder="Last Name *" value="" />
									</div>
									<div class="form-group">
										<input type="password" class="form-control" name="pass"
											placeholder="Password *" value="" />
									</div>
									<div class="form-group">
										<input type="password" class="form-control" name="cnfPass"
											placeholder="Confirm Password *" value="" />
									</div>

									<div class="form-group">
										<input type="email" class="form-control" name="email"
											placeholder="Your Email *" value="" />
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="phNo"
											placeholder="Phone No *" value="" required="required"/>
									</div>
									<input type="submit" class="btnRegister" value="Register" />

								</s:form>

							</div>

						</div>


					</div>


				</div>
			</div>
		</div>

	</div>

</body>


</html>