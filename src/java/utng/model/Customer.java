/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.model;

/**
 *
 * @author user
 */
public class Customer {
    private int idCustomer;
    private String name;
    private String address;
    private String phone;
    
    public Customer(){
        this(0,"","","");
    }
    public Customer(int idCustomer, String name, String address, String phone){
        this.idCustomer= idCustomer;
        this.name= name;
        this.address = address;
        this.phone= phone;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer + ", name=" + name + ", address=" + address + ", phone=" + phone + '}';
    }
    
}
