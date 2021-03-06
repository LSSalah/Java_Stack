<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Result</title>
        
    </head>
    <body>
        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading">Thanks!</h4>
        </div>
        <h1 class="h1"><u>Submitted Info</u></h1>
        <h4 class="display4">Name: <c:out value="${name}"/></h4>
        <h4 class="display4">Dojo Location: <c:out value="${location}"/></h4>
        <h4 class="display4">Favorite Language: <c:out value="${favLanguage}"/></h4>
        <h4 class="display4">Comments: <c:out value="${comment}"/></h4>
        <a href="/"><button type="button" class="btn btn-primary">Go back</button></a>
    </body>
</html>