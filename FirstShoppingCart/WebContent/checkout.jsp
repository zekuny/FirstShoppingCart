<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<jsp:include page="header.jsp"/>
<c:if test="${fn:length(cart) > 1}">
   <h1>You have ${fn:length(cart)} items in your shopping cart</h1>
</c:if>
<c:if test="${fn:length(cart) <= 1}">
   <h1>You have ${fn:length(cart)} item in your shopping cart</h1>
</c:if>
<a href = "ConfirmServlet"><button type="button" class="btn pull-left btn-info btn-lg">Continue</button></a><br>

<table class="table table-striped">
	<thead>
	<tr><th>Product</th><th>Price</th><th>Description</th><th>Image</th></tr>
	</thead>
	<tbody>
	<c:forEach items="${sessionScope.cart}" var="product">
	<tr>
		<td><a href = "ProductDetailServlet?pid=<c:out value="${product.getPid()}"></c:out>"><c:out value="${product.getPName()}"></c:out></a></td>
		<td><c:out value="${product.getPrice()}"></c:out></td>
		<td><c:out value="${product.getDescription()}"></c:out></td>
		<td><img src="<c:out value="${product.getImageUrl()}"></c:out>" alt="Product image" style="width: 48px; height: 72px;"></td>
	</tr>
	</c:forEach>
	</tbody>
</table>

<a href = "ProductServlet"><button type="button" class="btn btn-info btn-lg">Back>>></button></a>
<jsp:include page="footer.jsp"/>
</body>

</html>