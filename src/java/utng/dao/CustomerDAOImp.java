/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Customer;
import utng.util.UtilDB;

/**
 *
 * @author user
 */
public class CustomerDAOImp  implements CustomerDAO{
    private Connection connection;
    
    public CustomerDAOImp(){
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarCustomer(Customer customer) {
        try{
            String query = "INSERT INTO customers (name, address, "
                  + " phone) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getPhone());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
        e.printStackTrace();
    }
    }

    @Override
    public void borrarCustomer(int idCustomer) {
        try {
             String query = "DELETE FROM customers WHERE id_customer = ?";
             PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, idCustomer);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarCustomer(Customer customer) {
        try {
          String query = "UPDATE customers SET name = ?, "
                  + " address= ?, phone=? WHERE "
                  + " id_customer= ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getPhone());
            ps.setInt(4, customer.getIdCustomer());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Customer> desplegarCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM customers");
            while (resultSet.next()) {
              Customer customer = new Customer(
              resultSet.getInt("id_customer"),
              resultSet.getString("name"),
              resultSet.getString("address"),
              resultSet.getString("phone"));
              customers.add(customer);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer elegirCustomer(int idCustomer) {
     
    
     Customer customer = new Customer();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM customers WHERE "
                                + " id_customer = ?");
        statement.setInt(1, idCustomer);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              customer.setIdCustomer(
                      resultSet.getInt("id_customer"));
              customer.setName(
                      resultSet.getString("name"));
              customer.setAddress(
                      resultSet.getString("address"));
              customer.setPhone(
                      resultSet.getString("phone"));
   
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customer;
    }
    
    
}
    
    
    

    

