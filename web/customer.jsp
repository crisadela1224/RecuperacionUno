<%-- 
    Document   : customers
    Created on : 29/09/2016, 09:48:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
       <form action="CustomerController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>
                
                <div>
                <label for="idCustomer">Id Customer:</label>
                <input type="text" name="idCustomer"
                       value="${customer.idCustomer}"
                       readonly="readonly" 
                       placeholder="Id of customer"/>
                </div>
                
                <div>
                <label for="name">Name:</label>
                <input type="text" name="name"
                       value="${customer.name}"
                       placeholder="Name of customer"/>
                </div>
                 
                <div>
                <label for="address">Address:</label>
                <input type="text" name="address"
                       value="${customer.address}"
                       placeholder="Address"/>
                </div>
                
                <div>
                <label for="phone">Phone:</label>
                <input type="text" name="phone"
                       value="${customer.phone}"
                       placeholder="Phone"/>
                </div>
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>
