<%-- 
    Document   : addnewmovie
    Created on : 18-Feb-2024, 4:08:55 pm
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
    </head>
    <body>
        <h1>Add Movie</h1>
        <form action="movie_added.htm" method="GET">
            <input type="hidden" name="action" value="submit_add">
            Title: <input type="text" name="title"><br><br>
            Director: <input type="text" name="director"><br><br>
            Genre: <input type="text" name="genre"><br><br>
            Rating: <input type="text" name="rating"><br><br>
            <input type="submit" value="Add Movie">
        </form>
    </body>
</html>
