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
import model.service.FoodCartService;

public class FoodCartRepository {

//    Get List Food Cart in Database
    public static List<FoodCart> getListFoodOrder(String cusID){
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
//                list.add(new FoodCart(
//                        rs.getNString(1),
//                        rs.getNString(2),
//                        rs.getNString(3),
//                        rs.getNString(4),
//                        rs.getDouble(5),
//                        rs.getInt(6),
//                        rs.getDate(7),
//                        rs.getBoolean(8)
//                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    
//    Get Total Money of item had order
//    public static long getTotalPrice(String cusID) {
//        String query = "Select Sum(foodPrice*Amount)\n"
//                + "from `Order` a join OrderDetail b join Food c \n"
//                + "on a.orderID = b.orderID and b.foodID = c.foodID\n"
//                + "where a.cusID = ?";
//        long totalPrice = 0;
//        try (Connection conn = DBConnect.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, cusID);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                return rs.getLong(1);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            e.printStackTrace();
//        }
//        return 0;
//    }

//    Count Item in shop cart
//    public static int getTotalItem(String cusID) {
//        String query = "Select Count(b.foodID)\n"
//                + "from `Order` a join OrderDetail b join Food c \n"
//                + "on a.orderID = b.orderID and b.foodID = c.foodID\n"
//                + "where a.cusID = ?";
//        long totalPrice = 0;
//        try (Connection conn = DBConnect.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, cusID);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            e.printStackTrace();
//        }
//        return 0;
//    }


    
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
                if (f.getAmount()+num != 0) {
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

    public static void main(String[] args) {
        String txt = "F000001:1/F000003:1/F000004:2/F000002:1/F000001:1/F000002:2/F000003:1/F000004:3/F000004:5/F000004:6/F000004:3/F000004:2/F000004:2/F000004:2/F000002:2/F000006:1";
//        List<FoodCart> list = new ArrayList<>();
//        list = FoodCartService.getListCart(txt);
//        System.out.println(list.toString());
//        list = FoodCartService.updateAmount(txt, "F000001", 1);
//        System.out.println(list.toString());

//        List<FoodCart> list = new ArrayList<>();
////        list = FoodCartService.getFoodCart("CUS000002");
////        System.out.println(list.toString());
//        long total = FoodCartService.getTotalPrice("CUS000002");
//        System.out.println(total);
//        
//        list = FoodCartService.getListCart("F000001");
//        System.out.println(list.toString());
        String txt1 = "F000004:6/F000003:5/F000002:3";
        List<FoodCart> list = new ArrayList<>();
        list = FoodCartService.deleteCart(txt1, "F000003");
        System.out.println(list.toString());
        
    }
}
