<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojo Page</title>
</head>
<body>
<h1>${dojo.name} Location Ninjas</h1>
<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dojo.ninjas}" var="ninja">
        <tr>
            <td>${ninja.firstName}</td>
            <td>${ninja.lastName}</td>
            <td>${ninja.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/">Back</a>

</body>
</html>
