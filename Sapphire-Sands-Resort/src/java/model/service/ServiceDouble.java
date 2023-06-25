package model.service;

import java.util.List;
import model.entity.Service;
import model.entity.ServiceCart;
import model.repository.ServiceRepository;

public class ServiceDouble {
    public static List<Service> getService(){
        return ServiceRepository.getListService();
    } 
    
    public static String resetCookieCart(String txt){
        return ServiceRepository.resetCookieCart(txt);
    }
    
    public static List<ServiceCart> getServiceCart(String txt){
        return ServiceRepository.getListServiceCart(txt);
    }
    
    public static void insertServiceDetail(String txt, String orderID){
        ServiceRepository.insertintoServiceDetail(txt, orderID);
    }
    
    public static List<ServiceCart> updateQuantityService(String txt, String serviceID, int num){
        return ServiceRepository.updateQuantityService(txt, serviceID, num);
    }
    
    public static String deleteServiceCart(String txt, String serviceID){
        return ServiceRepository.deleteServiceCart(txt, serviceID);
    }
}