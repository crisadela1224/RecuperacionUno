<%-- 
    Document   : listar_customer
    Created on : 29/09/2016, 09:49:29 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of customers</title>
    </head>
    <body>
       <table>
            <thead>  
            <tr>
                <th>Id Customere</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" 
                           items="${customers}">
                    <tr>
                        <td>${customer.idCustomer}</td>
                        <td>${customer.name}</td>
                        <td>${customer.address}</td>
                        <td>${customer.phone}</td>
                        <td><a href="CustomerController?action=cambiar&idCustomer=${customer.idCustomer}">Cambiar</a></td>
                        <td><a href="CustomerController?action=borrar&idCustomer=${customer.idCustomer}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="CustomerController?action=agregar">
                New Customer
            </a>
        </p>
    </body>
</html>
