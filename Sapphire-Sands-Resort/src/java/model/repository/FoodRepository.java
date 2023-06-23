package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.config.DBConnect;
import model.entity.Food;
import model.entity.FoodCart;

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
    
     public static String resetCookieCart(String txt) {

        String[] id_amount = txt.split("/");
        String cookieCart = "";

        Map<String, Integer> map = new HashMap<>();

        for (String element : id_amount) {
            String[] e = element.split(":");

            String id = e[0];
            int amount = Integer.parseInt(e[1]);

            if (map.containsKey(id)) {
                map.put(id, map.get(id) + amount);
            } else {
                map.put(id, amount);
            }

        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!cookieCart.isEmpty()) {
                cookieCart = cookieCart + "/" + entry.getKey() + ":" + entry.getValue();
            } else {
                cookieCart = entry.getKey() + ":" + entry.getValue();
            }

        }
        return cookieCart;
    }

    public static List<FoodCart>  getListFoodCart(String txt){
//        Reset lại chuỗi cookie đầu vào cho đúng form: ID:Amount
        
        List<FoodCart> list = new ArrayList<>();
        
        String [] id_amount = txt.split("/");
        
        for (String element : id_amount) {
            String [] e = element.split(":");
            String query = "Select * from Food where foodID = ?";
            try(Connection conn = DBConnect.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, e[0]);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {                    
                    list.add(new FoodCart(rs.getString(1), rs.getNString(2), Integer.parseInt(e[1]), rs.getDouble(3)));
                    System.out.println(rs.getString(1));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return list;
    }
    
    public static void insertintoOrderDetail(String txt, String orderID){
        
        Timestamp orTime = new Timestamp(System.currentTimeMillis());
        
        String [] id_amount = txt.split("/");
        
        for (String element : id_amount) {
            String query = "Insert into OrderDetail(orderID, foodID, orTime, Amount, orStatus) Values(?,?,?,?,?)";
            String [] el = element.split(":");
            try(Connection conn = DBConnect.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, orderID);
                ps.setString(2, el[0]);
                ps.setTimestamp(3, orTime);
                ps.setInt(4, Integer.parseInt(el[1]));
                ps.setInt(5, 0);
                
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static List<FoodCart> updateQuantityFood(String txt, String foodID ,int num){
        List<FoodCart> list = new ArrayList<>();
        list = getListFoodCart(txt);
        
        for (FoodCart s : list) {
            if (s.getFoodID().equals(foodID)) {
                if (s.getAmount() + num >= 1) {
                    s.setAmount(s.getAmount() + num);
                }
            }
        }       
        return list;
    }
    
    
    public static String deleteFoodCart(String txt, String foodID){
        String cookieCart = "";
        
        List<FoodCart> list = new ArrayList<>();
        list = getListFoodCart(txt);
        
        list.removeIf(FoodCart -> FoodCart.getFoodID().equals(foodID));
        
        for (FoodCart s : list) {
            if (cookieCart != null) {
                cookieCart = cookieCart + "/" + s.getFoodID() + ":" + s.getAmount();
            }else
                cookieCart = s.getFoodID() + ":" + s.getAmount();
        }
        
        return cookieCart;
    }
    
    
    
//    public static void main(String[] args) {
//        List<Food> list = new ArrayList<>();
////        list = FoodService.getFood();
//        list = getListFood();
//        System.out.println(list.toString());
//    }
}
