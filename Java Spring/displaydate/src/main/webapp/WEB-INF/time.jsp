<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Time</title>
		<script><%@include file="/WEB-INF/js/script.js"%></script>
		<style><%@include file="/WEB-INF/css/style.css"%></style>	
	</head>
	</head>
	<body onload="time()">
	<div class="time">
		<h1><c:out value="${time}"/></h1> 
		</div> 
	</body>
</html>