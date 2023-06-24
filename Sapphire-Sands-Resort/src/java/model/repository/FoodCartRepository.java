package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.config.DBConnect;
import model.entity.FoodCart;
import java.sql.*;

public class FoodCartRepository {

    public static void insertFoodOrder(String orderID, String txt) {
//        Get real time for Food Order in mysql type Timestamp
        Timestamp orTime = new Timestamp(System.currentTimeMillis());

        List<FoodCart> listCart = new ArrayList();

        String[] foodID = null;
        int[] amount = null;

        if (!txt.isEmpty() && txt.length() != 0) {

            String[] id_amount = txt.split("/");

            for (String element : id_amount) {
                String f[] = element.split(":");
                listCart.add(new FoodCart(orderID, f[0], orTime, Integer.parseInt(f[1]), 0));
            }

        }
        
        for (FoodCart foodCart : listCart) {

            try (Connection conn = DBConnect.getConnection()) {
                //        Insert into OrderDetail Value('OD000001', 'F000003', '2023-06-17 06:43:27.13', 2, 0);
                String query = "Insert into OrderDetail (orderID, foodID, orTime, Amount, orStatus) Value(?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, foodCart.getOrderID());
                ps.setString(2, foodCart.getFoodID());
                ps.setTimestamp(3, foodCart.getOrTime());
                ps.setInt(4, foodCart.getAmount());
                ps.setInt(5, foodCart.getOrStatus());

                ps.executeUpdate();
                ps.close();

            } catch (Exception e) {
                System.out.println(e);
                System.err.println("Error: Insert into table OrderDetail Fail!");
            }

        }

    }

//    Make Shop Cart with Cookie save in User Client.
//    Get List Food had insert into Cookie and return List Cart include: FoodID, FoodName, FoodPrice, FoodAmount.
    public static List<FoodCart> getListCart(String txt) {
        List<FoodCart> listCart = new ArrayList();
        String[] foodID = null;
        int[] amount = null;
        if (!txt.isEmpty() && txt.length() != 0) {
//            List chứa tạm thời
            List<FoodCart> var = new ArrayList();
            String[] id_amount = txt.split("/");
            for (String element : id_amount) {
                String f[] = element.split(":");
                var.add(new FoodCart(f[0], Integer.parseInt(f[1])));
            }

            Map<String, Integer> map = new HashMap<>();

            for (FoodCart foodCart : var) {
                if (foodCart.getAmount() >= 1) {
                    if (map.containsKey(foodCart.getFoodID())) {
                        map.put(foodCart.getFoodID(), map.get(foodCart.getFoodID()) + foodCart.getAmount());
                    } else {
                        map.put(foodCart.getFoodID(), foodCart.getAmount());
                    }
                }
            }

            var.clear();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                var.add(new FoodCart(entry.getKey(), entry.getValue()));
                String query = "Select foodID, foodName, foodPrice\n"
                        + "From Food \n"
                        + "Where foodID = ?";
                try (Connection conn = DBConnect.getConnection()) {
                    PreparedStatement ps = conn.prepareStatement(query);
//                        ps.setString(1, food);
                    ps.setString(1, entry.getKey());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        listCart.add(new FoodCart(rs.getNString(1), rs.getString(2), rs.getDouble(3), entry.getValue()));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.err.println("Error: Get List Food Cart Fail!");
                }
            }

        }
        return listCart;
    }

//    Update Amount in Shop Cart add or remove 1 food
    public static List<FoodCart> updateAmount(String txt, String foodID, int num) {
        List<FoodCart> listCart = new ArrayList();
        listCart = getListCart(txt);

        for (FoodCart f : listCart) {
            if (f.getFoodID().equals(foodID)) {
                if (f.getAmount() + num != 0) {
                    f.setAmount(f.getAmount() + num);
                }
            }
        }
        System.out.println(foodID);
        return listCart;
    }

//    Delete one Food when click remove in food_cart_form.jsp
    public static List<FoodCart> deleteCart(String txt, String foodID) {
        List<FoodCart> listCart = new ArrayList();
        listCart = getListCart(txt);
        listCart.removeIf(FoodCart -> FoodCart.getFoodID().equals(foodID));
        return listCart;
    }

}
