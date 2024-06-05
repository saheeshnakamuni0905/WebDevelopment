<%-- 
    Document   : groceries
    Created on : 25-Feb-2024, 12:04:02 am
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Groceries</title>
    </head>
    <body>
        <h1>Groceries</h1>
            <a href="index.htm">Home Page</a>            
            <form action = "ShoppingCart.htm" method="GET">
                <input type="checkbox" id="g1" name="items" value="Potatoes">
                    <label for="Potatoes"> Potatoes </label><br>
                    <input type="checkbox" id="g2" name="items" value="Tomatoes">
                    <label for="Tomatoes"> Tomatoes</label><br>
                    <input type="checkbox" id="g3" name="items" value="Cauliflower">
                    <label for="Cauliflower"> Cauliflower </label><br><br>    
                    <input type="hidden" name="groceryList" value="true"/>    
                    <button name="viewCart" value="viewCart">View Cart</button>
                    <button name="addToCart" value="addCart">Add to Cart</button>
            </form>
    </body>
</html>
