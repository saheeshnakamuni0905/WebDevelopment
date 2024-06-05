<%-- 
    Document   : InsertBooks
    Created on : 18-Feb-2024, 9:08:52 pm
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Books</title>
    </head>
    <body>

        <%
            String c = request.getParameter("count");
            int count = Integer.valueOf(c);
        %>
        <form action="BookController" method="POST">
            <div>
                <table border="2px solid black" background-color: "aqua">
                    <tr>
                        <th>ISBN</th>
                        <th>Book Title</th>
                        <th>Authors</th>
                        <th>Price</th>
                    </tr>
                    <%for (int i = 0; i < count; i++) {%>
                        <tr>
                            <td><input type="text" name="isbn<%=String.valueOf(i)%>"/></td>
                            <td><input type="text" name="title<%=String.valueOf(i)%>"/></td>
                            <td><input type="text" name="authors<%=String.valueOf(i)%>"/></td>
                            <td><input type="text" name="price<%=String.valueOf(i)%>"/></td>
                        <tr/>
                    <%}%>
                </table>
            </div>
            <div>
                <input type="hidden" name="someVal" value="<%=count%>">
                <input type="submit" name="submit" value="Add">
            </div>
        </form>
                
    </body>
</html>
