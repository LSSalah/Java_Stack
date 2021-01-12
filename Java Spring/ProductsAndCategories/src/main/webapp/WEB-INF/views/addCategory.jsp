<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="static/css/addCategoryStyle.css">
<title>New Category</title>
<style>
	body {
		padding: 30px;	
		font-family: Comic Sans MS, Comic Sans, cursive;
	}
	button {
		margin-left: 68px;
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
	<h2>New Category</h2>
	<br>
	<form:form action="/categories/new" method="POST" modelAttribute="category">
		<p><form:errors path="name"/></p>
		<p><form:label path="name">Name: </form:label></p>
		<p> <form:input path="name" /> </p>
		<br>
		<button type="submit">Add Category</button>
	</form:form>
</body>
</html>