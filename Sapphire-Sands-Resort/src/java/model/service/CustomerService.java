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
    public static Customer login(String username, String password){
        return CustomerRepository.login(username, password);
    }
    
    public static void registerCustomer(Customer a) {
        CustomerRepository.registerCustomer(a);
    }
    
    public static Customer getCustomerByID(String id){
        return CustomerRepository.getCustomerByID(id);
    }
    
    public static String generateNewID(){
        return CustomerRepository.generateNewID();
    }
    
    public static boolean checkUserNameExist(String username){
        return CustomerRepository.checkUserNameExist(username);
    }
    
    public static void updateCustomer(Customer c){
        CustomerRepository.inforUserUpdate(c);
    }
}
