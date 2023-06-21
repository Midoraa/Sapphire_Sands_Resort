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
import model.entity.ServiceCart;

public class ServiceCartRepository {

    public static void insertServiceOrder(String orderID, String txt) {
//        Get real time for Service Order in mysql type Timestamp
        Timestamp orTime = new Timestamp(System.currentTimeMillis());

        List<ServiceCart> listCart = new ArrayList();

        String[] serviceID = null;
        int[] amount = null;

        if (!txt.isEmpty() && txt.length() != 0) {

            String[] id_amount = txt.split("/");

            for (String element : id_amount) {
                String f[] = element.split(":");
                listCart.add(new ServiceCart(orderID, f[0], orTime, Integer.parseInt(f[1]), 0));
            }

        }
        
        for (ServiceCart serviceCart : listCart) {

            try (Connection conn = DBConnect.getConnection()) {
                //        Insert into OrderDetail Value('OD000001', 'F000003', '2023-06-17 06:43:27.13', 2, 0);
                String query = "Insert into ServiceDetail (orderID, serviceID, svTime, Amount, svStatus) Value(?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, serviceCart.getOrderID());
                ps.setString(2, serviceCart.getServiceID());
                ps.setTimestamp(3, serviceCart.getSvTime());
                ps.setInt(4, serviceCart.getAmount());
                ps.setInt(5, serviceCart.getSvStatus());

                ps.executeUpdate();
                ps.close();

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("================Loi INSERT ServiceDetail trong Service Repo===============");
            }

        }

    }

//    Make Shop Cart with Cookie save in User Client.
//    Get List Food had insert into Cookie and return List Cart include: FoodID, FoodName, FoodPrice, FoodAmount.
    public static List<ServiceCart> getListServiceCart(String txt) {
        List<ServiceCart> listCart = new ArrayList();
        String[] serviceID = null;
        int[] amount = null;
        if (!txt.isEmpty() && txt.length() != 0) {
//            List chứa tạm thời
            List<ServiceCart> var = new ArrayList();
            String[] id_amount = txt.split("/");
            for (String element : id_amount) {
                String f[] = element.split(":");
                var.add(new ServiceCart(f[0], Integer.parseInt(f[1])));
            }

            Map<String, Integer> map = new HashMap<>();

            for (ServiceCart serviceCart : var) {
                if (serviceCart.getAmount() >= 1) {
                    if (map.containsKey(serviceCart.getServiceID())) {
                        map.put(serviceCart.getServiceID(), map.get(serviceCart.getServiceID()) + serviceCart.getAmount());
                    } else {
                        map.put(serviceCart.getServiceID(), serviceCart.getAmount());
                    }
                }
            }

            var.clear();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                var.add(new FoodCart(entry.getKey(), entry.getValue()));
                String query = "Select serviceID, serviceName, servicePrice\n"
                        + "From Service \n"
                        + "Where serviceID = ?";
                try (Connection conn = DBConnect.getConnection()) {
                    PreparedStatement ps = conn.prepareStatement(query);
//                        ps.setString(1, food);
                    ps.setString(1, entry.getKey());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        listCart.add(new ServiceCart(rs.getNString(1), rs.getString(2), rs.getDouble(3), entry.getValue()));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
        return listCart;
    }

//    Update Amount in Shop Cart add or remove 1 food
    public static List<ServiceCart> updateAmount(String txt, String serviceID, int num) {
        List<ServiceCart> listCart = new ArrayList();
        listCart = getListServiceCart(txt);

        for (ServiceCart f : listCart) {
            if (f.getServiceID().equals(serviceID)) {
                if (f.getAmount() + num != 0) {
                    f.setAmount(f.getAmount() + num);
                }
            }
        }
        System.out.println(serviceID);
        return listCart;
    }

//    Delete one Food when click remove in food_cart_form.jsp
    public static List<ServiceCart> deleteCart(String txt, String serviceID) {
        List<ServiceCart> listCart = new ArrayList();
        listCart = getListServiceCart(txt);
        listCart.removeIf(ServiceCart -> ServiceCart.getServiceID().equals(serviceID));
        return listCart;
    }

    public static void main(String[] args) {
//        String txt = "F000001:1/F000003:1/F000004:2/F000002:1/F000001:1/F000002:2/F000003:1/F000004:3/F000004:5/F000004:6/F000004:3/F000004:2/F000004:2/F000004:2/F000002:2/F000006:1";
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
//        String txt1 = "F000004:6/F000003:5/F000002:3";
//        List<FoodCart> list = new ArrayList<>();
//        list = FoodCartService.deleteCart(txt1, "F000003");
//        System.out.println(list.toString());
//        
//        FoodCartService.insertFoodOrder("OD000005", txt1);

    }
}
