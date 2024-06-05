<%-- 
    Document   : cartPage
    Created on : 25-Feb-2024, 1:22:52 am
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <h3>Items in Your Cart:</h3>
        <c:if test="${cartEmpty}">
            <p>Your cart is empty.</p>
        </c:if>
        <c:if test="${not cartEmpty}">
        <form action="ShoppingCart.htm" method="GET">
            <ul>
                <c:forEach items="${cart}" var="item">
                    <li>
                        <input type="checkbox" name="selectedItems" value="${item}">
                        ${item}
                    </li>
                </c:forEach>
            </ul>
            <input type="hidden" name="click" value="remove">
            <button type="submit">Remove Selected Items</button>
        </form>
    </c:if>
        <a href="index.htm">Continue Shopping</a>
    </body>
</html>
