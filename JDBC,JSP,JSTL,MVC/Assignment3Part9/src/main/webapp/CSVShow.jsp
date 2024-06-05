<%-- 
    Document   : CSVShow
    Created on : 18-Feb-2024, 10:11:07 pm
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/tlds/TagFile.tld" prefix="mytag"%> <!-- Assuming TagFile.tld is in the WEB-INF directory -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <mytag:nameCSV csvFileName="parking"/>
    </body>
</html>
