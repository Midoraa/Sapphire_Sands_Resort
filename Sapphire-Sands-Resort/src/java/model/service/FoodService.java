package model.service;

import java.util.List;
import model.entity.Food;
import model.repository.FoodRepository;

public class FoodService {
    
    public static List<Food> getFood(){
        return FoodRepository.getListFood();
    }  
}
