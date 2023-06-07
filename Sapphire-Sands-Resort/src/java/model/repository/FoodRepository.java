package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.config.DBConnect;
import model.entity.Food;
import model.service.FoodService;
import sun.print.resources.serviceui;

public class FoodRepository {
    
    
    public static List<Food> getListFood(){
        List<Food> list = new ArrayList<>();
        String query = "Select * from Food";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();  
            while(rs.next()) {
                list.add(new Food(
                        rs.getNString(1), 
                        rs.getNString(2), 
                        rs.getDouble(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        List<Food> list = new ArrayList<>();
        list = FoodService.getFood();
    }
}
