package model.service;

import model.entity.Customer;
import model.repository.CustomerRepository;

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
}
