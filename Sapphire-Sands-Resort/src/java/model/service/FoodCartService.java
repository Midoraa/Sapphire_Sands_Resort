package model.service;

import java.util.List;
import model.entity.FoodCart;
import model.repository.FoodCartRepository;

public class FoodCartService {
//    public static List<FoodCart> getFoodCart(String cusID){
//        return FoodCartRepository.getListFood(cusID);
//    }  
    
//    public static long getTotalPrice(String cusID){
//        return FoodCartRepository.getTotalPrice(cusID);
//    }
    
//    public static int getTotalItem(String cusID){
//        return FoodCartRepository.getTotalItem(cusID);
//    }
    
    public static List<FoodCart> getListCart(String txt){
        return FoodCartRepository.getListCart(txt);
    }  
    
    public static List<FoodCart> updateAmount(String txt, String foodID, int num){
        return FoodCartRepository.updateAmount(txt, foodID, num);
    }
    
    public static List<FoodCart> deleteCart(String txt, String foodID){
        return FoodCartRepository.deleteCart(txt, foodID);
    }
}
