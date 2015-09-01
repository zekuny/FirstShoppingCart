<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Welcome to Tian Mao!</title>
</head>
<body>
<% 
if(session.getAttribute("username") == null){%>  <!-- If there is now user then the login button will show -->
<!-- The login is a drop down with a form  -->
<a href = "createProfile.jsp"><button type="button" class="btn pull-left btn-info btn-lg">Create Account</button></a>
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
<!-- Else, the username is displayed and there is an option of viewing your profile and logging out -->
<% }else{ %>
	<div>Welcome <%= session.getAttribute("username") %> <a href = "ProfileServlet"><button>View your profile</button></a><a href = "UserLogoutServlet"><button>Logout</button></a></div>
<%}%>


<div class="container">
	<div class="jumbotron other-color">
		<center>
			 <h1>Welcome to Tian Mao!!</h1>
      			<p>Biggest E-commerce in the world</p>
      			<p><a href="ProductServlet" class="btn btn-success btn-lg">Shop now!</a></p>
      			<img src="images/tianmao.jpg" alt="Tian Mao" >
      			<img src="images/cat.jpg" alt="Cat logo" >
		</center>
	</div>
</div>
</body>
</html>