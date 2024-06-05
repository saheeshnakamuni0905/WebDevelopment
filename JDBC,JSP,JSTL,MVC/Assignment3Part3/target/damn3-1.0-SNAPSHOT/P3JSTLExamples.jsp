<%-- 
    Document   : P3JSTLExamples
    Created on : 18-Feb-2024, 10:22:12 am
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<fmt:setBundle basename="messages"/>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Examples</title>
    </head>
    <body>
        <h1 style="font-style:italic; color: violet">Assignment 3 - Part 3</h1>
        
        <h2 style="color: blue">JSTL Formatting Tags</h2>
        
        <fmt:formatNumber value="8934.213" var="formattedNumber" maxFractionDigits="2"/>
        <p>Formatted Number: ${formattedNumber}</p>
        
        <fmt:parseDate value="2000-05-09" pattern="yyyy-MM-dd" var="parsedDate"/>
        <p>Parsed Date: ${parsedDate}</p>
        
        <fmt:formatDate value="${parsedDate}" pattern="dd MMMM yyyy" var="formattedDate"/>
        <p>Formatted Date: ${formattedDate}</p>
        
        <fmt:setLocale value="fr" scope="session"/>
        
        <fmt:formatNumber value="2.898" type="percent" var="percent"/>
        <p>Percentage: ${percent}</p>
    
    <h2 style="color: green">JSTL Function Tags</h2>  
        <c:set var="str" value = "Hello, Saheeshna Kamuni!"/>
        <p>Length of string: <c:out value = "${fn:length(str)}"/></p>
        
        <p>Uppercase: ${fn:toUpperCase(str)}</p>
        <p>Lowercase: ${fn:toLowerCase(str)}</p>
     
        <p>Replace function: ${fn:replace(str, "Hello", "Good Morning")}</p>

       
        <h2 style="color: red">JSTL Core Tag</h2>
        
        <c:set var="sentence" value="apple,banana,orange,grape" />

        <c:forTokens var="fruit" items="${sentence}" delims=",">
            <c:out value="${fruit}" /><br/>
        </c:forTokens>
            
        <c:catch var="error">
            <% int result = 10 / 0; %>
        </c:catch>

        <c:if test="${not empty error}">
            <p>Error Message: ${error}</p>
        </c:if>
   
        <c:set var="dayOfWeek" value="Saturday" />
        <c:choose>
            <c:when test="${dayOfWeek == 'Monday'}">
                <p>It's Monday!</p>
            </c:when>
            <c:when test="${dayOfWeek == 'Friday'}">
                <p>It's Friday!</p>
            </c:when>
            <c:otherwise>
                <p>It's neither Monday nor Friday.</p>
            </c:otherwise>
        </c:choose>
                
                

                
    <h2 style="color: orange">JSTL XML Tags</h2>
        <c:set var="booksList">
            <books>
                <book>
                    <title>It ends with us</title>
                    <author>Colleen Hoover</author>
                </book>
                <book>
                    <title>The Nightingale</title>
                    <author>Kristin Hannah</author>
                </book>
                <book>
                    <title>The Book Thief</title>
                    <author>Markus Zusak</author>
                </book>
                <book>
                    <title>Dark Matter</title>
                    <author>Blake Crouch</author>
                </book>
            </books>
        </c:set>
    
        <x:parse xml="${booksList}" var="output"/>
            <p>Author of The Nightingale: <x:out select="$output/books/book[2]/author" /><br></p>
            <p>Author of It ends with us: <x:out select="$output/books/book[1]/author" /><br></p>
            <p>Author of Dark Matter: <x:out select="$output/books/book[4]/author" /><br></p>
        <x:choose>
            <x:when select="$output/books/book[3]/author = 'Markus Zusak'">
                Books by Markus Zusak: <x:out select="$output/books/book[3]/title" /><br/>
            </x:when>
            <x:when select="$output/books/book[4]/author = 'Blake Crouch'">
                Books by Blake Crouch: <x:out select="$output/books/book[4]/title" /><br/>
            </x:when>
            <x:otherwise>
                404 not found
            </x:otherwise>
        </x:choose>
                
    </body>
</html>
