<%-- 
    Document   : MovieSearchedSuccess
    Created on : 18-Feb-2024, 3:57:02 pm
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Found Successfully</title>
    </head>
    <body>
       <h1> Search Results</h1><br><br/>
        <c:if test="${not empty searchedMovie}">
            <p>Movie Title: <c:out value="${searchedMovie.title}" /></p>
            <p>Director: <c:out value="${searchedMovie.director}" /></p>
            <p>Genre: <c:out value="${searchedMovie.genre}" /></p>
            <p>Rating: <c:out value="${searchedMovie.rating}" /></p>
        </c:if>
        <c:if test="${empty searchedMovie}">
            <p>No movie found.</p>
        </c:if>
       <br><br/>
        
        <a href="index.htm"><- Home page </a>
    </body>
</html>
