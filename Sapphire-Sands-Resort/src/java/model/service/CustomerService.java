/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.entity.Customer;
import model.repository.CustomerRepository;

/**
 *
 * @author Admin
 */
public class CustomerService {
    public static void registerCustomer(Customer a) {
        CustomerRepository.registerCustomer(a);
    }
    
    public static Customer getCustomerByID(String id){
        return CustomerRepository.getCustomerByID(id);
    }
}
