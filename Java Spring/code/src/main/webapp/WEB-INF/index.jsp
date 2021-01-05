<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Secret Code</title>
	</head>
	<body>
		<h2 style="color:red"><c:out value="${error}"/></h2>
	<h1>What is the code?</h1>
	<form action="/code" method="post">
		<input id="field" type="text" name="code">
		<input id="btn" type="submit" value="Try Code">
	</form>
	</body>
</html>