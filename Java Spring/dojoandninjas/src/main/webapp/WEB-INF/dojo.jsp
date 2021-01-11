<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Person</title>
</head>
<body>
<h1>New Dojo</h1>
<form:form action="/dojo" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name">First name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>
<a href="/">Back</a>
</body>
</html>
