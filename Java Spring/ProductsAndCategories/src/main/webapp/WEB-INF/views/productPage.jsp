<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="static/css/productPageStyle.css">
<title>Product Page</title>
<style>
	body {
		padding:30px;	
		font-family: Comic Sans MS, Comic Sans, cursive;
	}
	button {
		margin-left: 0px;
		font-size: 12px !important;
		margin-top: 30px;
		width: 105px;
	}
	h2 {
		font-size: 50px;
	}
	h3 {
		margin-top: 0px;
		font-size: 30px;
	}
	form {
		margin-top: 20px;
	}
	form * {
		font-size: 20px;
	}
	ul {
		list-style-type:none;
	}
	ul li {
		font-size:25px;
	}
</style>
</head>
<body>
	<div>
		<h2><c:out value="${product.name}"/></h2>
	</div>
		<div>
			<div style="display: inline-block;">
				<h3>Categories:</h3>
				<ul>
					<c:forEach items="${product.categories}" var="category">
						<li> -  ${category.name} </li>
					</c:forEach> 
				</ul>
			</div>
			<div style="vertical-align:top; display: inline-block; margin-top: 20px; margin-left: 500px;">
				<form:form action="/products/${product.id}" method="POST" modelAttribute="categoryProduct">
					Add a Category: 
					<form:select path="category">
						<c:forEach items="${categories}" var="category">
							<form:option value="${category.id}"> ${category.name} </form:option>
						</c:forEach>
					</form:select>
					<br>
					<button type="submit">Add to Product</button>
				</form:form>
			</div>
		</div>
</body>
</html>