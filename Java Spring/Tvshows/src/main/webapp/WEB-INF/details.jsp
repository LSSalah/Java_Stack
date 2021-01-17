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
	<div id="top">
		<h1 class="fltleft"><c:out value="${show.title}"/></h1>
		<a class="fltright" href="/logout"><h2>Logout</h2></a>
		<a class="fltright" href="/shows"><h2>Go Back</h2></a>
	</div>
	<hr>
	<div id="container">
		<div id="lftpnl">
			<h3>Added by: <c:out value="${show.user.firstName}"/> <c:out value="${show.user.lastName}"/></h3>
			<h3>Date: <fmt:formatDate pattern ="MMMM dd, yyyy" value ="${show.date}"/></h3>
			<h3>Network: <c:out value="${show.network}"/></h3>
			<h3>People who rated this show: <c:out value="${ratings.size()}"/></h3>
			<table class="table table-striped table-bordered table-hover">
				<thead>
	  				<tr>
	    				<th scope="col">Name</th>
					    <th scope="col">Rating</th>
	  				</tr>
				</thead>
				<tbody>
  					<c:forEach items="${ratings}" var="msg">
		  				<tr>
					    	<td><c:out value="${msg.user.firstName}"/> <c:out value="${msg.user.lastName}"/></td>
                    		<td><c:out value="${msg.rating}"/></td>
						</tr>
						</c:forEach>
				</tbody>
			</table>
		</div>
             <form:form method="post" action="/shows/addrating" modelAttribute="ratingObj">
             	<h5>
             	Leave a Rating
            	<form:input cssClass="txtbox" placeholder="0.0" type="number" path="rating"/>
				</h5>
				<form:hidden path="user" value="${user.id}"/>
				<form:hidden path="show" value="${show.id}"/>
				<input class="btn" type="submit" value="Submit">          
	            </form:form>
            	<form:errors cssClass="red" path="rating.*"/>
		</div>
</body>
</html>