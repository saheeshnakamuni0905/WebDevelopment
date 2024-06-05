<%-- 
    Document   : MovieSearchedSuccess
    Created on : 18-Feb-2024, 3:57:02 pm
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Found Successfully</title>
    </head>
    <body>
       <h1> Search Results</h1><br><br/>
       <c:forEach var="movie" items="${searchedMovies}">
            <p>Movie Title: <c:out value="${movie.title}" /></p>
            <p>Director: <c:out value="${movie.director}" /></p>
            <p>Genre: <c:out value="${movie.genre}" /></p>
            <p>Rating: <c:out value="${movie.rating}" /></p>
       </c:forEach>
       <br><br/>
        
        <a href="index.html"><- Home page </a>
    </body>
</html>
