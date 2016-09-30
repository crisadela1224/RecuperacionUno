/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.dao;

import java.util.List;
import utng.model.Customer;

/**
 *
 * @author user
 */
public interface CustomerDAO {
    void agregarCustomer(Customer customer);
    void borrarCustomer(int idCustomer);
    void cambiarCustomer(Customer customer);
    List<Customer> desplegarCustomers();
    Customer elegirCustomer(int idCustomer);
}