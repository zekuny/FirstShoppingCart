<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>grades</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
.other-color {
	background: lightskyblue
}

.jumbotron h1 {
	color: slategray
}
</style>

<title>Welcome to Tian Mao!</title>
</head>
<body>
	<div class="container">
		<div class="dropdown">
			<button class="btn pull-left btn-info dropdown-toggle" type="button"
				data-toggle="dropdown">
				Login<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="#"></a>
					<div class="container">
						<form action="LoginServlet" method="post"> <!-- The input for email and password goes to the LoginServlet -->
							<div class="form-group">
								<label class="control-label col-sm-5">Username: </label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-5">Password: </label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="password"
										name="password" placeholder="Enter password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-5">
									<center>
										<button type="submit"
											class="btn btn-primary btn-lg btn-block" value="addstudent">Login</button>
									</center>
								</div>
							</div>				
						</form>			
					</div>
				</li>
			</ul>
		</div>
	</div>	

<h2>Create a new account or login then you can shop!!!</h2>
<!-- create a new account -->
	<div class="container">
		<div class="container">
			<div class="jumbotron other-color">
				<center>
					<h1>Create Account</h1>
				</center>
			</div>
		</div>
		<form class="form-horizontal" role="form" action="CreateAccountServlet" method="post">
			<div class="form-group">
				<label class="control-label col-sm-5">User Name :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="username"
						name="username">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="class">Password :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="password" name="password"
						placeholder="at least 6 characters">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-5" for="assignment">Email: </label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="email"
						name="email" placeholder="Example: dasha@gamil.com">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<center>
						<button type="submit" class="btn btn-primary btn-lg btn-block"
							value="addstudent">Create Account</button>
					</center>
				</div>
			</div>
		</form>
	</div>
	
<a href = "index.jsp"><button type="button" class="btn btn-info btn-lg">No I don't want to create account...>>></button></a>
</body>