<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

   <body>
    <h1>Welcome to our Movie Store</h1>
        <h4>Make your selection below</h4>
        <form action="movie.htm" method="GET">
            <select name="action">
                <option value="search_movie">Browse Movies</option>
                <option value="add_movie">Add New Movie to Database</option>
            </select><br/><br/>
            <input type="submit" value="Confirm" >
        </form>
    </body>
</html>
