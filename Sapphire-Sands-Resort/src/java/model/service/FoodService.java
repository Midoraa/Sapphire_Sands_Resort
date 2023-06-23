package model.service;

import java.util.List;
import model.entity.Food;
import model.entity.FoodCart;
import model.repository.FoodRepository;

public class FoodService {
    
    public static List<Food> getFood(){
        return FoodRepository.getListFood();
    }  
    
    public static String resetCookieCart(String txt){
        return FoodRepository.resetCookieCart(txt);
    }
    
    public static List<FoodCart> getFoodCart(String txt){
        return FoodRepository.getListFoodCart(txt);
    }
    
    public static void insertOrderDetail(String txt, String orderID){
        FoodRepository.insertintoOrderDetail(txt, orderID);
    }
    
    public static List<FoodCart> updateQuantityFood(String txt, String foodID, int num){
        return FoodRepository.updateQuantityFood(txt, foodID, num);
    }
    
    public static String deleteFoodCart(String txt, String foodID){
        return FoodRepository.deleteFoodCart(txt, foodID);
    }
}
