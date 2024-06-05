<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <div class="container">
            <div class="left">
                <br>
                <h1>Shopping Cart</h1>
                    <ol>                          
                        <li><a href="#groceries">Groceries </a></li>
                        <li><a href="#skincare">Skin Care </a></li>
                    </ol>
            </div>
            <div class="right">
                <div id = groceries class="groceries-container"> 
                    <br><br>
                    <h1>Cart Items</h1>
                    <h1>Groceries</h1>
                   
                    <form action = "ShoppingCart.htm" method="GET">
                        
                        <input type="checkbox" id="g1" name="items" value="Potatoes">
                        <label for="Potatoes"> Potatoes </label><br>
                        
                        <input type="checkbox" id="g2" name="items" value="Tomatoes">
                        <label for="Tomatoes"> Tomatoes</label><br>
                        
                        <input type="checkbox" id="g3" name="items" value="Cauliflower">
                        <label for="Cauliflower"> Cauliflower </label><br><br>
                        
                        <input type="hidden" name="groceryList" value="true"/>
                        
                        <button name="click" value="viewCart">View Cart</button>
                        
                        <button name="click" value="addCart">Add to Cart</button>

                    </form>
                </div>
                <div id="skincare" class="skincare-container">
                    <br><br>
                    <h1>Cart Items</h1>
                    <h1>Skin care</h1>
 
                    <form action = "ShoppingCart.htm" method="GET">
                        <input type="checkbox" id="item1" name="items" value="Vitamin C">
                        <label for="laptop1">Vitamin C</label><br>
                        
                        <input type="checkbox" id="item2" name="items" value="Niacinamide">
                        <label for="laptop2"> Niacinamide </label><br>
                        
                        <input type="checkbox" id="item3" name="items" value="Caffeine Solution">
                        <label for="laptop3">Caffeine Solution</label><br><br>
                        
                        <input type="hidden" name="laptopClick" value="1"/>
                        
                        <button name="click" value="viewCart">View Cart</button>
                        
                        <button name="click" value="addCart">Add to Cart</button>
                    </form>
                </div>
            </div>
        </div>
       
    </body>
</html>
