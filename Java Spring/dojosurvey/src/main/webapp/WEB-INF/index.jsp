<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Dojo Survey</title>
    </head>
    <body>
	    <div class=container>
	        <form action="/process" method="POST">
	            <div class="form-group col-lg-6 col-md-4 col-sm-4">
	                <label for="form-group">Name</label>
	                <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Name" name="name">
	            </div>
	            <div class="form-group col-lg-4 col-md-4 col-sm-4">
	                <label for="inputlocation">Locations</label>
	                <select class="form-control" id="location" name="location">
	                    <option value="San Jose">San Jose</option>
	                    <option value="Ramallah">Ramallah</option>
	                    <option value="Los Angeles">Los Angeles</option>
	                    <option value="Nablus">Nablus</option>
	                    <option value="Jenin">Jenin</option>
	                    <option value="Chicago">Chicago</option>
	                    <option value="Bethlahem">Bethlahem</option>
	                    <option value="Hebron">Hebron</option>
	                </select>
	            </div>
	            <div class="form-group col-lg-4 col-md-4 col-sm-4">
	                <label for="inputlocation">Favorite Language</label>
	                <select class="form-control" id="favlanguage" name="favLanguage">
	                <option value="Python">Python</option>
	                <option value="Java">Java</option>
	                <option value="Mern">Mern</option>
	                <option value="other">Other</option>
	                </select>
	            </div>
	            <div class="ml-3 form-group">
	                <label for="exampleFormControlTextarea1">Comments (Optional)</label>
	                <textarea class="form-control col-lg-6 col-md-4 col-sm-4" id="Comments" rows="3" name="comment"></textarea>
	            </div>
	            <button type="submit" class="btn btn-primary" value="Submit">Submit</button>
	        </form>
	     </div>
</body>
</html>