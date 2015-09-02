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
	
<link rel="stylesheet" href="jquery.rating.css">
<script src="jquery.rating.js"></script>
	
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
<jsp:include page="header.jsp"/>
<%
String pid = request.getParameter("pid");
%>
<div class="container">
	<div class="container">
		<div class="jumbotron other-color">
			<center>
				<h1>Add review</h1>
			</center>
		</div>
	</div>

	<form class="form-horizontal" role="form" action="createReviewServlet"
		method="post">
		<div class="form-group">
			<label class="control-label col-sm-5" for="class">Review: 
				</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="review" name="review">
				<input type="hidden" class="form-control" id="pid" name="pid" value="<%=pid%>">
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-5" for="class">Date: 
				</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="reviewdate" name="reviewdate">
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-5" for="class">Rating: 
				</label>
			<div class="col-sm-5">
				<input type="radio" name="rating" value="1" class="star">
           		<input type="radio" name="rating" value="2" class="star">
            	<input type="radio" name="rating" value="3" class="star" checked>
            	<input type="radio" name="rating" value="4" class="star">
            	<input type="radio" name="rating" value="5" class="star">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<center>
					<button type="submit" class="btn btn-primary btn-lg btn-block"
						value="addView">Submit</button>
				</center>
			</div>
		</div>
		

	</form>
</div>	
<jsp:include page="footer.jsp"/>
</body>	
</html>	
		
		