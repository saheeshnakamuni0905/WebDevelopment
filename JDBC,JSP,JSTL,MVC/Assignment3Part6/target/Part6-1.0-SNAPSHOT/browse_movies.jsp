<%-- 
    Document   : browse_movies.jsp
    Created on : 18-Feb-2024, 3:49:25 pm
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Movie</title>
    </head>
    <body>
        <h1>Searching Movies</h1><br>
        <form action= "MovieServlet"  method= "post">
            <label>Keyword :</label>
            <input type="text" name= "inputText"><br /><br/>
            <input type="radio" name= "category" value ="title">Search By Title <br><br/>
            <input type="radio" name= "category" value ="genre">Search By Genre <br><br/>
            <input type="radio" name= "category" value ="director">Search By Director <br><br/>
            <input type='hidden' name='action' value='searchMovie'>
            <input align ="center" type= "submit" value= "Search Movie" >
        </form>
    </body>
</html>
