package model.service;

import java.util.List;
import model.entity.FoodCart;
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

    public static List<RoomCart> getYourCartRoom(String orderID) {
        return YourCartRepository.getYourCartRoom(orderID);
    }

}
