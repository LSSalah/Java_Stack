<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<title><c:out value="${show.title}"/></title>
</head>
<body>
	<div id="container">
		<h1><c:out value="${show.title}"/></h1>
		<a class="fltright" href="/logout"><h2>Logout</h2></a>
		<a class="fltright" href="/shows"><h2>Go Back</h2></a>
		
		<div id="lftpnl">
			<h3>Edit Event</h3>
			<form:form method="post" action="/shows/${id}/edit" modelAttribute="show">
				<input type="hidden" name="_method" value="put">
				<h4 class="avoid">
					<form:label path="title">Title:</form:label>
					<form:input cssClass="fields" type="text" path="title"/>
				</h4>
				<h4 class="avoid">
					<form:label path="date">Date:</form:label>
					<form:input cssClass="fields" type="date" path="date"/>
				</h4>
				<h4 class="avoid">
					<form:label path="network">Network:</form:label>
					<form:input cssClass="smfields" type="text" path="network"/>
				</h4>
				<form:hidden path="user" value="${user.id}"/>
				<input class="btn" type="submit" value="Edit"/>
			</form:form>
			<form:errors cssClass="red" path="show.*"/>
		</div>
		<div id="rghtpnl">
		</div>
	</div>
</body>
</html>