/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utng.dao.CustomerDAO;
import utng.dao.CustomerDAOImp;
import utng.model.Customer;

/**
 *
 * @author user
 */
public class CustomerController extends HttpServlet{
   private static final String
           LISTA_CUSTOMERS = "/listar_customer.jsp";
   private static final String 
           AGREGAR_O_CAMBIAR = "customer.jsp";
   private CustomerDAO dao;
   
   public CustomerController(){
       dao = new CustomerDAOImp();
   }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_CUSTOMERS;
            int idCustomer = Integer.parseInt(
                request.getParameter("idCustomer"));
            dao.borrarCustomer(idCustomer);
            request.setAttribute("customers",
                    dao.desplegarCustomers());

         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int idCustomer = Integer.parseInt(
                request.getParameter("idCustomer"));
             Customer customer = 
                     dao.elegirCustomer(idCustomer);
             request.setAttribute("customer", customer);

         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;

         } else{
             forward = LISTA_CUSTOMERS;
             request.setAttribute("customers", 
                     dao.desplegarCustomers());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setAddress(request.getParameter("address"));
        customer.setPhone(request.getParameter("phone"));

        String idCustomer = request.getParameter("idCustomer");
        
        if(idCustomer==null|| idCustomer.isEmpty()||idCustomer.trim().equals("")){
            dao.agregarCustomer(customer);
        }else{
           customer.setIdCustomer(
                    Integer.parseInt(idCustomer));
            dao.cambiarCustomer(customer);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_CUSTOMERS);
        request.setAttribute("customers", 
                dao.desplegarCustomers());
        view.forward(request, response);
    }
}
    
    




