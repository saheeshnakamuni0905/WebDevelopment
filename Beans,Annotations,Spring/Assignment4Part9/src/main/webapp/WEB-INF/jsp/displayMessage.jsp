<%-- 
    Document   : displayMessage
    Created on : 25-Feb-2024, 11:24:14 am
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 9</title>
    </head>
    <body>
        Message: <span>${requestScope.message}</span></br>
        Object Id: <span>${requestScope.objectId}</span>
    </body>
</html>
