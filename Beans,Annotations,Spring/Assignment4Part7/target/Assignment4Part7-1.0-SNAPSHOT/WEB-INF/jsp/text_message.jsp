<%-- 
    Document   : text_message
    Created on : 25-Feb-2024, 2:09:18 am
    Author     : kamuni saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Message</title>
    </head>
    <body>
        Message: <span>${requestScope.message}</span></br>
        Object Id: <span>${requestScope.objectId}</span>
    </body>
</html>
