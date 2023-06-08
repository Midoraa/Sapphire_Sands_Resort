package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.config.DBConnect;
import model.entity.FoodCart;
import model.service.FoodCartService;

public class FoodCartRepository {
    
//    Get List Food Cart in Database
    public static List<FoodCart> getListFood(String cusID){
        List<FoodCart> list = new ArrayList<>();
        String query = "Select a.cusID, a.orderID, b.foodID, c.foodName, c.foodPrice, b.Amount, a.orDate ,a.orStatus \n" +
                        "from `Order` a join OrderDetail b join Food c \n" +
                        "on a.orderID = b.orderID and b.foodID = c.foodID\n" +
                        "where a.cusID = ? ";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cusID);
            ResultSet rs = ps.executeQuery();  
            while(rs.next()) {
                list.add(new FoodCart(
                        rs.getNString(1),
                        rs.getNString(2),
                        rs.getNString(3),
                        rs.getNString(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getDate(7),
                        rs.getBoolean(8)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
//    Get Total Money of item had order
    public static long getTotalPrice(String cusID){
        String query="Select Sum(foodPrice*Amount)\n" +
                        "from `Order` a join OrderDetail b join Food c \n" +
                        "on a.orderID = b.orderID and b.foodID = c.foodID\n" +
                        "where a.cusID = ?";
        long totalPrice = 0;
        try(Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cusID);
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {                
                return rs.getLong(1);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return 0;
    }
    
//    Count Item in shop cart
    public static int getTotalItem(String cusID){
        String query="Select Count(b.foodID)\n" +
                        "from `Order` a join OrderDetail b join Food c \n" +
                        "on a.orderID = b.orderID and b.foodID = c.foodID\n" +
                        "where a.cusID = ?";
        long totalPrice = 0;
        try(Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cusID);
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {                
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
        List<FoodCart> list = new ArrayList<>();
        list = FoodCartService.getFoodCart("CUS000002");
        System.out.println(list.toString());
        long total = FoodCartService.getTotalPrice("CUS000002");
        System.out.println(total);
    }
}
