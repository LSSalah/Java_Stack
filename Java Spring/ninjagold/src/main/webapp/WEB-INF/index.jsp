<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>   
<!DOCTYPE html>
<html lang='en'>

    <head>
        <title>Ninja Gold</title>
        <meta charset='utf-8'>
        <link rel="stylesheet" type="text/css" href='css/ninjagold.css'>
    </head>

    <body>
        <div id='wrapper'>
            <h1>Ninja Gold Game</h1>
            <h3 id="goldcounter">Your Gold: <c:out value="${gold}"/></h3>
            <div id="work">
                <div id="farm">
                    <h3>Farm</h3>
                    <h4>(earns 10-20 gold)</h4>
                    <form action="/process_money" id="farmform" method="POST">
                        <input type="hidden" name="action" value="farm">
                        <input id="farmbutton" name="submit" type="submit" value="Find Gold!">
                    </form>
                </div>
                <div id="cave">
                    <h3>Cave</h3>
                    <h4>(earns 5-10 gold)</h4>
                    <form action="/process_money" id="caveform" method="POST">
                        <input type="hidden" name="action" value="cave">
                        <input id="cavebutton" name="submit" type="submit" value="Find Gold!">
                    </form>
                </div>
                <div id="house">
                    <h3>House</h3>
                    <h4>(earns 2-5 gold)</h4>
                    <form action="/process_money" id="houseform" method="POST">
                        <input type="hidden" name="action" value="house">
                        <input id="housebutton" name="submit" type="submit" value="Find Gold!">
                    </form>

                </div>
                <div id="casino">
                    <h3>Casino</h3>
                    <h4>(earns/takes 0-50 gold)</h4>
                    <form action="/process_money" id="casinoform" method="POST">
                        <input type="hidden" name="action" value="casino">
                        <input id="casinobutton" name="submit" type="submit" value="Find Gold!">
                    </form>
                </div>
            </div>
            <div id="activities">
                <h3>Activities:</h3>
                <ul>
		        <% if(session.getAttribute("activities") != null){ %>
       			<% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities"); %>
       			<% for(int i = 0; i < activities.size(); i++) { %>
       			<% if(activities.get(i).contains("lost")) { %>
       				<li style = "color: red;"><%= activities.get(i) %></li>
       			<% } else { %>
       				<li style = "color: green;"><%= activities.get(i) %></li>
       			<% } %>
       			<% } %>
       			<% } %>
        	</ul>
            </div>
            <div id="reset">
                <h4>Reset:</h4>
                <form action="/reset" id="resetform" method="POST">
                    <input type="hidden" name="action" value="reset">
                    <input id="resetbutton" name="submit" type="submit" value="Reset Game">
                </form>
            </div>
            
        </div>
    </body>
</html>