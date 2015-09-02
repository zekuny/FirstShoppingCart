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

<script>
function validateForm() {
    var x = document.getElementById("username1").value;
    if (x == null || x == "") {
        alert("username must be filled out");
        return false;
    }
    
    var y = document.getElementById("password1").value;
    if (y == null || y == "") {
        alert("password must be filled out");
        return false;
    }
    
    var z = document.getElementById("email1").value;
    if (z == null || z == "") {
        alert("email must be filled out");
        return false;
    }
}

</script>

<jsp:include page="header.jsp"/>
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
		<form class="form-horizontal" role="myForm" action="CreateAccountServlet" onsubmit="return validateForm()" method="post">
			<div class="form-group">
				<label class="control-label col-sm-5">User Name :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="username1"
						name="username">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="class">Password :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="password1" name="password"
						placeholder="at least 6 characters">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-5" for="assignment">Email: </label>
				<div class="col-sm-5">
					<input type="email" class="form-control" id="email1"
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
<jsp:include page="footer.jsp"/>
</body>