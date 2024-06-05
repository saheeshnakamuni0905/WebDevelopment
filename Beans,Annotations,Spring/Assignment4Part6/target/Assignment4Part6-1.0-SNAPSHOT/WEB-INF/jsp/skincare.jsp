<%-- 
    Document   : skincare
    Created on : 25-Feb-2024, 12:06:58 am
    Author     : kamuni.saheeshna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Skincare</title>
    </head>
    <body>
        <h1>Skincare</h1>
            <a href="index.htm">Home Page</a>            
            <form action = "ShoppingCart.htm" method="GET">
                <input type="checkbox" id="item1" name="items" value="Vitamin C">
                        <label for="laptop1">Vitamin C</label><br>
                        <input type="checkbox" id="item2" name="items" value="Niacinamide">
                        <label for="laptop2">Niacinamide </label><br>
                        <input type="checkbox" id="item3" name="items" value="Caffeine Solution">
                        <label for="laptop3">Caffeine Solution</label><br><br>
                        
                        <input type="hidden" name="skincareList" value="1"/>
                        
                        <button name="viewCart" value="viewCart">View Cart</button>
                        <button name="addToCart" value="addCart">Add to Cart</button>
            </form>
    </body>
</html>
