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
<title>TV Shows</title>
</head>
<body>
	<div id="container">
		<h1 class="fltleft">Welcome, <c:out value="${user.firstName}"/></h1>
		<a class="fltright" href="/logout"><h2>Logout</h2></a>
		<hr>
		<h2>TV Shows</h2>
		<c:if test="${shows.size() == 0}"><h5>There are currently no shows in your area...</h5></c:if>
        <c:if test="${shows.size() > 0}">
			<table class="table table-striped table-bordered table-hover">
				<thead>
	  				<tr>
	    				<th scope="col">Title</th>
					    <th scope="col">Date</th>
					    <th scope="col">Network</th>
					    <th scope="col">Action/Status</th>
	  				</tr>
				</thead>
				<tbody>
					<c:forEach items="${shows}" var="in">
	  				<tr>
	  					<td><a href="/shows/${in.id}"><c:out value="${in.title}"/></a></td>
					    <td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${in.date}"/></td>
					    <td><c:out value="${in.network}"/></td>
                        <c:choose>
                        <c:when test="${in.user == user}">
                            <td><a href="/shows/${in.id}/edit">Edit</a> | <a href="shows/${in.id}/delete">Delete</a></td>
                        </c:when>
                        <c:otherwise>
                            <c:set var="attending" value="${false}"/>
                            <c:forEach items="${in.getJoinedUsers()}" var="attendee">
                                <c:if test="${attendee == user}">
                                    <c:set var="attending" value="${true}"/>
                                </c:if>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${attending == false}">
                                    <td><a href="/shows/${in.id}/rate">Rate</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td>*Rated*</td>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                        </c:choose>  
	  				</tr>
	  				</c:forEach>
				</tbody>
			</table>
		</c:if>
		<div id="rghtpnl">
			<button><a href="/shows/add">Add a Show</a></button>
		</div>
	</div>
</body>
</html>