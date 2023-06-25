package model.service;

import java.util.List;
import model.entity.FoodCart;
import model.entity.OrderCart;
import model.entity.RoomCart;
import model.entity.ServiceCart;
import model.repository.YourCartRepository;

public class YourCartService {
    public static List<FoodCart> getYourCartFood(String orderID) {
        return YourCartRepository.getYourCartFood(orderID);
    }
    
    public static List<ServiceCart> getYourCartService(String orderID) {
        return YourCartRepository.getYourCartService(orderID);
    }
    
    public static List<RoomCart> getYourCartRoom(String orderID){
        return YourCartRepository.getYourCartRoom(orderID);
    }

    public static List<OrderCart> getYourCartOrder(String cusID) {
        return YourCartRepository.getYourCartOrder(cusID);
    }
    
    public static double getTotalPrice(String orderID){
        return YourCartRepository.getTotalPrice(orderID);
    }
}