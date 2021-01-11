<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yasmeen Muhtaseb
  Date: 1/11/2021
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojo & Ninja</title>
</head>
<body>
<h1>Welcome to our Dojo's App</h1>
<a href="/dojos/new">Add Dojo</a>
<a href="/ninjas/new">Add Ninja</a>
<table>
    <thead>
    <tr>
    <th>Dojo ID</th>
    <th>Dojo Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dojos}" var="dojo">
        <tr>
        <td>${dojo.id}</td>
        <td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
