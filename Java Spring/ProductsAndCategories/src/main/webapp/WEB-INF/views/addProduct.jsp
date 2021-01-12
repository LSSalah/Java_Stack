<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="static/css/addProductStyle.css">
<title>New Product</title>
<style>
	body {
		padding: 30px;	
		font-family: Comic Sans MS, Comic Sans, cursive;
	}
	button {
		margin-left: 119px;
	}
	h2 {
		margin-top: 0px;
		font-size: 50px;
	}
	form * {
		font-size: 20px;
	}
	p {
		display:inline-block;
	}
</style>
</head>
<body>
	<h2>New Product</h2>
	<br>
	<form:form action="/products/new" method="POST" modelAttribute="product">
		<div style="margin-bottom:30px;">
			<form:errors path="name"/>
			<p><form:label path="name">Name: </form:label></p>
			<form:input style="margin-left:54px; width:235px;" path="name" />
		</div>
		<div>
			<form:errors path="description" />
			<p><form:label path="description">Description: </form:label></p>
			<form:textarea path="description" />
		</div>
		<div class="input3">
			<form:errors path="price"/>
			<p><form:label path="price">Price: </form:label></p>
			<form:input style="margin-left:60px; width:235px;" path="price" />
		</div>
		<button type="submit">Add Product</button>	
	</form:form>
</body>
</html>